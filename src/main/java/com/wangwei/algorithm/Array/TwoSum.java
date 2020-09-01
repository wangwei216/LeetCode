package com.wangwei.algorithm.Array;

import java.util.HashMap;

/**
 * @Description TwoSum
 * @Date 2020/8/31
 * @Author wangwei
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();
        int[] test = {2, 10, 7, 11, 15};
        int[] sum = twoSum.twoSum(test, 9);
        for (int i = 0; i < sum.length; i++) {
            System.out.println(sum[i]);
        }
    }


}
