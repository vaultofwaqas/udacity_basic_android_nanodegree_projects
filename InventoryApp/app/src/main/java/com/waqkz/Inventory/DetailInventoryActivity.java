package com.waqkz.Inventory;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.waqkz.Inventory.data.InventoryContract;


public class DetailInventoryActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int CURRENT_INVENTRY_LOADER = 0;

    private Uri CurrentInventoryUri;

    TextView CurrentProductNameTextView;
    TextView CurrentProductQuantityTextView;
    TextView CurrentProductPriceTextView;

    Button CurrentDeleteInventoryButton;
    Button CurrentOrderInventoryButton;
    Button CurrentSaveInventoryButton;
    Button CurrentSaleInventoryButton;

    ImageView CurrentSaleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_inventory);

        Intent intent = getIntent();

        CurrentInventoryUri = intent.getData();

        getLoaderManager().initLoader(CURRENT_INVENTRY_LOADER, null, this);

        CurrentProductNameTextView = (TextView) findViewById(R.id.product_detail_name);
        CurrentProductQuantityTextView = (TextView) findViewById(R.id.product_detail_quantity);
        CurrentProductPriceTextView = (TextView) findViewById(R.id.product_detail_price);

        CurrentDeleteInventoryButton = (Button) findViewById(R.id.product_detail_delete);
        CurrentOrderInventoryButton = (Button) findViewById(R.id.product_detail_order);
        CurrentSaveInventoryButton = (Button) findViewById(R.id.product_detail_quantity_save);
        CurrentSaleInventoryButton = (Button) findViewById(R.id.product_detail_sale);

        CurrentSaleImageView = (ImageView) findViewById(R.id.inventory_detail_photo);

        saveCurrentInventoryClicker();

        orderCurrentInventoryClicker();

        saleCurrentInventoryClicker();

        deleteCurrentInventoryClicker();

    }

    private void orderCurrentInventoryClicker() {

        CurrentOrderInventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");

                String intentString = "Order Inventory: " + CurrentProductNameTextView.getText().toString() +
                        " Quantity: 1 " + " Price: " + CurrentProductPriceTextView.getText().toString();

                intent.putExtra(Intent.EXTRA_TEXT, intentString);

                startActivity(intent);
            }
        });
    }

    private void saleCurrentInventoryClicker(){

        CurrentSaleInventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int CurrentQuantity = Integer.parseInt(CurrentProductQuantityTextView.getText().toString());

                if (CurrentQuantity == 0){

                    return;
                }else {
                CurrentQuantity--;}

                ContentValues values = new ContentValues();
                values.put(InventoryContract.InventoryEntry.COLUMN_INVENTORY_QUANTITIY, CurrentQuantity);

                int CurrentRowQuantitySave = getContentResolver().update(CurrentInventoryUri, values, null, null);

                if (CurrentRowQuantitySave == 0) {
                    Toast.makeText(DetailInventoryActivity.this, getString(R.string.current_product_sale_failed), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DetailInventoryActivity.this, getString(R.string.current_product_sale_successful), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveCurrentInventoryClicker(){

        CurrentSaveInventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContentValues values = new ContentValues();
                values.put(InventoryContract.InventoryEntry.COLUMN_INVENTORY_QUANTITIY, CurrentProductQuantityTextView.getText().toString());

                int CurrentRowQuantitySave = getContentResolver().update(CurrentInventoryUri, values, null, null);

                if (CurrentRowQuantitySave == 0) {
                    Toast.makeText(DetailInventoryActivity.this, getString(R.string.inventory_quantity_save_failed), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DetailInventoryActivity.this, getString(R.string.inventory_quantity_save_successful), Toast.LENGTH_SHORT).show();
                }

                finish();
            }
        });
    }

    private void deleteCurrentInventoryClicker(){

        CurrentDeleteInventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int CurrentRowDeleted = getContentResolver().delete(CurrentInventoryUri, null, null);

                if (CurrentRowDeleted == 0) {
                    Toast.makeText(DetailInventoryActivity.this, getString(R.string.inventory_delete_failed), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DetailInventoryActivity.this, getString(R.string.inventory_delete_successful), Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {

        String[] projection = {

                InventoryContract.InventoryEntry._ID,
                InventoryContract.InventoryEntry.COLUMN_INVENTORY_NAME,
                InventoryContract.InventoryEntry.COLUMN_INVENTORY_QUANTITIY,
                InventoryContract.InventoryEntry.COLUMN_INVENTORY_PRICE,
                InventoryContract.InventoryEntry.COLUMN_INVENTORY_KEY_IMAGE,
        };

        // This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(this,   // Parent activity context
                CurrentInventoryUri,   // Provider current content URI to query
                projection,             // Columns to include in the resulting Cursor
                null,                   // No selection clause
                null,                   // No selection arguments
                null);                  // Default sort order

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {

            int CurrentProductNameColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_INVENTORY_NAME);
            int CurrentProductQuantityColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_INVENTORY_QUANTITIY);
            int CurrentProductPriceColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_INVENTORY_PRICE);
            int CurrentImageColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_INVENTORY_KEY_IMAGE);

            String CurrentInventoryName = cursor.getString(CurrentProductNameColumnIndex);
            String CurrentInventoryQuantity = cursor.getString(CurrentProductQuantityColumnIndex).toString();
            String CurrentInventoryPrice = cursor.getString(CurrentProductPriceColumnIndex).toString();
            byte[] CurrentInventoryImage = cursor.getBlob(CurrentImageColumnIndex);

            CurrentProductNameTextView.setText(CurrentInventoryName);
            CurrentProductQuantityTextView.setText(CurrentInventoryQuantity);
            CurrentProductPriceTextView.setText(CurrentInventoryPrice + " Rs.");

            CurrentSaleImageView.setImageBitmap(BitmapFactory.decodeByteArray(CurrentInventoryImage, 0, CurrentInventoryImage.length));
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
