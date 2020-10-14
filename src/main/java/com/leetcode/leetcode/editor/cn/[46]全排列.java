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

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayQueue<>();
        Boolean[] isUsed = new Boolean[];
        dfs(res, 0, nums, path, isUsed);
        return res;
    }

    public void dfs(ArrayList<List<Integer>> res, int deepth, int[] nums, Deque<Integer> path, Boolean[] isUsed) {
        if (deepth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                path.addLast(nums[i]);
                isUsed[i] = true;
                dfs(res, deepth + 1, nums, path, isUsed);
                isUsed[i] = false;
                path.removeLast();
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
