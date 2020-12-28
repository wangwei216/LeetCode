//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 609 👎 0


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 第一种方式是使用暴力进行解答
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        if (n == 0) {
            return nums;
        }
        for (int i = 0; i < res.length; i++) {
            int max = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            res[i] = max;
        }
        return res;
    }

    /**
     * 第二种方式是使用双向队列来实现的
     * 第一个队列是用来保存临时窗口中的所有值，为了利用这个队列找到当前临时窗口中的最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 1。先考虑特殊情况 为空 或者 只有一个值
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        // 2. 用来保存当前窗口的最大值，来保证队列中的第一位一直都是最大值
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length + 1 - k];
        // 3. 遍历数组，
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!queue.isEmpty() && nums[i] >= queue.peekFirst()) {
                queue.pollLast();
            }
            // 这里是因为要判断队首的值是否在窗口范围内，由数组下标取值很方便，而由值取数组下标不是很方便。
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
