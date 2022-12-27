package org.LeetcodeProblems.Easy;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateElementsInArray {
    /*
    1. find duplicate elements
    2. elements should not be repetitive
     */

    public static void main(String[] args) {
        Long timeStart = System.currentTimeMillis();
        Long timeEnd;
        int[] arr = new int[]{2,5,2,4,2,6,3,4};
        List<Integer> duplicateElements = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++){
            if (!checkRepetitive(arr[i],duplicateElements)) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        if (!checkRepetitive(arr[i], duplicateElements))
                            duplicateElements.add(arr[i]);
                    }
                }
            }
        }
        timeEnd = System.currentTimeMillis();
        System.out.println(duplicateElements);
        System.out.println("took : "+(timeEnd-timeStart)+" ms");
    }

    public static boolean checkRepetitive(int a,List<Integer> b){
        for (int n : b){
            if (n==a)
                return true;
        }
        return false;
    }
}
