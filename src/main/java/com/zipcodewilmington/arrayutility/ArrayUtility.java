package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    T[] arrayToBeMerged; //generic type array

    public ArrayUtility(T[] inputArray) {
        this.arrayToBeMerged = inputArray;
    }

    //
    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] outputArray = getMergedArray(arrayToMerge);
        Integer count = 0;
        for (T t : outputArray) {
            if (t == valueToEvaluate) {
                count++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        Integer newCount = 0;
        Integer mostCount = 0;
        arrayToBeMerged = getMergedArray(arrayToMerge);
        Object mostCommon = new Object();
        for (int i = 0; i < arrayToBeMerged.length; i++) {
            newCount = getNumberOfOccurrences(arrayToBeMerged[i]);
            if (newCount > mostCount) {
                mostCount = newCount;
                mostCommon = arrayToBeMerged[i];
            }
        }
        return (T) mostCommon;

    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer noOfOccurence = 0;
        for (int i = 0; i < arrayToBeMerged.length; i++) {
            if (arrayToBeMerged[i].equals(valueToEvaluate)) {
                noOfOccurence++;
            }
        }
        return noOfOccurence;
    }

    public T[] removeValue(T valueToRemove) {
        T[] newArray = arrayToBeMerged;
        int count =0;
        int j=0;
        for (int i = 0; i < arrayToBeMerged.length; i++) {
            if (!arrayToBeMerged[i].equals(valueToRemove)) {
                newArray[j] = arrayToBeMerged[i];
                j++;
            }
            else {
                count++;
            }
        }
        T[] result = Arrays.copyOf(newArray, newArray.length-count);

        return result;
    }

    private T[] getMergedArray(T[] arrayToMerge) {
        T[] result = Arrays.copyOf(arrayToBeMerged, arrayToBeMerged.length + arrayToMerge.length);
        System.arraycopy(arrayToMerge, 0, result, arrayToBeMerged.length, arrayToMerge.length);
        return result;
    }

}
