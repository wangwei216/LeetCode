//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 808 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 递归
     */
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean dfs(TreeNode root, long min, long max){
        if (root == null) {
            return true;
        }
        // 因为在递归的时候，当一个root节点传进来的时候，
        // 对于二叉搜索树的左节点来说：他的值的上限就是root的值，对于右结点来说，下限也是rootvalue的值
        if (root.val <= min || root.val >= max) {
            return false;
        }
        // 对于二叉树的递归，都是直接调用递归函数，重复判断左右子节点的套路
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
