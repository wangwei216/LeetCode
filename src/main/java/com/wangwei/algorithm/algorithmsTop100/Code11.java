package com.wangwei.algorithm.algorithmsTop100;

public class Code11 {
    /**
     * 双指针法
     * 盛最多水的容器
     */
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length -1;

        while (left < right) {
            int maxValue = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, maxValue);

            // 主要是控制左右指针的移动， 你如果移动较低的那一边，那条边可能会变高，使得矩形的高度变大，进而就「有可能」使得矩形的面积变大
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
