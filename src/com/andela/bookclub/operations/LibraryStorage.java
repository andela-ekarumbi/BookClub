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
        return null;
    }

    private int searchItemByUniqueId(String uniquePropertyName, String uniquePropertyValue) {
        return -1;
    }

    public boolean updateItemDetails(String uniquePropertyName, String uniquePropertyValue, T incomingItem) {
        return false;
    }

    public boolean deleteItem(String uniquePropertyName, String uniquePropertyValue) {
        return false;
    }
}
