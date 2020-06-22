package com.practice.google;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
https://leetcode.com/problems/valid-parentheses/

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true

Example 2:

Input: "()[]{}"
Output: true

Example 3:

Input: "(]"
Output: false


 */
public class ValidParanthesis {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0 )
            return true;
        if(s.length() %2 != 0)
            return false;
        Map<Character,Character> m = new HashMap<>();
        m.put(')','(');
        m.put('}','{');
        m.put(']','[');
        Stack<Character> stack= new Stack<>();
        for (char c : s.toCharArray()) {

            if(!m.containsKey(c) ){
                stack.push(c);
            } else {
                if(stack.isEmpty())
                    return false;
                Character ch = m.get(c);
                Character d = stack.pop();
                if(!d.equals(ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParanthesis vp = new ValidParanthesis();
        System.out.println(vp.isValid("()"));
        System.out.println(vp.isValid("([)]"));
    }
}
