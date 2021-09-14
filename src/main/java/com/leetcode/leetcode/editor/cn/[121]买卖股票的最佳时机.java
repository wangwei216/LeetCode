//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划 
// 👍 1240 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 第一种是先进行暴力计算
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxFix = 0;
        for (int i = 0; i < prices.length; i++) {
            // 这里从i + 1 开始的意思是卖出的利润必须是N+1
            for (int j = i + 1; j < prices.length; j++) {
                maxFix = Math.max(maxFix, (prices[j] - prices[i]));
            }
        }
        return maxFix;
    }

    /**
     * 第二种使用动态规划
     * 需要定义一下：db[i] 表示第i天卖出的最大利润 db[i]
     * 那么最大的利润 =  第 i-1 天卖出的最大利润  + 当天的利润差
     */
    public int maxProfit(int[] prices) {
        int pre = 0; // 表示前一天卖出的最大利润
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            // 因为也可能今天的价格低于昨天的价格，那当天的利润就是负数了，需要置为0
            pre = Math.max(pre + diff, 0);
            sum = Math.max(sum, pre);
        }
        return sum;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
