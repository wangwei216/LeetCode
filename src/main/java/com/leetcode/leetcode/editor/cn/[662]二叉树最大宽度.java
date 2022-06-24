//给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节
//点为空。 
//
// 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。 
//
// 示例 1: 
//
// 
//输入: 
//
//           1
//         /   \
//        3     2
//       / \     \  
//      5   3     9 
//
//输出: 4
//解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
// 
//
// 示例 2: 
//
// 
//输入: 
//
//          1
//         /  
//        3    
//       / \       
//      5   3     
//
//输出: 2
//解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
// 
//
// 示例 3: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2 
//       /        
//      5      
//
//输出: 2
//解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
// 
//
// 示例 4: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       /     \  
//      5       9 
//     /         \
//    6           7
//输出: 8
//解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
// 
//
// 注意: 答案在32位有符号整数的表示范围内。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 306 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 表示最下层的两个节点之间的最大宽度
    int maxWide = 0;
    public int widthOfBinaryTree(TreeNode root) {
        // 因为初始的 左边List中没有元素，所以 level 得从 0 开始进行base case
        dfs(root, 0, 1, new ArrayList<>(), new ArrayList<>());
        return maxWide;
    }
    /**
     * 第一种解法是递归思路：
     *      前提是必须得先是中序遍历，也就是一层一层的进行遍历
     * @param root
     * @param level     表示整颗二叉树的层高
     * @param position  每个节点在满二叉树中的位置
     * @param left      只记录最左边的节点，每层只记录一个当前层最左边节点的位置
     * @param right     只记录遍历过的最右边节点，每层只记录一个（这里是遍历过的，如果当前层有更右边的节点，会把当前层的替换）
     */
    public void dfs(TreeNode root, int level, int position, List<Integer> left, List<Integer> right) {
        if (root == null) {
            return;
        }
        // 当层高等于 left 中的 size 大小相等的时候，就说明这个节点是当前层级的第一个元素, right List无论怎么样都会把当前最新position放进去来表示最后一个
        if (left.size() == level) {
            left.add(position);
            right.add(position);
        } else {
            // 如果不是第一个元素的时候，会一直用当前层最新的 position 去覆盖当前层的值，因为只能有一个值
            right.set(level, position);
        }
        // 能让递归继续下去，就得一层一层往下走，序号位置按照二叉树的公式，在整个递归的过程中，能够一直记录每个节点的位置
        dfs(root.left, level + 1 , position * 2, left, right);
        dfs(root.right, level + 1, position * 2 + 1, left, right);
        // 最后是计算最大宽度，并且在递归的过程中一直更新最大宽度的值
        maxWide = Math.max(maxWide, right.get(level) - left.get(level) + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
