//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 200 👎 0


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
     * 使用dfs递归解法: 核心就是求二叉搜索树的第k大（中序遍历的 左 根 右），其实就是倒序遍历的第K个（右 根 左）
     *  1. 首先得先熟悉二叉搜索树如果是
     */
    int res;
    int count;
    public int kthLargest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        // 每递归一次，则表示遍历完了一个节点，所以目标k值减一，为0时说明找到了值，返回结果
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        dfs(root.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
