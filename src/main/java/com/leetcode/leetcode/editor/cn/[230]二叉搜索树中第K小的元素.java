//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 104 
// 0 <= Node.val <= 104 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 615 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result = 0;
    int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    public void dfs(TreeNode root , int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        // 首先是因为二叉搜索树 或者 二叉树 最最左叶子节点肯定是最小的那个值，也就是说只要一直递归然后递归到最底部，就能找到第一个最小的值
        // 然后每次遍历一个节点有值的时候，然后找次小值，然后继续递归找右节点
        rank++;
        if (rank == k) {
            result = root.val;
            return;
        }
        dfs(root.right, k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
