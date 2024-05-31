package org.LeetcodeProblems.Medium;

import java.util.Arrays;

public class RotateArrayByKsteps {
    /*
    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
     */

    public static void main(String[] args) {
        int k = 2;
        rotate(new int[]{-1,-100,3,99},k);
    }

    public static void rotate(int[] nums, int k) {
        int last = nums[k];
        for(int i = 0; i < k; i++){
            int temp = nums[i];
            nums[i] = nums[nums.length-k+i];
            nums[(k+i)%(nums.length-1)] = temp;
        }
        nums[k+k]=last;
        System.out.println(Arrays.toString(nums));
    }
}
