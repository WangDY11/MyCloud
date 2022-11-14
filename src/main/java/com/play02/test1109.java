package com.play02;

/**
 * @author wdy
 * @Description 把数字翻译成字符串
 * @createTime 2022年11月08日
 */
public class test1109 {

    public static void main(String[] args) {
//        System.out.println(translateNum(506));
        System.out.println(translateNum(12258));
    }


    public static int translateNum(int num) {
        String str = String.valueOf(num);

        int p0 = 1;
        int p1 = 1;
        int temp = 1;
        for (int i = 1; i < str.length(); i++) {

            String pre = str.substring(i - 1, i + 1);
//            System.out.println(pre);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0 ){
                temp = p0 + p1;
                p0 = p1;
                p1 = temp;
            }else {
                temp = p1;
                p0 = p1;
                p1 = temp;
            }
        }
        return temp;
    }
}
