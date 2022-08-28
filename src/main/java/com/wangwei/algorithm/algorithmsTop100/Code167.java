package com.wangwei.algorithm.algorithmsTop100;

public class Code167 {
    /**
     * 两数之和 2
     * 返回有序数组的两个元素之和 是 target 的两个下标
     * 二分法
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (target == sum) {
                // 因为题目要求都是从下标 1 开始
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
