//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 831 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 第一种方法是使用深度遍历（特点就是不撞南墙不回头）
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        // 考虑特殊情况进行处理
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        // 然后进行遍历二维数组，如果
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 在遍历的过程中只要遇到 1 就进行对 count++，因为需要在dfs中对当前是1的都标记为0
                if (grid[i][j] == '1') {
                    ++count;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c) {
        int rn = grid.length;
        int cn = grid[0].length;
        // 递归的时候结束条件，如果当前值是0，说明直接结束当前值的递归
        if (r < 0 || c < 0 || r >= rn || c >= cn || grid[r][c] == '0') {
            return;
        }
        // 需要注意的是深度搜索的时候，需要把
        grid[r][c] = '0';
        // 上下左右四个方向进行深度搜索
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }


    /**
     * 二刷 深度递归dfs
     */
    public int numIslands(char[][] grid) {
        int result = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 因为是在寻找岛屿的数量，其实就是再找连续的1，不是1的话就不统计
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }
    // 首先递归先考虑的结束条件就是：
    public void dfs(char[][] grid, int r, int c) {
        // 跳出递归的条件不越数组边界
        if (r >= grid.length || c >= grid[0].length || r < 0 || c < 0) {
            return;
        }
        // 为了防止数据重复被用，需要每次遍历完需要判断一下这个数字是不是被用过
        if (grid[r][c] != '1') {
            return;
        }
        // 这个数只是为了标记一下这个数，被用过，仅仅只是一个标记的作用
        grid[r][c] = '2';

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
