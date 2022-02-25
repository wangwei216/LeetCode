//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 731 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
     * 第一种方法 迭代遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<>();
        // 整个循环的跳出条件是root 是空时，如果栈中有的话就继续放进去
        while (root != null || !stack.isEmpty()) {
            // 然后让节点一直向左走
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            // 然后再去遍历右半部分
            root = root.right;
        }
        return res;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        // 这一层循环主要是为了一层一层的出站
        while (root != null || !stack.isEmpty()) {
            // 这一步目的是先找到左子树的最底层root 节点
            while (root != null) {
                // 因为你是中序遍历必须一直先找左节点
                stack.push(root);
                root = root.left;
            }
            // 找到最底层的最左子树节点，开始出站
            root = stack.pop();
            result.add(root.val);

            // 这里的时候其实已经走到了最底层的分支节点的
            root = root.right;
        }
        return root;
    }

    /**
     * 第二种方法 递归遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res, root);
        return res;
    }
    /**
     * 中序遍历
     *
     * @param res
     * @param root
     */
    public void dfs(List<Integer> res, TreeNode root) {
        if (root == null){
            return;
        }
        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
