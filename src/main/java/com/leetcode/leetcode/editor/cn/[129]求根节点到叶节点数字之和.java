//给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
// 
// 
// 每条从根节点到叶节点的路径都代表一个数字： 
//
// 
// 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。 
// 
//
// 计算从根节点到叶节点生成的 所有数字之和 。 
//
// 叶节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：25
//解释：
//从根到叶子节点路径 1->2 代表数字 12
//从根到叶子节点路径 1->3 代表数字 13
//因此，数字总和 = 12 + 13 = 25 
//
// 示例 2： 
//
// 
//输入：root = [4,9,0,5,1]
//输出：1026
//解释：
//从根到叶子节点路径 4->9->5 代表数字 495
//从根到叶子节点路径 4->9->1 代表数字 491
//从根到叶子节点路径 4->0 代表数字 40
//因此，数字总和 = 495 + 491 + 40 = 1026
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 1000] 内 
// 0 <= Node.val <= 9 
// 树的深度不超过 10 
// 
// 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 424 👎 0


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
     * 递归方法
     */
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        // 表示一直在更新的最后结果集合
        return dfs(root, sum);
    }

    public int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 因为每递归一层就大一个数量级，加上当前的root节点的值
        sum = sum * 10 + root.val;

        // 只要有一个子节点还有值，就继续往下走
        if (root.left == null && root.right == null) {
            return sum;
        }
        int leftSum = dfs(root.left, sum);
        int rightSum = dfs(root.right, sum);
        return leftSum + rightSum;
    }

    public void dfs(TreeNode root, int number) {
        number = number * 10 + root.val;
        // 把结束时候的每一个叶节点的分支之和都累加到 res 中
        if (root.left == null && root.right == null) {
            res = res + number;
            return;
        }
        if (root.right != null) {
            dfs(root.right, number);
        }
        if (root.left != null) {
            dfs(root.left, number);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
