package org.LeetcodeProblems.Hard;

public class RegularExpMatch {
    /*
    Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Constraints:

1 <= s.length <= 20
1 <= p.length <= 30
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
     */

    public static void main(String[] args) {
        System.out.println(isMatch("ab","a.*b"));
    }

    public static boolean isMatch(String s, String p) {

        if (p.equals(".*") || s.equals(p)) return true;

        boolean star = false;

        char[] exp = new char[s.length()];

        int index = s.length()-1;

        for (int i = s.length()-1; i >= 0;i--){
            if (p.charAt(i) == '*'){
                star = true;
                continue;
            }else if(star){
                if (p.charAt(i) == '.') {
                    exp[index--] = s.charAt(i - 1);
                    if (p.charAt(i--) == s.charAt(0));
                }
            }else{
                if (p.charAt(i) != s.charAt(i))
                    return false;
                else
                    exp[index--] = p.charAt(i);
            }
        }

        return false;
    }
}
