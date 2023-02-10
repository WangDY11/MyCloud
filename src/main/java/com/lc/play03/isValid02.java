package com.lc.play03;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author wdy
 * @Description 20. 有效的括号
 * @createTime 2023年02月09日
 */
public class isValid02 {

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
    //  map + stack
    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        LinkedList<Character> stack = new LinkedList();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else if (!stack.isEmpty() && (c == map.get(stack.peek()))){
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