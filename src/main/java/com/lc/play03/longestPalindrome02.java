package com.lc.play03;

/**
 * @author wdy
 * @Description 5. 最长回文子串
 * @createTime 2023年02月03日
 */
public class longestPalindrome02 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("aaaa"));
    }

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }
        int begin = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        // 画图：判断先循环列，后循环行， 其中 J 可以从 1 开始，因为长度为2如果相等直接是true
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < len; i++) {
                if (charArray[i] != charArray[j]){
                    dp[i][j] = false;
                } else {
                    // 如果子串长度是1 或者 2 ,直接返回true，一定是回文子串
                    // 0 1 2 3
                    if (j - i + 1 <= 2){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
