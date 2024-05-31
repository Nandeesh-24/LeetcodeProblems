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

    public static int reverse(int x) {
        int rev = 0;
        int length = (int) (Math.log10(Math.abs(x))+1);
        int limit = (int) Math.pow(2,31);

        while(x != 0){
            rev += (x%10) * Math.pow(10,length-1);
            length--;
            x /= 10;
        }

        if (rev < -1*limit || rev > (limit-1)) return 0;

        return rev;
    }
}
