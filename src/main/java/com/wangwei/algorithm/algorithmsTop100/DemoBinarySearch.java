package com.wangwei.algorithm.algorithmsTop100;

public class DemoBinarySearch {
    /**
     * 二分算法
     * 给你一个值和 一个有序数组，然后在数据中找到并且返回其对应的下标，否则返回 -1
     */
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid =(left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return -1;
    }


}
