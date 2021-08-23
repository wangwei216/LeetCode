//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 500 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
     * 第一种方法是使用递归的 dfs 深度遍历方式进行
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        // 1 表示奇数还是偶数层，因为是锯齿状的，相当于自己手动计算是奇数层就顺序放，偶数层就倒序放到数组中
        dfs(root, res, 1);
        return res;
    }

    public void dfs(TreeNode root, List<List<Integer>> res, int index) {
        // 这里的判断必须加上，如果不加说明
        if (root == null) {
            return;
        }
        // 如果结果 因为 index 是层级从1开始的
        if (res.size() < index) {
            res.add(new ArrayList<>());
        }
        // 这里需要去判断该层是 奇数 还是 偶数
        if ((index % 2) == 1) {
            res.get(index - 1).add(root.val);
        } else {
            res.get(index - 1).add(0, root.val);
        }
        dfs(root.left, res, index + 1);
        dfs(root.right, res, index + 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
