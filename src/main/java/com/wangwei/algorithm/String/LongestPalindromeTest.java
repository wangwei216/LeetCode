package com.wangwei.algorithm.String;

import java.util.HashMap;

/**
 * @Description LongestPalindromeTest
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * @Date 2020/9/1
 * @Author wangwei
 * 使用的是中心扩散法
 */
public class LongestPalindromeTest {

    public LongestPalindromeTest() {
    }

    public String longestPalindrome(String s) {
        int maxLen = 1;
        if (s.length() < 2) {
            return s;
        }
        //考虑到如果只有两位字符的情况下，最长回文其实就是第一个字符
        String resuslt = s.substring(0,1);
        for (int i = 0; i < s.length() - 1; i++) {
            // 对奇数进行中心扩散
            String oddStr = centerSpread(s, i, i);
            // 对偶数进行中心扩散
            String evenStr = centerSpread(s, i, i + 1);

            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                resuslt = maxLenStr;
            }
        }
        return resuslt;
    }

    private String centerSpread(String s, int left, int right) {
        int length = s.length();
        while (left >= 0 && right < length) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }

    // TODO 还可以使用动态规划进行优化
    public static void main(String[] args) {
        LongestPalindromeTest test = new LongestPalindromeTest();
        String max = test.longestPalindrome("baccad");
        System.out.println(max);
    }

}
