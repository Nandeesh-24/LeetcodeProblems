package org.LeetcodeProblems.Medium;

public class ReverseInteger {
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
