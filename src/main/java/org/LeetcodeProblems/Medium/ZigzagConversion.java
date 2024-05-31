package org.LeetcodeProblems.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ZigzagConversion {
    /*
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     (you may want to display this pattern in a fixed font for better legibility)

    Input: s = "PAYPALISHIRING", numRows = 3
    Output: "PAHNAPLSIIGYIR"

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
     */
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) return s;
        HashMap<Integer, List<Character>> map = new HashMap<>();
        int count = 0;
        boolean goDown = true;
        for (char c : s.toCharArray()) {
            List<Character> chars = new ArrayList<>();
            if (map.containsKey(count))
                chars = map.get(count);
            chars.add(c);
            map.put(count, chars);
            if (count == 0 || (count < numRows - 1 && goDown)) {
                count++;
                goDown = true;
            } else {
                goDown = false;
                count--;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int key : map.keySet()) {
            for (char c : map.get(key)) res.append(c);
        }
        return res.toString();
    }
}
