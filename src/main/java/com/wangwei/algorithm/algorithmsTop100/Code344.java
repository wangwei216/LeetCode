package com.wangwei.algorithm.algorithmsTop100;

public class Code344 {
    /**
     * 反转字符串
     * 原地修改
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length -1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

}
