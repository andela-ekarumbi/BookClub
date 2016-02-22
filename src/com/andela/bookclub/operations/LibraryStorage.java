package com.andela.bookclub.operations;

import com.andela.bookclub.models.Model;

import java.util.ArrayList;
import java.util.List;

public class LibraryStorage<T extends Model> {

    private List<T> items;

    public LibraryStorage() {
        this.items = new ArrayList<>();
    }

    public boolean addNewItem(T item) {
        return items.add(item);
    }

    public boolean addItemCollection(List<T> incomingItems) {
        if (incomingItems != null) {
            for (T item : incomingItems) {
                addNewItem(item);
            }
            return true;
        }
        return false;
    }

    public List<T> getAllItems() {
        return items;
    }

    public T getItemByUniqueId(String uniquePropertyName, String uniquePropertyValue) {
        int foundPosition = searchItemByUniqueId(uniquePropertyName, uniquePropertyValue);

        if (foundPosition != -1) {
            return items.get(foundPosition);
        }
        return null;
    }

    private int searchItemByUniqueId(String uniquePropertyName, String uniquePropertyValue) {
        return Utility.searchByPropertyValue(items, uniquePropertyName, uniquePropertyValue);
    }

    public boolean updateItemDetails(String uniquePropertyName, String uniquePropertyValue, T incomingItem) {
        T existingItem = getItemByUniqueId(uniquePropertyName, uniquePropertyValue);

        if (existingItem != null) {
            return Utility.copyFieldsFromObject(existingItem, incomingItem);
        }
        return false;
    }

    public boolean deleteItem(String uniquePropertyName, String uniquePropertyValue) {
        int deleteIndex = searchItemByUniqueId(uniquePropertyName, uniquePropertyValue);

        if (deleteIndex != -1) {
            items.remove(deleteIndex);
            return true;
        }
        return false;
    }
}
