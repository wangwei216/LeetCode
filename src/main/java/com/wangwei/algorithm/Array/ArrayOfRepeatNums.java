package com.wangwei.algorithm.Array;

import java.util.HashMap;

/**
 * @Description 查询数组中重复的数字
 * @Date 2020/7/16
 * @Author wangwei
 */
public class ArrayOfRepeatNums {

    private int findRepeatNumber(int[] nums) {
        int tmp = -1;
        HashMap map = new HashMap(nums.length);
        for (int num : nums) {
            if (map.containsKey(num)) {
                tmp = num;
                break;
            } else {
                map.put(num, num);
            }
        }
        return tmp;
    }

}
