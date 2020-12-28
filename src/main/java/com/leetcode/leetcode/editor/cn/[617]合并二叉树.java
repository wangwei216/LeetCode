//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 
// 👍 585 👎 0


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
     * 第一种方式是使用递归进行实现的
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            dfs(t1, t2);
        }
    }

    /**
     * 递归的结束条件：
     * 1. 递归的条件两者其中有一个为null的时候
     * 2.
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode dfs(TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 == null) {
            return r1 == null ? r2 : r1;
        }
        r1.val += r2.val;
        r1.left = dfs(r1.left , r2.left);
        r1.right = dfs(r1.right , r2.right);
        return r1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
