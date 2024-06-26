package org.LeetcodeProblems.Medium;

public class StringToInteger {
    /*
    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
Note:

Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.

Constraints:

0 <= s.length <= 200
s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
     */

    public static void main(String[] args) {
        System.out.println(myAtoi("-21474836460"));
    }

    public static int myAtoi(String s) {

        int sign = 1;
        int num = 0;
        boolean signPresent = false;
        boolean addNegativeLimit = false;
        int limit = (int) Math.pow(2, 31);
        for (char c : s.toCharArray()) {
            if ((c == '-' || c == '+') && !signPresent) {
                if (c == '-') sign *= -1;
                signPresent = true;
                continue;
            }
            if (num == 0 && c == '0') {
                signPresent = true;
                continue;
            }
            if (num == 0 && c == ' ' && !signPresent) continue;
            if (!Character.isDigit(c)) break;
            else {
                signPresent = true;
                long newNum = num * 10L + Character.digit(c, 10);
                num = Math.max(0, (int) Math.min(newNum, limit));

                addNegativeLimit = newNum > limit;

                if (num == limit) {
                    break;
                }
            }
        }

        if (sign == -1 && addNegativeLimit)
            num += 1;

        return num * sign;
    }
}
