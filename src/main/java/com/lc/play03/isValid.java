package com.lc.play03;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author wdy
 * @Description 20. 有效的括号
 * @createTime 2023年02月09日
 */
public class isValid {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("}{"));
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     *  左括号必须用相同类型的右括号闭合。
     *  左括号必须以正确的顺序闭合。
     *  每个右括号都有一个对应的相同类型的左括号。
     */
    //  ascii + stack
    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else if (!stack.isEmpty() && (c - stack.peek() == 1 || c - stack.peek() == 2)){
                // 防止stack.peek()为空，c - stack.peek()报空指针
                stack.pop();
            }else {
                return false;
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }
}