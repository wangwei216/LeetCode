package com.wangwei.algorithm.algorithmsTop100;

import java.util.HashMap;

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

}
