package com.ghstudios.android.data.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.ghstudios.android.data.classes.Item;
import com.ghstudios.android.data.classes.ItemToMaterial;

/**
 * Created by Joseph on 7/7/2016.
 */
public class ItemToMaterialCursor extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public ItemToMaterialCursor(Cursor cursor) {
        super(cursor);
    }

    public ItemToMaterial GetItemToMaterial(){
        if (isBeforeFirst() || isAfterLast())
            return null;

        ItemToMaterial itemToMat = new ItemToMaterial();
        int amount = getInt(getColumnIndex(S.COLUMN_ITEM_TO_MATERIAL_AMOUNT));
        itemToMat.setAmount(amount);

        // Get the Item
        Item item = new Item();
        long itemId = getLong(getColumnIndex(S.COLUMN_ITEM_TO_MATERIAL_ITEM_ID));
        String itemName = getString(getColumnIndex("i" + S.COLUMN_ITEMS_NAME));
        String type = getString(getColumnIndex(S.COLUMN_ITEMS_TYPE));
        int rarity = getInt(getColumnIndex(S.COLUMN_ITEMS_RARITY));
        String fileLocation = getString(getColumnIndex(S.COLUMN_ITEMS_ICON_NAME));

        item.setId(itemId);
        item.setName(itemName);
        item.setType(type);
        item.setRarity(rarity);
        item.setFileLocation(fileLocation);
        itemToMat.setItem(item);

        return itemToMat;
    }

}
