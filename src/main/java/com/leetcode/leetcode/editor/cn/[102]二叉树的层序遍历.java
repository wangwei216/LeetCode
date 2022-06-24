//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 667 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

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
     * 使用栈的思想对二叉树进行层序遍历
     * 1.思路就是用一个队列（用队列的目的是可以保证从左到右是先进先出的顺序）和一个List（这个就是为了）
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // 用来存放每层的值
        Queue<TreeNode> queue = new LinkedList<>();
        // 先把第一个节点放进去，抛砖引玉的效果
        if (root != null) {
            queue.add(root);
        }
        // 如果不为空就会先把
        while (!queue.isEmpty()) {
            int n = queue.size();
            // 创建每层真正放了几个值，把每一层的节点放到这个队列中，然后直接再add外层的List中
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                // 先依次对之前放进去的队列进行出队列，然后把出队列的节点的儿子再依次放到每一层的队列中
                TreeNode node = queue.poll();
                level.add(node.val);
                // 依次判断出队列的值的儿子是不是为空，如果不为空，就入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    /**
     * 使用递归实现 二叉树的层序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // 首先想到的是 List 中表示的是每一层的值，那在List中下标就对应着层数的关系，在递归的过程中，得知道当前递归所在的层级，才能把值放到对应的List中
        dfs(root, res, 1);
        return res;
    }

    // index 就是表示的就是当前的递归的层级，好把节点放到对应的List中
    public void dfs(TreeNode root, List<List<Integer>> res, int index) {
        if (root == null) {
            return;
        }
        // 因为res是最终的结果，最终肯定是一个层级对应着一个List，然后返回最外层的一个大List，
        // 所以这里如果最终结果中的小List 数量小于 当前层级数时，就说明当前层级中的小List 还没有进行初始化「也就是创建一个空的List用来存值」
        if (res.size() < index) {
            res.add(new ArrayList<Integer>());
        }
        // 然后获取创建好的list，先把当前层的节点 放到list中
        res.get(index - 1).add(root.val);
        dfs(root.left, res, index + 1);
        dfs(root.right, res, index + 1);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
