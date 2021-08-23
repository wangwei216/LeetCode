//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树 
// 👍 695 👎 0


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
     * 第一种使用递归方法进行
     *     1. 首先所有的递归都需要先确定最简单都递归子问题
     *     2. 然后进行
     *      以当前节点作为头结点的路径数量
     *      以当前节点的左孩子作为头结点的路径数量
     *      以当前节点的右孩子作为头结点啊路径数量
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int result = countPath(root, sum);
        int left = pathSum(root.left, sum);
        int right = pathSum(root.right, sum);
        return result + left + right;
    }

    public int countPath(TreeNode root, int sum) {
        int result = 0;
        // 子问题，递归结束条件
        if (root == null) {
            return 0;
        }
        sum = sum - root.val;
        result = sum == 0 ? 1 : 0;
        return result + countPath(root.left, sum) + countPath(root.right, sum);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
