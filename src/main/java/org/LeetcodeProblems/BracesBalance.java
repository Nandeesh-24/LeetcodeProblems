package org.LeetcodeProblems;

import java.util.Stack;

public class BracesBalance {
    static char[][] tokens = new char[][]{{'{','}'},{'(',')'},{'[',']'}};

    public static void main(String[] args) {
        String expression = "[{}{}]";

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
