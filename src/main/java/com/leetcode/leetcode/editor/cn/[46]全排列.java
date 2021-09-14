//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 929 👎 0


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 使用回溯算法
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        // 因为你是需要回溯的，所以还需要一个数据结构进行保存我们的路径，好进行回撤
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, res, 0, isUsed, path);
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> res, int deth, boolean[] isUsed, Deque<Integer> path) {
        // 首先需要考虑的是结束条件，其实就是递归的层次，因为递归一次，就是深度 + 1，如果数组中的值都被用完的时候，也就是递归结束
        if (deth == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        // 然后进行一次遍历，其实就是选不同的初始数，把每一个值都先放到路径队列中，然后一直进行递归，直到递归条件结束
        // 最后开始回撤路径，重置状态，再回到原来准备选初始数的时候
        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                path.addLast(nums[i]);
                isUsed[i] = true;
                dfs(nums, res, deth + 1, isUsed, path);
                isUsed[i] = false;
                path.removeLast();
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
