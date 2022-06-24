//给定一个二叉树的 root ，确定它是否是一个 完全二叉树 。 
//
// 在一个 完全二叉树 中，除了最后一个关卡外，所有关卡都是完全被填满的，并且最后一个关卡中的所有节点都是尽可能靠左的。它可以包含 1 到 2h 节点之间的最
//后一级 h 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6]
//输出：true
//解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,7]
//输出：false
//解释：值为 7 的结点没有尽可能靠向左侧。
// 
//
// 
//
// 提示： 
//
// 
// 树的结点数在范围 [1, 100] 内。 
// 1 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 176 👎 0


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
     * 第一种方法是 递归
     * 思路：核心其实就是先不考虑每一个二叉树中的值是什么，而是利用完全二叉树的性质，就是判断记录节点数和最大节点编号值是不是相等
     * 如果相等的话，就说明是一个完全二叉树，二叉树最后一层的叶子节点都是排列在左边，且是在最后一层高度
     */
    int count = 0; // 表示这个二叉树上节点的个数
    int p = 0; // 表示递归过程中最新编号

    public boolean isCompleteTree(TreeNode root) {
        // 表示从第一个根节点开始计算，然后进行不断的更新 count 和 p
        dfs(root, 1);
        return count == p;
    }

    // k 表示当前序列的编号
    public void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        count++;
        p = Math.max(p, k);
        dfs(root.left, 2 * k);
        dfs(root.right, 2 * k + 1); //递归左右子树
    }

}
//leetcode submit region end(Prohibit modification and deletion)
