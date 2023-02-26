package de.rafael.search;

import org.jetbrains.annotations.NotNull;

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

    public static void oldSearch(int value, int @NotNull [] data) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == value) {
                count++;
            }
        }

        int[] indices = new int[count];
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == value) {
                indices[index] = i;
                index++;
            }
        }

        if (count > 0) {
            System.out.println("The value " + value + " exists " + count + " times at the positions " + Arrays.toString(indices));
        } else System.out.println("The value does not exists in the Array");
    }

    public static void search(int value, int @NotNull [] data) {
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == value) indexList.add(i);
        }
        if (indexList.size() > 0) {
            System.out.println("The value " + value + " exists " + indexList.size() + " times at the positions " +
                    Arrays.toString(indexList.toArray()));
        } else System.out.println("The value does not exists in the Array");
    }

}
