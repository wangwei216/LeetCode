//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 
// 👍 613 👎 0


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
     * 第一种方法是使用递归完成
     * 1.  其实就是使用动态规划思想的最大最优解 = （爷爷偷的钱 + 孙子偷的钱） 和 儿子偷的钱，那个更大的过程
     * 2。 然后就使用递归去实现就行了
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxMoney = 0;
        //这里先计算爷爷偷的钱和孙子偷的钱，然后又分为左子树和右子树来进行判断
        if (root.left != null) {
            //计算爷爷的左子树
            maxMoney += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null) {
            maxMoney += (rob(root.right.left) + rob(root.right.right));
        }
        return Math.max(maxMoney + root.val, rob(root.left) + rob(root.right));
    }

    /**
     * 第二种方法就是使用动态规划来实现的
     * 1。 核心就是我们使用一个大小为 2 的数组来表示 int[] res = new int[2] 0 代表不偷，1 代表偷
     * 任何一个节点能偷到的最大钱的状态可以定义为
     * <p>
     * 当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
     * 当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null){
            return int[2];
        }
        // 定义一个结果集
        int[] result = new int[2];
        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);
        // 这里一共就两中结果，当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
        // 1.当前节点偷，当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
        result[1] = left[0] + right[0] + root.val;
        // 2.当前节点不偷，当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
