package com.wangwei.algorithm.Array;

/**
 * @Description MaxArea
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * @Date 2020/9/2
 * @Author wangwei
 */
public class MaxArea {
    /**
     * 使用双指针进行完成
     *  1. 循环的截止条件就是当左右指针碰头的时候，结束循环时间复杂度O(n)
     *  2. 因为是求矩形面积，所以是谁的指针下标的值小，就需要那个指针进行移动下一个【因为大的那个值有可能是下一次求面积的时候的较大值】
     *  3. 然后把每次计算的面积值都和之前的最大值进行比较
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxAreaResult = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                maxAreaResult = Math.max(maxAreaResult, height[left] * (right - left));
                left++;
            } else {
                maxAreaResult = Math.max(maxAreaResult, height[right] * (right - left));
                right--;
            }
        }
        return maxAreaResult;
    }

    public static void main(String[] args) {
        int[] test = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        MaxArea maxArea = new MaxArea();
        int result = maxArea.maxArea(test);
        System.out.println(result);
    }

}
