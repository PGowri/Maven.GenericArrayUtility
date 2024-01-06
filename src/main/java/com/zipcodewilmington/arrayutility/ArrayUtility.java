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

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){
        int count = 0;
        T[] mergedArray = concatArrays( array,arrayToMerge);
        for(int i = 0; i<mergedArray.length; i ++) {
            if(mergedArray[i] == valueToEvaluate){
                count ++;
            }
        }
        return count;
    }
    public static <T> T[] concatArrays (T[]array1, T[]array2) {
        int array1length = array1.length;
        int array2length = array2.length;
        int totalLen = array1length + array2length;

        T[] all = getArray(totalLen);
        int copied = 0;
            System.arraycopy(array1, 0, all, copied, array1.length);
            System.arraycopy(array2, copied, all, array1length, array2.length);

        return all;
    }
    public static <T> T[] getArray(int size) {
        T[] genericArray = (T[]) new Object[size];
        return genericArray;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T[] mergedArray = concatArrays( array,arrayToMerge);
        T res = null;
        for(int i = 0; i< array.length; i ++){
            if (mergedArray[i] == array[i]){
                res =  mergedArray[i];
            }
        }
        return res;
    }

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
