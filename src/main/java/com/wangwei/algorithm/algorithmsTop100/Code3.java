package com.wangwei.algorithm.algorithmsTop100;

import java.util.HashMap;
import java.util.Map;

public class Code3 {

    public static void main(String[] args) {
        Code3 code3 = new Code3();
        int max = code3.lengthOfLongestSubstring("abba");
        System.out.printf(String.valueOf(max));
    }

    /**
     * 无重复字符的最长子串 3
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s.length() == 0) {
            return 0;
        }
        // 这个Map 里面的 key 是单个字符， value 是字符对应的下标的位置
        HashMap<Character,Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                // 就是当遇到重复的字符的时候，把窗口左边界重置到重复的下一个位置上
                start = Math.max(start, map.get(c) + 1);
            }
            // 维护窗口的最大值
            res = Math.max(res, end - start + 1);
            map.put(c, end);
        }
        return res;
    }

    /**
     *      *      * 滑动窗口算法
     *      *      * 1、什么时候应该移动 right 扩大窗口？窗口加入字符时，应该更新哪些数据？
     *      *      * 2、什么时候窗口应该暂停扩大，开始移动 left 缩小窗口？从窗口移出字符时，应该更新哪些数据？
     *      *      * 3、我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0 , right = 0 , maxCount = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 判断窗口是否需要收缩，其实就是看维护的窗口中，是否已经出现过该字符串，如果已经出现过一次了的话，那么就需要
            while (window.get(c) > 1) {
                char removeChar = s.charAt(left);
                left++;
                window.put(removeChar, window.getOrDefault(removeChar, 0) - 1);
            }

            maxCount = Math.max(maxCount, right - left);
        }
        return maxCount;
    }

}
