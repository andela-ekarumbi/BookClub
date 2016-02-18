package com.andela.bookclub.operations;

import com.andela.bookclub.models.Model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public class Utility {

    private static String getValueByPosition(List<? extends Model> list, int position, String propertyName){
        try {
            Model objectToCheck = list.get(position);
            Class classObject = objectToCheck.getClass();
            String getterName = getGetterNameFromPropertyName(propertyName);
            Method getter = classObject.getMethod(getterName);
            getter.setAccessible(true);
            String returnValue = (String)getter.invoke(objectToCheck);
            return returnValue;
        } catch (Exception exception) {

        }
        return "";
    }

    private static String getGetterNameFromPropertyName(String propertyName) {
        String firstLetterOfProperty = propertyName.substring(0, 1);
        String remainingLettersOfProperty = propertyName.substring(1, propertyName.length());
        String getterName = "get"
                + firstLetterOfProperty.toUpperCase()
                + remainingLettersOfProperty;
        return getterName;
    }

    /**
     * Takes a list of Model objects and uses the given property name
     * to search for the given search term, using type reflection.
     * @param list The list to be searched.
     * @param propertyName the name of the property to use for searching.
     * @param searchTerm the string to use for searching
     * @return the position of the object with the given id, or -1 if
     * not found.
     * */

    public static int searchByPropertyValue(List<? extends Model> list, String propertyName, String searchTerm) {

        Collections.sort(list);

        int start = 0;

        int length = list.size();

        if (length == 0) {
            return  -1;
        }

        try {
            if (length == 1) {
                if (getValueByPosition(list, 0, propertyName).equals(searchTerm)) {
                    return 0;
                }
                return  -1;
            }

            int end = length - 1;

            while (start <= end) {

                if (getValueByPosition(list, start, propertyName).equals(searchTerm)) {
                    return start;
                }

                if (getValueByPosition(list, end, propertyName).equals(searchTerm)) {
                    return end;
                }

                int mid = Math.floorDiv((start + end), 2);

                if (getValueByPosition(list, mid, propertyName).equals(searchTerm)) {
                    return mid;
                }

                if (getValueByPosition(list, mid, propertyName).compareTo(searchTerm) < 0) {
                    end = mid - 1;
                    start += 1;
                } else {
                    start = mid + 1;
                    end -= 1;
                }

            }
        } catch (Exception exception) {
            String msg = exception.getMessage();
            System.out.print(msg);
        }

        return -1;
    }

    public static boolean copyFieldsFromObject(Object existingObject, Object incomingObject) {
        Class incomingObjectClass = incomingObject.getClass();

        try {
            Field[] fields = incomingObjectClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object incomingValue = field.get(incomingObject);
                if (incomingValue != null) {
                    field.set(existingObject, incomingValue);
                }
            }
            return true;
        } catch (Exception exception) {
            String message = exception.getMessage();
            System.out.print(message);
            return false;
        }
    }
}
