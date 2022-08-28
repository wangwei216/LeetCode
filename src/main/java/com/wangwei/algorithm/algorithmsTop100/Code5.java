package com.wangwei.algorithm.algorithmsTop100;

public class Code5 {
    public static void main(String[] args) {
        Code5 code5 = new Code5();
        String result = code5.longestPalindrome("babad");
        System.out.printf(result);

    }
    /**
     * 最长回文子串
     * 找回文串的难点在于，回文串的的长度可能是奇数也可能是偶数，解决该问题的核心是从中心向两端扩散的双指针技巧
     * 枚举法
     */
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            // 奇数
            String res1 = palindrome(s, i, i);
            // 偶数时
            String res2 = palindrome(s, i, i + 1);
            // 找到最长的一个
            result = result.length() > res1.length() ? result : res1;
            result = result.length() > res2.length() ? result : res2;
        }
        return result;
    }

    // 从中间或者某个位置开始去找最长的回文
    // 能包含 奇回文 和  偶回文
    public String palindrome(String s, int l, int r) {
        while (r <= s.length() -1 && l >= 0 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

}
