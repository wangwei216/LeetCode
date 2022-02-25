//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3]
//
//       1
//      / \
//     2   3
//
//输出：6
// 
//
// 示例 2： 
//
// 输入：[-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出：42 
// Related Topics 树 深度优先搜索 
// 👍 749 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

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
    /**
     * 第一种方法 递归
     *  1. 其实就是要求一个二叉树的左右次根子树的最大值，那就分别求两边的最大值
     *  2. 求得两边的最大值，最后再加上根节点的值，但是根节点有可能是负数
     */
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        if (root == null) {
            return 0;
        }
        // 这里需要考虑到左、右部分都有可能是负数
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        res = Math.max(res, leftMax + rightMax + root.val);
        // 计算当前节点能为父亲 提供的最大贡献值，看看左边和右边哪个更大
        int max = Math.max(leftMax + root.val , rightMax + root.val);
        return max < 0 ? 0 : max;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
