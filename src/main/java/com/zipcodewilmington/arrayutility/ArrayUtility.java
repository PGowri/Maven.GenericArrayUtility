package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {
    private T[] array;

    // Constructor
    public ArrayUtility(T[] inputArray) {
        array = inputArray;
    }

//    public Integer CountDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){
//
//    }
//
//    public T getMostCommonFromMerge(T[] arrayToMerge) {
//
//    }

    public Integer getNumberOfOccurrences(T valueToEvaluate){
        int count = 0;
        for(int i =0; i < array.length; i++){
            if(array[i].equals(valueToEvaluate)){
                count ++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove){
        T[] temp= (T[]) Array.newInstance(valueToRemove.getClass(), array.length- getNumberOfOccurrences(valueToRemove));
        int j =0;
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(valueToRemove)){
                continue;
            }
            temp[j]= array[i];
            j++;
        }
        array = temp;
        return temp;
    }
}
