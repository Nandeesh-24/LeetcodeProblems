package org.LeetcodeProblems.Medium;

import java.util.Arrays;

public class TripletSumClosestToTarget {

    /*
    Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.
     */

    public static void main(String[] args) {
        int target = -2;
        int[] nums = new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5};
        System.out.println(threeSumClosest(nums, target));

    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3)
            return Arrays.stream(nums).sum();

        Arrays.sort(nums); // --> O(nlogn)
        int nearestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            if (i == 0 || nums[i] != nums[i - 1]) {
                while (start < end) {
                    int sum = nums[start] + nums[end] + nums[i];
                    int diff = sum - target;
                    if (Math.abs(diff) == 0)
                        return sum;
                    else if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                    if (Math.abs(sum - target) < Math.abs(nearestSum - target))
                        nearestSum = sum;
                }
            }
        }

        return nearestSum;
    }
}
