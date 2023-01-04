package org.LeetcodeProblems.Hard;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    /*
    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
     */
    public static void main(String[] args) {
        System.out.println(findMedian(new int[]{1,3},new int[]{2,4}));
    }

    public static double findMedian(int[] nums1, int[] nums2){
        int[] resultArr = new int[nums1.length + nums2.length];
        int count = 0;
        for (int j : nums1) {
            resultArr[count++] = j;
        }
        for (int j : nums2) {
            resultArr[count++] = j;
        }
        Arrays.sort(resultArr);

        if (resultArr.length % 2 != 0)
            return resultArr[resultArr.length/2];
        else
            return (resultArr[resultArr.length/2]+resultArr[resultArr.length/2 - 1]) / 2.0;
    }
}
