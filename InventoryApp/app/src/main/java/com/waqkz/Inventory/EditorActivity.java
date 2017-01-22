package com.waqkz.Inventory;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.waqkz.Inventory.data.InventoryContract;

import java.io.ByteArrayOutputStream;

public class EditorActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;

    EditText mProductNameEditText;
    EditText mProductQuantityEditText;
    EditText mProductPriceEditText;
    Button mSaveProductButton;
    ImageButton mPhotoButton;
    ImageView mPhotoImage;
    Bitmap mPhoto;

    ContentValues values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        mProductNameEditText = (EditText) findViewById(R.id.product_name);
        mProductQuantityEditText = (EditText) findViewById(R.id.product_quantity);
        mProductPriceEditText = (EditText) findViewById(R.id.product_price);

        mPhotoImage = (ImageView) findViewById(R.id.inventory_editor_photo);
        mPhotoButton = (ImageButton) findViewById(R.id.inventory_editor_camera);

        imageButtonClicker();

        mSaveProductButton = (Button) findViewById(R.id.save_product);

        saveButtonClicker();
    }

    public void imageButtonClicker(){

        mPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            mPhoto = (Bitmap) data.getExtras().get("data");
            mPhotoImage.setImageBitmap(mPhoto);
        }
    }

    public void insertImage(Bitmap image){

        byte[] data = getBitmapAsByteArray(image);

        values.put(InventoryContract.InventoryEntry.COLUMN_INVENTORY_KEY_IMAGE, data);
    }

    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }

    public void saveButtonClicker(){

        mSaveProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insertInventory();
                finish();
            }
        });
    }

    private void insertInventory(){

        String productNameString = mProductNameEditText.getText().toString().trim();
        String productQuantityString = mProductQuantityEditText.getText().toString().trim();
        String productPriceString = mProductPriceEditText.getText().toString().trim();

        if(TextUtils.isEmpty(productNameString) || TextUtils.isEmpty(productQuantityString) || TextUtils.isEmpty(productPriceString) || mPhotoImage.getDrawable() == null){

            Toast.makeText(this, "Error: at-least one or all of the Inventory fields were blank.", Toast.LENGTH_SHORT).show();
            return;
        }

        values = new ContentValues();
        values.put(InventoryContract.InventoryEntry.COLUMN_INVENTORY_NAME, productNameString);
        values.put(InventoryContract.InventoryEntry.COLUMN_INVENTORY_QUANTITIY, productQuantityString);
        values.put(InventoryContract.InventoryEntry.COLUMN_INVENTORY_PRICE, productPriceString);

        insertImage(mPhoto);

        Uri newUri = getContentResolver().insert(InventoryContract.InventoryEntry.CONTENT_URI, values);

        if (newUri == null) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving Inventory Product", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Inventory Product saved.", Toast.LENGTH_SHORT).show();
        }
    }
}
