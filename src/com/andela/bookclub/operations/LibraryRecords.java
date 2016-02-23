package com.andela.bookclub.operations;

import com.andela.bookclub.models.Model;

import java.util.ArrayList;
import java.util.List;

public class LibraryRecords<T extends Model> {

    private List<T> items;

    public LibraryRecords() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds a new item to the current list.
     * @param item the item to add.
     * @return true for a successful operation, false otherwise.
     * */

    public boolean addNewItem(T item) {
        return items.add(item);
    }

    /**
     * Adds a list of items to the current list.
     * @param incomingItems the list ot=f items to add.
     * @return true for a successful operation, false otherwise.
     * */

    public boolean addItemCollection(List<T> incomingItems) {
        if (incomingItems != null) {
            for (T item : incomingItems) {
                addNewItem(item);
            }
            return true;
        }
        return false;
    }

    /**
     * Returns all items in the current list.
     * @return the current list
     * */

    public List<T> getAllItems() {
        return items;
    }

    /**
     * Returns the item in the current list with the specified
     * unique property value.
     * @param uniquePropertyName the name of the unique property to be
     * used for searching.
     * @param uniquePropertyValue the value of the unique property to be
     * used for searching.
     * */

    public T getItemByUniqueProperty(String uniquePropertyName, String uniquePropertyValue) {
        int foundPosition = searchItemByUniqueProperty(uniquePropertyName, uniquePropertyValue);

        if (foundPosition != -1) {
            return items.get(foundPosition);
        }
        return null;
    }

    private int searchItemByUniqueProperty(String uniquePropertyName, String uniquePropertyValue) {
        return Utility.searchByPropertyValue(items, uniquePropertyName, uniquePropertyValue);
    }

    /**
     * Updates the item with the specified unique property value using
     * the values provided in the updated object.
     * @param uniquePropertyName the name of the unique property to be
     * used for searching.
     * @param uniquePropertyValue the value of the unique property
     * to be used for searching.
     * @param updateItem the item containing the values to be updated.
     * */

    public boolean updateItemDetails(String uniquePropertyName, String uniquePropertyValue, T updateItem) {
        T existingItem = getItemByUniqueProperty(uniquePropertyName, uniquePropertyValue);

        return existingItem != null && Utility.copyFieldsFromObject(existingItem, updateItem);
    }

    /**
     * Deletes the item with the specified unique property value.
     * @param uniquePropertyName the name of the unique property to be
     * used for searching.
     * @param uniquePropertyValue the value of the unique property
     * to be used for searching.
     * */

    public boolean deleteItem(String uniquePropertyName, String uniquePropertyValue) {
        int deleteIndex = searchItemByUniqueProperty(uniquePropertyName, uniquePropertyValue);

        if (deleteIndex != -1) {
            items.remove(deleteIndex);
            return true;
        }
        return false;
    }
}
