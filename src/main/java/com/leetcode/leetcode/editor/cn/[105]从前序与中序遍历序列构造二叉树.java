//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
// 中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 716 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    /**
     * 前序遍历：根 左 右
     * 中序遍历：左 根 右
     *  递归思路：
     *      1。先构建一个递归方法，参数其实就是两个数组的值和边界，先通过中序的值来获取到根节点
     *      2. 需要考虑递归的结束条件，其实就是任意一个数组越界，两个数组长度肯定一致
     *      3. 使用前序遍历的第一个值就是根节点 作为 base case
     *      4。找到中序遍历中的根节点，可以拆分左右子树
     *      5。然后通过中序遍历找到的根节点，进行分别递归重建 根节点的左右子树
     *          a. 核心就是找到构建左右子树分别的 start 和 end 的关系
     *          b. 通过inorder中左子树节点的数目来确定前序中左右子树的边界
     *
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildHelper(int[] preorder, int preStart, int  preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int initValue = preorder[preStart];
        TreeNode root = new TreeNode(initValue);

        // 这一步寻找根节点的时候，可以使用Map先遍历存起来，用的时候直接get就行
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (initValue == inorder[i]) {
                index = i;
                break;
            }
        }

        // 这一步的 核心其实就是 构建能让递归继续执行下去的下标，因为中序中确定了根节点，所以可以确定中序遍历的左右边界
//        root.left = buildHelper(preorder, ？, ？, inorder, inStart, index - 1);
//        root.right = buildHelper(preorder, ？, ？, inorder, inStart + 1, inEnd);

        //通过inorder中左子树节点的数目来确定先序遍历的边界，也就是先序遍历的左子树有几个节点
        int nums_of_left_tree = index - inStart;
        // 这里的每一个 + 1 其实就是为了让整个递归继续走下去，其实也就是数组的下标在 i++
        root.left = buildHelper(preorder, preStart + 1, preStart + nums_of_left_tree, inorder, inStart, index - 1);
        root.right = buildHelper(preorder, preStart + nums_of_left_tree + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
