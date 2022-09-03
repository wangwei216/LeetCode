package com.wangwei.algorithm.algorithmsTop100;

import java.util.HashMap;
import java.util.Map;

public class Code576 {


    /**
     *      * 滑动窗口算法
     *      * 1、什么时候应该移动 right 扩大窗口？窗口加入字符时，应该更新哪些数据？
     *      * 2、什么时候窗口应该暂停扩大，开始移动 left 缩小窗口？从窗口移出字符时，应该更新哪些数据？
     *      * 3、我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？
     *
     * 字符串的排列
     * @param s1
     * @param s2
     * @return
     */
    // s1 表示目标字符串，s2 表示需要处理的字符串 各自都会对应一个 window
    public boolean checkInclusion(String s1, String s2) {
        // TODO 定义模版 和初始化数据
        // Map 的 key 表示单个字符，value 表示出现的次数
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = 0; // 其中 count 变量表示窗口中满足 target 条件的字符个数，如果 count 和 目标窗口 的大小相同，则说明窗口已满足条件，已经完全覆盖了串 T
        // TODO 右指针向右滑动扩大窗口
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            // 如果字符在目标Map中出现，那么就需要把这个目标放到滑动窗口Map中，而且还得保证跟目标窗口的该字符出现的次数也得保证一致
            if (target.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 需要更新c 字符出现的次数
                if (window.get(c).equals(target.get(c))) {
                    count++;
                }
            }

            // TODO 左指针向右滑动，收缩窗口的长度，其实就是处理有可能满足条件的结果才移动，如果滑动窗口的长度刚好等于目标字符串的长度，就是有可能符合条件的
            while (right - left == s1.length()) {
                // TODO  根据题意：获取“真正”满足条件的解
                if (count == target.size()) {
                    return true;
                }
                // TODO 左指针向右滑动，寻找下一个最优解
                char removeChar = s2.charAt(left);
                // 缩小窗口，左指针向左移动，
                left++;
                // 从窗口移出字符时，应该更新哪些数据？需要判断移除的字符是不是在目标窗口中，如果在的话继续看次数是不是符合目标窗口
                if (target.containsKey(removeChar)) {
                    if (target.get(removeChar).equals(window.get(removeChar))) {
                        count--;
                    }
                    window.put(removeChar, window.getOrDefault(removeChar, 0) -1);
                }
            }
        }
        return false;
    }

}
