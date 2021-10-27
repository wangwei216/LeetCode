//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 回溯 二叉树 
// 👍 603 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        List<Integer> list = new ArrayList();
        // 需要把根节点的值先放进去，dfs中只处理左右子节点，和处递归退出的条件
        list.add(root.val);
        dfs(root, targetSum, root.val, list);
        return res;
    }

    public void dfs(TreeNode root, int targetSum, int sum, List<Integer> resList) {
        // 最终递归结束的时候才会走这个判断
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                res.add(new ArrayList<>(resList));
            }
            return;
        }

        if (root.left != null) {
            resList.add(root.left.val);
            dfs(root.left, targetSum, sum + root.left.val, resList);
            resList.remove(resList.size() - 1);
        }
        if (root.right != null) {
            resList.add(root.right.val);
            dfs(root.right, targetSum, sum + root.right.val, resList);
            resList.remove(resList.size() - 1);
        }
    }


    /**
     * 第二种方法 回溯方法
     */
    int sum = 0;
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, new ArrayList<>(), targetSum);
        return list;
    }
    public void dfs(TreeNode root, List<Integer> path, int targetSum) {
        // 最终的递归退出条件就是根节点为 null 的时候
        if (root == null) {
            return;
        }
        sum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == sum) {
            list.add(new ArrayList<>(path));
        }

        dfs(root.left, path, targetSum);
        dfs(root.right, path, targetSum);
        // 把上一步结束时放进去的值，再从path中回退，而且累加的值也需要减去
        path.remove(path.size() -1);
        sum -= root.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
