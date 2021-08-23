//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 628 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 精简版本的
     *
     */
    public int[][] merge(int[][] intervals) {
        // 还是需要对数组按照左部分进行排序
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
        // 构建返回结果集
        int[][] res = new int[intervals.length][2];
        int index = 0; // 需要注意的是这个要从-1 开始，不然会多存储一对0
        for (int[] interval : intervals) {
            // 第一对的需要直接保存，或者当前左端点大于 结果集合数组中最后一对的右端点
            if (index == 0 || interval[0] > res[index][1]) {
                res[index] = interval;
            } else {
                // 否则的话说明当前数组的左端点和集合中的最后一对有重合部分，需要更新上一组的右端点
                res[index][1] = Math.max(interval[1], res[index][1]);
            }
        }
        return Arrays.copyOf(res, index + 1);
    }


    /**
     * 使用排序 和 双指针（前提是一个数组只有两个值）
     * 如果当前区间右端点大于要比较的区间的左端点，那么这两个区间就可以合并，并且合并之后的右端点为这两个区间右端点的较大值；
     *
     * 如果当前区间右端点小于要比较的区间的左端点，那么这两个区间就不可以合并，并且开始统计下一个区间，右端点为下一个区间的右端点。
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // 对数组中的左边端点进行排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        // 定义一个二维数组的数量用来保存最终的返回结果
        int k = 0;
        // 因为每次需要遍历一组数组，所以变量是数组，保存变量数组的左右端点
        int l = intervals[0][0];
        int r = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            // 如果左端点小于当前的右端点，然后需要更新右端点的最大值
            if (intervals[i][0] <= r) {
                r = Math.max(r, intervals[i][1]);
            } else {
                // 只要数组中的某一对的左端点大于下一组的右端点，那么就需要保存这对值保存到二维数组中，不需要合并的直接保存就行
                intervals[k][0] = l;
                intervals[k][1] = r;
                k++;
                // 然后继续遍历下一组数组
                l = intervals[i][0];
                r = intervals[i][1];
            }
        }
        intervals[k][0] = l;
        intervals[k][1] = r;
        k++;
        return Arrays.copyOf(intervals, k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
