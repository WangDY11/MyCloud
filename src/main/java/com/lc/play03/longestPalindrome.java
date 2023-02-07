package com.lc.play03;

/**
 * @author wdy
 * @Description 5. 最长回文子串
 * @createTime 2023年02月03日
 */
public class longestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     */
    public static String longestPalindrome(String s) {
        int begin = 0;
        int max = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1 ; i++) {
            int odd = check(i, i + 1, chars);
            int even = check(i, i, chars);
            int maxI = Math.max(odd, even);
            if (max < maxI){
                max = maxI;
                // 0 1 2 3 4 5 6
                begin = i - (maxI - 1)/2;
            }
        }
        return s.substring(begin, begin + max);
    }

    // 返回长度
    public static int check(int left, int right, char[] chars){
        while (left >=0 && right < chars.length){
            if (chars[left] != chars[right]){
                break;
            }
            left--;
            right++;
        }
        int dex = right - 1 - (left + 1) + 1;
        return dex;
    }
}
