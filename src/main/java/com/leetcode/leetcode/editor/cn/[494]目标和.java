//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 
//
// 示例： 
//
// 输入：nums: [1, 1, 1, 1, 1], S: 3
//输出：5
//解释：
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 
//
// 提示： 
//
// 
// 数组非空，且长度不会超过 20 。 
// 初始的数组的和不会超过 1000 。 
// 保证返回的最终结果能被 32 位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 508 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int result = 0;

    /**
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        // 这里的0表示从数组中的0位置开始递归
        helper(nums, S, 0);
        return result;
    }

    /**
     * 这里的index代表的是数组的下标
     *
     * @param nums
     * @param sum
     * @param p
     */
    public void helper(int[] nums, int sum, int index) {
        // 递归的结束条件就是当下标等于数组的长度，就说明递归子循环结束了，并且当之和为0时，就进行计数
        if (index >= nums.length) {
            if (sum == 0) {
                result++;
            }
            return;
        }
        helper(nums, sum + nums[index], index + 1);
        helper(nums, sum - nums[index], index + 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
