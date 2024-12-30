package org.LeetcodeProblems.Easy;

import java.util.Stack;

public class BracesBalance {
    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
     */
    static char[][] tokens = new char[][]{{'{','}'},{'(',')'},{'[',']'}};

    public static void main(String[] args) {
        String expression = "[{[]}{}]";

        System.out.println(checkBalance(expression) ? "balanced" : "not balanced");
    }

    public static boolean checkBalance(String exp){
        Stack<Character> stack = new Stack<>();

        for (char c : exp.toCharArray()){
            if (isOpenTerm(c)){
                stack.push(c);
            }else{
                if (stack.isEmpty() || !matches(stack.pop(),c)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean matches(char openTerm, char closedTerm) {
        for (char[] token : tokens){
            if (token[0] == openTerm)
                return token[1] == closedTerm;
        }
        return false;
    }

    private static boolean isOpenTerm(char c) {
        for (char[] token : tokens){
            if (token[0] == c)
                return true;
        }
        return false;
    }
}
