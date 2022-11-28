package com.play02;

/**
 * @author wdy
 * @Description 剪绳子Ⅱ
 * @createTime 2022年11月28日
 */
public class test112802 {

    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
        System.out.println(cuttingRope(120));
        System.out.println(cuttingRope(127));
    }

    public static int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int p = 1000000007;
        int a = n % 3;
        int b = n/3;
        long m = 1;
        for (int i = 1; i < b; i++) {
            m = (m * 3) % p;
        }
        if (a == 0) return (int) (m * 3 % p);
        // 这样结果出错的原因是因为每一步都进行了取余操作，导致res有可能不是3的整数倍了
        if (a == 1) return (int) (m * 4 % p);
        return (int)(m * 6 % p);
    }
}
