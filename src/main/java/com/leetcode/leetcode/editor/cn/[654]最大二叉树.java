//给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下： 
//
// 
// 二叉树的根是数组 nums 中的最大元素。 
// 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。 
// 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。 
// 
//
// 返回有给定数组 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
// Related Topics 栈 树 数组 分治 二叉树 单调栈 
// 👍 338 👎 0


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
     * 使用递归解决
     * 1。首先先找到数组中的最大值，然后从最大值处，把一个数组分割成两个数组，然后两个数组再递归去执行
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    // 用来构造二叉树
    public TreeNode build(int[] nums, int low, int high) {
        // 因为递归是靠左右节点的边界进行控制的，当low > high 的时候，说明遍历结束
        if (low > high) {
            return null;
        }
        // 先找需要递归数组的最大值和最大值对应的索引下标
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = low; i <= high; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        // 每次只把当前数组中的最大值构建一个 根节点，然后递归去构造根节点的左右子节点
        TreeNode root = new TreeNode(max);
        // 然后剩下的就是递归分别构建左右次子节点，注意左右子边界
        root.left =  build(nums, low, index -1);
        root.right = build(nums, index + 1, high);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
