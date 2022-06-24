//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 719 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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
     * 第一种方式是使用递归分解的思路进行分解处理， 使用的也是后序遍历的思路
     *  1。递归分解思路是只 把根节点 + 两边的子节点 相加 才是最终结果
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        return Math.max(left_depth, right_depth) + 1;
    }

    /**
     * 第二种思路也是使用递归，但是是根据求解结果一次计算出最终结果，使用的是前序遍历
     *    1。利用类似回溯一样的思路，在遍历整科二叉树的时候，因为有很多分支，所以你在递归的过程中需要都走一遍，并且记录每一条路径的最大深度，然后返回该值
     */
    //
    int depth = 0;
    int maxCount = 0;
    public int maxDepth(TreeNode root) {
        dfs(root);
        return maxCount;
    }
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 这里每次递归一层，就需要先递增，表示当前的深度，一旦走到最后底部的时候，说明当前路径的递归结束了，那么就需要记录对应的最大值
        depth++;
        if (root.left == null && root.right == null) {
            maxCount = Math.max(maxCount, depth);
        }
        dfs(root.left);
        dfs(root.right);
        // 因为在递归的走每一条到达叶子节点的路径结束时，又会回到上一层递归，那么就需要恢复到上一层的深度
        depth--;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
