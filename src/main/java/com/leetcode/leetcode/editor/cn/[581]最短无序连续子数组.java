//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 你找到的子数组应是最短的，请输出它的长度。 
//
// 示例 1: 
//
// 
//输入: [2, 6, 4, 8, 10, 9, 15]
//输出: 5
//解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 说明 : 
//
// 
// 输入的数组长度范围在 [1, 10,000]。 
// 输入的数组可能包含重复元素 ，所以升序的意思是<=。 
// 
// Related Topics 数组 
// 👍 447 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 第一种使用暴力进行解决
     * 核心其实就是
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        // 通过和最大的边界比获取到最小的最短的连续无序数组的左边界，通过和0比获取目标数组的最大值
        int L = nums.length;
        int R = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    L = Math.min(L, i);
                    R = Math.max(R, j);
                }
            }
        }
        return R - L > 0 ? R - L + 1 : 0;
    }

    /**
     * 第二种使用双指针的方法，时间复杂度O（n）
     * 1. 主要思路就是
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int R = 0, L = nums.length;
        int max = nums[0];
        int min = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            // 从左遍历找右指针
            if (nums[i] < max) {
                R = i;
            } else {
                max = nums[i];
            }
            // 从右遍历找左指针
            if (nums[nums.length - 1 - i] > min) {
                L = nums.length - 1 - i;
            } else {
                min = nums[nums.length - 1 - i];
            }
        }
        return R - L > 0 ? R - L + 1 : 0;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
