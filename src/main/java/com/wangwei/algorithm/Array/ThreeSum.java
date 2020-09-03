package com.wangwei.algorithm.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description ThreeSum
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * @Date 2020/9/2
 * @Author wangwei
 */
public class ThreeSum {

    /**
     * 双指针解决的思路：
     * 1. 首先第一个点需要进行排序，而且是升序排列
     * 2. 要最左侧的i 是大于0的话，后面的值相加肯定 > 0，直接break
     * 3. 循环每一个值，从左到右，然后固定左指针 和 右指针，随着i变大，逐渐压缩左右指针的距离
     * A. 如果把三个值相加 == 0，说明符合条件，左右指针都移动
     * B. 如果sum < 0 ,说明left 需要向后走才能变大
     * C. sum > 0 ,说明sum太大了，需要右指针向左走
     *
     * @param nums 需要考虑一种特殊的情况
     *             输入：
     *             [-2,0,0,2,2]
     *             输出：
     *             [[-2,0,2],[-2,0,2]]
     *             预期结果：
     *             [[-2,0,2]]
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //保证顺序一直都是 i -> left -> right，所以只要当i > 0 的时候就不可能 i + left + right = 0
            if (nums[i] > 0) {
                break;
            }
            //因为有可能连续两个值是相同的，说明值相同会导致结果重复，所以应该跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            //然后循环跳出的条件就是左右指针L 和 R 相遇
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    /**
                     *  为了去重复的结果集合
                     *      * 输入：
                     *      * [-2,0,0,2,2]
                     *      * 输出：
                     *      * [[-2,0,2],[-2,0,2]]
                     *      * 预期：
                     *      * [[-2,0,2]]
                     */
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }


        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] test = {-2,0,0,2,2};
        List<List<Integer>> lists = threeSum.threeSum(test);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }

}
