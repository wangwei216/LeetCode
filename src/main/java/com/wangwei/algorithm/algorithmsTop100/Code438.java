package com.wangwei.algorithm.algorithmsTop100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code438 {

    /**
     * 找到字符串中所有字母异构词
     *
     *      * 滑动窗口算法
     *      * 1、什么时候应该移动 right 扩大窗口？窗口加入字符时，应该更新哪些数据？
     *      * 2、什么时候窗口应该暂停扩大，开始移动 left 缩小窗口？从窗口移出字符时，应该更新哪些数据？
     *      * 3、我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        /**
         * 1。先把目标字符串放到目标窗口中
         * 2。窗口向右移动遍历整个字符串
         *     a.如果目标窗口中包含，那就需要把这个字符放到维护的滑动窗口中去
         *     b.需要判断这个滑动窗口中的字符是不是和目标字符相等，如果相等就需要一个全局变量来更新需要维护的那个滑动窗口的数量
         * 3。滑动窗口需要收缩，把可能符合结果（也就是滑动窗口的大小只要等于目标字符串的长度）的都需要左指针向右移动
         *     a.在满足上面有可能出现符合结果的前提下，那么就是把真正符合结果（其实就是滑动窗口维护的全局变量值和当前滑动窗口中的size相同时）的情况，给保存到结果中
         *     b.因为在收缩滑动窗口的时候，其实就是在剔除滑动窗口中的值，同时还需要维护滑动窗口的全局变量值
         */
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            target.put(p.charAt(i), target.getOrDefault(p.charAt(i), 0) + 1);
        }

        int left =0, right = 0, count = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (target.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (target.get(c).equals(window.get(c))) {
                    count++;
                }
            }

            // 缩减窗口
            while (right - left == p.length()) {
                if (count == target.size()) {
                    res.add(left);
                }
                char removeChar = s.charAt(left);
                left++;

                if (target.containsKey(removeChar)) {
                    if (target.get(removeChar).equals(window.get(removeChar)) ) {
                        count--;
                    }
                    window.put(removeChar, window.getOrDefault(removeChar, 0) - 1);
                }
            }
        }
        return res;
    }
}
