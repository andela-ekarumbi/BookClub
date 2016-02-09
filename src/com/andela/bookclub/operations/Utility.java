package com.andela.bookclub.operations;

import com.andela.bookclub.models.Model;

import java.util.Collections;
import java.util.List;

public class Utility {

    // Utility static search method

    public static int searchById(List<? extends Model> list, String id) {

        // First sort the list list

        Collections.sort(list);

        // Then do a binary search for the member with the given id

        int start = 0;

        int length = list.size();

        if (length == 0) {
            return  -1;
        }

        if (length == 1) {
            if (list.get(0).getId().equals(id)) {
                return 0;
            } else {
                return  -1;
            }
        }

        int end = length - 1;

        while (start <= end) {

            if (list.get(start).getId().equals(id)) {
                return start;
            }

            if (list.get(end).getId().equals(id)) {
                return end;
            }

            int mid = Math.floorDiv((start + end), 2);

            if (list.get(mid).getId().equals(id)) {
                return mid;
            } else {

                if (list.get(mid).getId().compareTo(id) < 0) {
                    end = mid - 1;
                    start += 1;
                } else {
                    start = mid + 1;
                    end -= 1;
                }
            }
        }

        return -1;
    }
}
