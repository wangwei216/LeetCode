package com.leetcode.leetcode.editor.cn;//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 593 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int length = candidates.length;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(res, candidates, target, path, 0);
        return res;
    }

    /**
     *
     * @param res 结果集
     * @param candidates 参数
     * @param target 目标值
     * @param path  选择的路径，好进行回溯
     * @param begin 搜索的起点
     */
    public void dfs(List<List<Integer>> res, int[] candidates, int target, Deque<Integer> path, int begin) {
        if (target < 0){
            return;
        }
        //如果结果集
        if (target == 0){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            //先进行把这个路径放到path中，
            path.addLast(candidates[i]);
            //这里继续进行下一个节点的递归，只有当最后的值为0或者小于0的时候才算结束，就是不会生成新的节点继续往下走了
            dfs(res, candidates, target - candidates[i] , path, i);
            //这里其实就是回溯，如果上一步失败了就还能回来
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
