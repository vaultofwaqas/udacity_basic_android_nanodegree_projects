package com.waqkz.Inventory;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.waqkz.Inventory.data.InventoryContract;

/**
 * Created by Waqas on 9/5/2016.
 */
public class InventoryCursorAdapter extends CursorAdapter {

    public InventoryCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return LayoutInflater.from(context).inflate(R.layout.list_items, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView ProductNameTextView = (TextView) view.findViewById(R.id.product_name_textview);
        TextView ProductPriceTextView = (TextView) view.findViewById(R.id.product_price_textview);
        TextView ProductQuantityTextView = (TextView) view.findViewById(R.id.product_quantity_textview);

        int ProductNameColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_INVENTORY_NAME);
        int ProductPriceColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_INVENTORY_PRICE);
        int ProductQuantityColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_INVENTORY_QUANTITIY);

        String InventoryName = cursor.getString(ProductNameColumnIndex);
        String InventoryPrice = cursor.getString(ProductPriceColumnIndex).toString();
        String InventoryQuantity = cursor.getString(ProductQuantityColumnIndex).toString();

        ProductNameTextView.setText(InventoryName);
        ProductPriceTextView.setText(InventoryPrice + " Rs.");
        ProductQuantityTextView.setText(InventoryQuantity);

    }
}
