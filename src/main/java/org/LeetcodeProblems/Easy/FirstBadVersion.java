package org.LeetcodeProblems.Easy;

public class FirstBadVersion extends VersionControl {
    /*
    You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
     */

    public static void main(String[] args) {
        VersionControl.fisrt_bad_version = 1;
        System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        if (n == 1) return 1;
        int start = 0;
        int end = n;

        int last_bad_expression = n;

        while (start < end){
            int mid = (start + end) / 2;
            boolean badVersion = isBadVersion(mid);
            if (!badVersion){
                start = mid+1;
            }
            else{
                last_bad_expression = mid;
                end = mid;
            }
        }

        return last_bad_expression;
    }


}

abstract class VersionControl{
    static int fisrt_bad_version;
    public static boolean isBadVersion(int verison){
        return verison >= fisrt_bad_version;
    }
}


