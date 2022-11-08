package com.play02;

/**
 * @author wdy
 * @createTime 2022年10月31日
 */
public class tests1108 {

    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
    }


    public static int cuttingRope(int n) {
        /**
         * 推论二： 尽可能将绳子以长度 3 等分为多段时，乘积最大。
         *
         * 切分规则：
         * 最优： 3 。把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 0,1,2 三种情况。
         * 次优： 2 。若最后一段绳子长度为 2 ；则保留，不再拆为 1+1 。
         * 最差： 1 。若最后一段绳子长度为 1 ；则应把一份 3+1 替换为 2+2，因为 2 * 2 > 3 * 1。
         */
        if (n <= 3) return n - 1;

        int a = n % 3;
        int b = n/3;
        if (a == 0){
            return (int) Math.pow(3, b);
        }
        if (a == 1){
            return (int) Math.pow(3, b - 1) * 4;
        }
        return (int) Math.pow(3, b) * 2;
    }

}
