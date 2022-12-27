package org.LeetcodeProblems.Easy;

import java.util.Arrays;

public class TwoSum {
    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {

        int size = nums.length;

        if (size == 2)
            return new int[]{0, 1};

        for (int i = 0; i < size - 1; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                for (int j = i + 1; j < size; j++) {
                    if (nums[i] + nums[j] == target)
                        return new int[]{i, j};

                    if (nums[size - i - 1]+nums[size - j - 1] == target)
                        return new int[]{size - i - 1, size - j - 1};
                }
            }
        }
        return new int[]{0, 0};
    }
}
