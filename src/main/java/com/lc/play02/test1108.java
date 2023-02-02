package com.lc.play02;

/**
 * @author wdy
 * @Description 把数字翻译成字符串
 * @createTime 2022年11月08日
 */
public class test1108 {

    public static void main(String[] args) {
        System.out.println(translateNum(506));
    }// 5 0 6

    public static int translateNum(int num) {
        // 0 - 25
        // f(i) = f(i-1) + f(i-2)
        /**
         * f(1) = 1; 1
         * f(2) = 2; 1,2    12
         * f(3) = 3; 12,2   1,22    1,2,2
         * f(4) = 5; 12,2,5     1,22,5      1,2,2,5     1,2,25      12,25
         * f(5) = 5;
         */
        char[] ch = String.valueOf(num).toCharArray();
        int[] dp = new int[ch.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= ch.length; i++) {
            // 12258
            int n = (ch[i - 2] - '0') * 10 + (ch[i - 1] - '0');
            System.out.println(n);
            if (n >= 10 && n <= 25){
                dp[i] = dp[i - 2] + dp[i - 1];
            }else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[ch.length];
    }

}
