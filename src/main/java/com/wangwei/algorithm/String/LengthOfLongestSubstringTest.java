package com.wangwei.algorithm.String;

import java.util.*;

/**
 * @Description LengthOfLongestSubstringTest
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @Date 2020/8/31
 * @Author wangwei
 * <p>
 * 1. 可以使用滑动窗口的思想解决
 */
public class LengthOfLongestSubstringTest {

    public int lengthOfLongestSubstring(String s) {
        int max = 0; //返回的子串的最大值
        int left = 0, right = 0; //左指针，右指针
        HashMap map = new HashMap();
        if (s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //如果出现之前出现过的字符，需要把左指针更新到之前第一次出现到后一个位置，所以+1，然后更新左指针
                left = Math.max(left, (int) map.get(s.charAt(i)) + 1);
                System.out.println(left);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }

    /**
     * 找到最长子串并打印出来
     *
     * @param s
     * @return
     */
    public int findLengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstringTest test = new LengthOfLongestSubstringTest();
        int max = test.findLengthOfLongestSubstring("pwwkew");
        System.out.println(max);
    }


}
