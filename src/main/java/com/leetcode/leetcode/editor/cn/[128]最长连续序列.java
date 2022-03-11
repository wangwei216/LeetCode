//给定一个未排序的整数数组，找出最长连续序列的长度。 
//
// 要求算法的时间复杂度为 O(n)。 
//
// 示例: 
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。 
// Related Topics 并查集 数组 
// 👍 582 👎 0


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 第一种解法：
     * 思路就是先把所有的值都放到set集合中，然后顺序递增元素的值，看是不是在集合中，找出最大的值
     *  优化之后
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // 这个最大值用来更新最终统计结果
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int count = 0;
            // 找到每个元素，然后对某个元素进行依次递减找比他小的值，是不是在set集合中存在，如果存在就进行count
            while (set.contains(x)) {
                x = x -1;
                count++;
            }
            // count 是从每个元素往下找连续递减且set集合都有的统计，然后一直更新给全局的统计变量中
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
