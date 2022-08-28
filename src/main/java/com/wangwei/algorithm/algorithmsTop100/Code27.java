package com.wangwei.algorithm.algorithmsTop100;

public class Code27 {
    /**
     * 移除元素
     */
    public int removeElement(int[] nums, int val) {
        // 3, 2, 2, 4
        int slow = 0;
        int fast = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;

        }
        return slow;
    }

}
