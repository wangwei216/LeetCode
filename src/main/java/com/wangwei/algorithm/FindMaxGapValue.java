package com.wangwei.algorithm;

/**
 * @Description 给出一个数组，找出数组中相邻的两个数之间的最大差值
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/10 15:18
 */
public class FindMaxGapValue {

    /*
    * 思路就是：用N+1个桶保存N个数组中的元素数值，最大值放最后一个桶，最小值放第一个桶，
    *          那么中间肯定会有一个桶空着，每个桶可以想象成是一个区间的数字，然后找到空桶相邻的非空桶
    * 1.先判断数组是不是为空 或者是是不是只有一个元素
    * 2.然后遍历一遍数组，找到数组中最大值和最小值
    * 3.判断如果最大值和最小值相等说明数组中只有同一个元素
    * 4.然后用三个数组分别记录每一个桶中是否有值、最大值、最小值
    * 5.主要是定位到那个桶中，然后保存每个桶中的信息
    *
    */

    public int findMaxGap(int[] nums){
        if (nums == null || nums.length < 2){
            return 0;
        }
        int lenth = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i =0; i<nums.length; i++){
            max = Math.max(nums[i], max);
            min = Math.min(nums[i],min);
        }
        if (max == min){
            return 0;
        }
        //4 开始进行用三个数组进行当做桶
        Boolean[] hasNum = new Boolean[lenth+1];
        int[] maxs = new int[lenth+1];
        int[] mins = new int[lenth+1];
        //5
        for (int i=0; i<lenth; i++){
            int bid = bucket(nums[i], lenth, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
        }

        return 1;
    }

    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

}
