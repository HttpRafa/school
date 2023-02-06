package de.rafael.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rafael K.
 * @created 9:41 AM, 2/6/2023
 * @project school
 */

public class SearchMain {

    public static void main(String[] args) {
        int[] data = {0, 7, 2, 7, 14, 15, 17, 3, 6};
        search(7, data);
    }

    public static void search(int value, int[] data) {
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if(data[i] == value) {
                count.add(i);
            }
        }
        if(count.size() > 0) {
            System.out.println("The value " + value + " exists " + count.size() + " times at the positions " +
                    Arrays.toString(count.toArray()));
        } else System.out.println("The value does not exists in the Array");
    }

}
