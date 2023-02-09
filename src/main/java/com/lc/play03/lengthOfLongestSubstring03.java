package com.lc.play03;

import java.util.HashSet;

/**
 * @author wdy
 * @Description 3. 无重复字符的最长子串
 * @createTime 2023年02月08日
 */
public class lengthOfLongestSubstring03 {


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
        int r = 0; // 右指针
        HashSet<Character> set = new HashSet();
        for (int i = 0; i < chars.length; i++) {
            if (i > 0){
                // 因为i+1后，所以remove前一项
                set.remove(chars[i - 1]);
            }
            while (r < chars.length && !set.contains(chars[r])){
                set.add(chars[r]);
                ++r;
            }
            // 右指针退出，代表r指向重复的一向
            max = Math.max(max, r - 1 - i + 1);
        }
        return max;
    }
}
