package org.LeetcodeProblems.Medium;

import java.util.HashSet;

public class LongestSubstringWithoutRepetition {
    /*
    Given a string s, find the length of the longest
substring
 without repeating characters.

 0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
     */

    public static void main(String[] args) {
        String s = "bbbbb";

        HashSet<Character> chars = new HashSet<>();

        int maxLength = 0;

        int i = 0; //start pointer
        for (int j = 0; j < s.length(); j++){ //second pointer
            char c = s.charAt(j);
            if (chars.size() == 0 || !chars.contains(c)){
                chars.add(c);
                if (chars.size() > maxLength) maxLength = chars.size();
            }else{
                while (chars.contains(c)){
                    char charAtStart = s.charAt(i++);
                    chars.remove(charAtStart);
                }
                chars.add(c);
            }
        }

        System.out.println(maxLength);
    }


}
