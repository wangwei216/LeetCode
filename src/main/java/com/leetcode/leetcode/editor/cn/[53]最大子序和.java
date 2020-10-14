//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2448 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 动态转移方程是
     * dp[]
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null){
            return 0;
        }
        //需要先创建一个dp数组，表示以节点i结束的最大序列和
        int[] dp = new int[nums.length];
        //表示dp的起点位置
        int max = nums[0];
        //保证dp[0]中的值是存在的
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
