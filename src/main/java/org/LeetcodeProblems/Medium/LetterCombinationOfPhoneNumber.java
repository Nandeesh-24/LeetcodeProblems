package org.LeetcodeProblems.Medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
    /*
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
     */

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

    public static List<String> letterCombinations(String digits) {

        LinkedList<String> combinations = new LinkedList<>();

        if (digits.equals(""))
            return combinations;

        String[] charMap = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        combinations.add("");

        for (int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));

            while (combinations.peek().length() == i){
                String permutation = combinations.remove();
                for (char c : charMap[index].toCharArray()){
                    combinations.add(permutation + c);
                }
            }
        }

        return combinations;
    }
}
