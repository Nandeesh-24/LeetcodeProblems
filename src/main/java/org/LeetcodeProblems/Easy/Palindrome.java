package org.LeetcodeProblems.Easy;

public class Palindrome {
    /*
    Given an integer x, return true if x is a
palindrome
, and false otherwise.

Constraints:

-231 <= x <= 231 - 1
     */

    public static void main(String[] args) {
        System.out.println(isPalindrome1(1));
    }

    public static boolean isPalindrome1(int x) {
        int sum = 0;
        int y = x;
        while(x != 0){
            int rem = x%10;
            sum = sum*10 + rem;
            x/=10;
        }
        return sum/y==1;
    }
}
