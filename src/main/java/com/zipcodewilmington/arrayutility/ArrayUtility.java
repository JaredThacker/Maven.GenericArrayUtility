package com.zipcodewilmington.arrayutility;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E>{

    E[] inputArray;

    public ArrayUtility(E[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(Object[] arrayToMerge, E valueToEvaluate) {
        Integer dupes = 0;
        Object[] merged = new Object[inputArray.length + arrayToMerge.length];
        System.arraycopy(inputArray, 0, merged, 0, inputArray.length);
        System.arraycopy(arrayToMerge, 0, merged, inputArray.length, arrayToMerge.length);

        for (Object obj : merged){
            if (Objects.equals(obj, valueToEvaluate)){
                dupes++;
            }
        }
        return dupes;
    }

    public E[] removeValue(E valueToRemove) {
        ArrayList<Object> arrList = new ArrayList<Object>(Arrays.asList(inputArray));
        arrList.removeAll(Collections.singleton(valueToRemove));
        return arrList.toArray(Arrays.copyOf(inputArray, 0));
    }

    public Integer getNumberOfOccurrences(E valueToEvaluate) {
        Integer occu = 0;
        for (Object obj : inputArray) {
            if (Objects.equals(obj, valueToEvaluate)){
                occu++;
            }
        }
        return occu;
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        Object[] merged = new Object[inputArray.length + arrayToMerge.length];
        System.arraycopy(inputArray, 0, merged, 0, inputArray.length);
        System.arraycopy(arrayToMerge, 0, merged, inputArray.length, arrayToMerge.length);


        Arrays.sort(merged);

        Object previous = merged[0];
        Object popular = merged[0];
        int count = 1;
        int maxCount = 1;

        for (int i = 1; i < merged.length; i++) {
            if (merged[i] == previous)
                count++;
            else {
                if (count > maxCount) {
                    popular = merged[i-1];
                    maxCount = count;
                }
                previous = merged[i];
                count = 1;
            }
        }

        return (E) (count > maxCount ? merged[merged.length - 1] : popular);
    }
}
