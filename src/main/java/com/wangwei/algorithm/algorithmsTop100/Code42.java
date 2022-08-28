package com.wangwei.algorithm.algorithmsTop100;

import com.wangwei.algorithm.Array.MaxArea;

public class Code42 {

    /**
     * 接雨水 42
     * 暴力法
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int res = 0;
        // 需要计算每个 i 位置的 左边最大值 和右边最大值，所以时间复杂度很高
        for (int i = 0; i < height.length; i++) {
            int l_max = 0;
            int r_max = 0;
            // 找到右边最大值
            for (int j = i; j < height.length; j++) {
                r_max = Math.max(r_max, height[j]);
            }
            // 找到左边最大值
            for (int j = i; j >= 0; j--) {
                l_max = Math.max(l_max, height[j]);
            }

            // 只考虑局部的，不考虑全局的
            res += Math.min(l_max, r_max) - height[i];
        }
        return res;
    }

    /**
     * 双指针法
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int l_max = 0;
        int r_max = 0;
        int left = 0;;
        int right = height.length -1;
        int res = 0;
        while (left < right) {
            l_max = Math.max(l_max , height[left]);
            r_max = Math.max(r_max, height[right]);
            // 因为计算的时候是一步步的，并且取决于小那个，所以需要知道左边和右边哪个最小，
            if (l_max < r_max) {
                res += l_max - height[left];
                left++;
            } else {
                res += r_max - height[right];
                right--;
            }
        }
        return res;
    }



}
