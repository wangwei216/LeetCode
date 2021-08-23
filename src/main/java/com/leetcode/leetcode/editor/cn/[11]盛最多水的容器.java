//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 数组 双指针 
// 👍 2410 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 使用暴力法
    public int maxArea(int[] height) {
        int len = height.length - 1;
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                maxArea = Math.max((j - i) * Math.min(height[i], height[j]), maxArea);
            }
        }
        return maxArea;
    }
    /**
     * 使用双指针法
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        // 遍历的跳出条件就是两个指针相遇结束
        while (left < right) {
            // 先计算出接雨水的面积，然后用一个变量保持更新其一直是最大值
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * Math.abs(right - left));
            // 因为双指针一直在循环中，所以要移动双指针
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
