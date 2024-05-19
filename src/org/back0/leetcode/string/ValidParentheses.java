package org.back0.leetcode.string;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/description/

public class ValidParentheses {

    public boolean isValid(String s) {
        var closingParentheses = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {

            char currChar = s.charAt(i);
            if (currChar == '(') {
                closingParentheses.push(')');
            } else if (currChar == '[') {
                closingParentheses.push(']');
            } else if (currChar == '{') {
                closingParentheses.push('}');
            } else if (closingParentheses.empty() || closingParentheses.pop() != currChar) {
                return false;
            }
        }

        return closingParentheses.empty();
    }

}
