//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 811 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (nums.length == 0) {
            return 0;
        }
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        // 给出base case
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        // 需要有一个最大值变量保存，来表示前i个数组中的最大乘积值
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            // 其实需要分类考虑才能推理出来的：
            //  1. 第一种情况其实是dpMax[i-1] > 0 时，那么第i个数组中的乘积最大值就是 nums[i]
            //  2. 第二种情况是dpMax[i-1] <  0 , 但是最小值 如果乘以 nums[i] < 0 那么也可能是最大值
            //  3. 第三种情况是如果dpMax[i-1] = 0，那么其实最大值就是 nums[i] 本身
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], Math.min(dpMin[i - 1] * nums[i], nums[i]));
            max = Math.max(dpMax[i], max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
