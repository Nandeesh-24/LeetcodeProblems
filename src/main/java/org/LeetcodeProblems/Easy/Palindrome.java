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
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        int length = (int) Math.log10(x)+1;
        int i = 0;
        int y = x;
        if(x == 0)
            return true;

        if (x < 0 || x%10 == 0)
            return false;

        while(i <= length/2){
            int right = x%10;
            int left = y/(int)Math.pow(10,length-1-i);
            if(left != right)
                return false;
            x /= 10;
            y %= (int)Math.pow(10,length-1-i);
            i++;
        }

        return true;
    }
}
