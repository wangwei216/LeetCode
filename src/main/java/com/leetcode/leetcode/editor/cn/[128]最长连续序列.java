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

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 第一种解法：直接使用暴力法
     * 思路就是先把所有的值都放到set集合中，然后顺序递增元素的值，看是不是在集合中，找出最大的值
     *  优化之后
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //  然后进行遍历
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            int count = 0;
            while (set.contains(index)) {
                index = index -1;
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
