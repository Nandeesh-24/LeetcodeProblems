package org.LeetcodeProblems.Medium;

import java.util.HashMap;

public class RemoveDuplicatesFromSortedArray {
    /*
    Given an integer array nums sorted in non-decreasing order,
    remove some duplicates in-place such that each unique element appears at most twice.
    The relative order of the elements should be kept the same.

    Since it is impossible to change the length of the array in some languages,
    you must instead have the result be placed in the first part of the array nums.
    More formally, if there are k elements after removing the duplicates,
    then the first k elements of nums should hold the final result.
    It does not matter what you leave beyond the first k elements.

    Return k after placing the final result in the first k slots of nums.
     */

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }

    public static int removeDuplicates(int[] nums) {
        HashMap<Integer,Integer> g = new HashMap<Integer, Integer>();
        int k = 1;
        int r = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && r < 2) {
                nums[k++] = nums[i];
                r++;
            } else if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
                r=1;
            }
        }
        return k;
    }
}
