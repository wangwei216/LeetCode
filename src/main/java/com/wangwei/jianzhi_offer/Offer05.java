/**
 * Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
package com.wangwei.jianzhi_offer;

/**
 * @FileName: Offer05.java
 * @Description: Offer05.java类说明
 * @Author: admin
 * @Date: 2019/6/22 20:31
 */
public class Offer05 {

    /**
     * 字符串替换空格的思路：
     *      1.
     */ 
    public String replaceSpace(StringBuffer str) {
        //p1表示原始的字符串的最后位置的下标
        int p1 = str.length() - 1;
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
                System.out.println("第一次遍历之后为：[" + str.toString() + "]");
            }
        }
        //p2表示增加空格之后的最后位置的下标 在p1的时候遇到一个空格就增加两个空格
        int p2 = str.length() - 1;
        //循环结束的临界条件就是把原本的目标字符串遍历完，然后还要保证p2是一直大于p1的，
        while (p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }


    public static void main(String[] args) {
        Offer05 offer05 = new Offer05();
        StringBuffer stringBuilder = new StringBuffer("We Are Happy ");
        String result = offer05.replaceSpace(stringBuilder);
        System.out.println("打印结果：" + "[" + result + "]");

    }

}
