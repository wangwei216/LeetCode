//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1076 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 使用递归判断一个二叉树是不是对称的
     * 1. 其实思路就是把一棵树当成两棵树来进行比较
     * 2. 递归跳出的条件是如果左右两个节点其中又一个节点为Null就返回false， 如果两个节点的值都相同就返回true
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    public boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return (node1.val == node2.val) && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    /**
     * 第二种方法 递归实现(推荐使用)
     */
    public boolean isSymmetric(TreeNode root) {
        // 先处理根节点
        if (root == null) {
            return true;
        }
        // 然后分别递归左右子节点 两边如果都相等的话，才算相等
        return dfs(root.left, root.right);
    }
    public boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null & root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        // 处理左右子节点的左右节点
        return dfs(root1.left, root2.right) && dfs(root1.right , root2.left);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
