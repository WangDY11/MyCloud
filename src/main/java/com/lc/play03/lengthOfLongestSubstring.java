package com.lc.play03;

import java.util.HashSet;

/**
 * @author wdy
 * @Description 3. 无重复字符的最长子串
 * @createTime 2023年02月08日
 */
public class lengthOfLongestSubstring {


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
        if (s.length() == 1){
            return 1;
        }
        int max = 0;
        char[] chars = s.toCharArray();
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            if (res.contains(String.valueOf(chars[i]))){
                res = res.substring(res.indexOf(chars[i]) + 1);
            }
            res += chars[i];
            max = Math.max(max, res.length());
        }
        return max;
    }
}
