//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索 
// 👍 590 👎 0


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
     * 首先核心思路是把全部的右子树放到左子树的方法
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            // 这里是看左子树是不是为空，如果为空，直接就不用考虑左子树了，只考虑右子树
            if (root.left == null) {
                root = root.right;
            } else {
                //走到这里说明左子树不为空，然后就去遍历找到左子树的最后一位右子树, 这里需要新建一个pre节点来表示找到的当前根部节点左节点的最后一位来进行记录
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 这一步其实就是把当前root节点的右节点移动到root跟节点的最后一位右节点上
                pre.right = root.right;
                // 这里是直接把左子树插入到右子树中，并且把左子树置为null
                root.right = root.left;
                root.left = null;
                // 继续下一个根节点
                root = root.right;
            }
        }
    }

    /**
     * 这里是使用第二种方法实现的
     * @param root
     */
    public void flatten(TreeNode root) {


    }
}
//leetcode submit region end(Prohibit modification and deletion)
