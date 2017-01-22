package com.waqkz.Inventory.data;

import android.content.ContentResolver;
import android.media.Image;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Waqas on 9/5/2016.
 */
public class InventoryContract {

    private InventoryContract(){}

    public static final String CONTENT_AUTHORITY = "com.waqkz.Inventory.data.InventoryProvider";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_INVENTORIES = "inventories";

    public static final class InventoryEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_INVENTORIES);

        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_INVENTORIES;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_INVENTORIES;

        public final static String TABLE_NAME = "inventories";

        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_INVENTORY_NAME ="name";
        public final static String COLUMN_INVENTORY_QUANTITIY = "quantity";
        public final static String COLUMN_INVENTORY_PRICE = "price";


        public static final String COLUMN_INVENTORY_KEY_IMAGE = "image_name";
    }
}
