package org.LeetcodeProblems.Medium;

public class ReverseInteger {
    /*
    Given a signed 32-bit integer x, return x with its digits reversed.
     If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     */
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static long reverse(int x) {
        long sum = 0;
        while(x != 0){
            int rem = x%10;
            sum = sum*10 + rem;
            x/=10;
        }
        return sum;
    }
}
