package com.lc.play03;

import java.util.HashSet;

/**
 * @author wdy
 * @Description 3. 无重复字符的最长子串
 * @createTime 2023年02月08日
 */
public class lengthOfLongestSubstring02 {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbbcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    /**
     给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            HashSet<Character> set = new HashSet();
            set.add(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                if (set.contains(chars[j])){
                    break;
                }
                set.add(chars[j]);
            }
            max = Math.max(max, set.size());
        }
        return max;
    }
}
