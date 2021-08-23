//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 635 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 这里使用的是 递归 + 回朔的方法，如果使用递归，就需要先知道递归结束的条件
     *
     * @param board
     * @param word
     * @return
     */

    // 因为递归的过程中，需要使用到每个元素是不是被访问过，访问过的还需要置为true
    Boolean[][] isVis;
    int row;
    int col;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        // 定义一个二维数组来表示每一个元素是不是被访问过
        isVis = new Boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 首先需要找到目标单词的第一个字母作为递归的开始入口，并且每一个字母只能使用一次
                if (board[i][j] == word.charAt(0) && !isVis[i][j]) {
                    // 然后确定递归函数的入参数，和返回结果集
                    if (dfs(board, i, j, word,0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 递归首先需要找到递归结束的条件：
     *  1. 超出数组边界
     *  2. 元素已经被访问过了
     *  3. 单词的值不等于目标值
     *
     * @return
     */
    public boolean dfs(char[][] board, int i, int j, String word, int cur) {
        if (i >= row || i < 0 || j >= col || j < 0 || isVis[i][j] || board[i][j] != word.charAt(cur)) {
            return false;
        }
        // 走到这里的说明找到了目标单词中的某一个字符串，然后需要标记一下
        isVis[i][j] = true;
        // 如果目标单词的数组都找到了，那就说明都找到了，直接返回
        if (cur == word.length() - 1) {
            return true;
        }
        // 如果找到的值不是目标单词中的值的话，那就需要四个方向都需要去找一下
        boolean res = dfs(board, i-1, j, word, cur + 1)
                || dfs(board, i+1, j, word, cur + 1)
                || dfs(board, i, j-1, word, cur + 1)
                || dfs(board, i, j+1, word, cur + 1);

        // 因为四个方向
        isVis[i][j] = false;
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
