package com.play02;

/**
 * @author wdy
 * @Description 把数字翻译成字符串
 * @createTime 2022年11月08日
 */
public class test1114 {

    public static void main(String[] args) {
//        System.out.println(translateNum(506));
        System.out.println(translateNum(12258));
    }


    public static int translateNum(int num) {
        if (num < 10){
            return 1;
        }
        System.out.println(num %100);
        if (num % 100 >=10 && num %100 <= 25){
            return translateNum(num/10) + translateNum(num/100);
        }else {
            return translateNum(num/10);
        }
    }
}
