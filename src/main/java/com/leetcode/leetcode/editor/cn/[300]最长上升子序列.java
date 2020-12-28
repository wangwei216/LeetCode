//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划 
// 👍 1129 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 第一种方法是使用动态规划进行的
     * dp[i]中表示的是前i个元素中输出的最长子序列的长度
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 1;
        // 这里第一次的for循环应该是0开始，因为需要遍历所有数组的个数
        for (int i = 0; i < nums.length; i++) {
            // 这一步的关键就是
            dp[i] = 1;
            // 这一步的遍历是为了判断当前的值是不是都比之前的大
            for (int j = 0; j < i; j++) {
                // 这里进行判断当前i的值是不是大于之前所有的，如果大于就更新dp[i]，dp[i]中表示的是前i个元素中输出的最长子序列的长度
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 这里对遍历完所有的nums中的值，更新进行找出最大的那个长度
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
