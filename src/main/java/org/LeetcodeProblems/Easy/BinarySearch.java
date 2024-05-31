package org.LeetcodeProblems.Easy;

public class BinarySearch {
    /*
    Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.
     */

    public static void main(String[] args) {
        System.out.println(search(new int[]{5},5));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return target == nums[0] ? 0 : -1;

        int start = 0;
        int end = nums.length-1;

        while (start < end){
            int mid = (start + end) / 2;
            int mid_value = nums[mid];
            if (mid_value < target){
                if (nums[end] == target) return end;
                start = mid+1;
            }
            else if (mid_value > target){
                if (nums[start] == target) return start;
                end = mid-1;
            }
            else return mid;
        }

        return -1;
    }
}

