//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 1741 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        /**
         * 第一种先使用暴力方法进行
         *  1.思路就是首先其实就是先对每一个元素进行遍历，然后以每个元素为准，去找到该元素到左边对大值和右边最大值
         *  2.然后再去进行比较出最小的那个，然后求和
         */
        int len = height.length;
        int sum = 0;
        if (len <= 1) {
            return 0;
        }
        for (int i = 0; i < len; i++) {
            int l_max = height[0];
            int r_max = height[len - 1];

            //找出左边最大值
            for (int j = 0; j <= i; j++) {
                l_max = Math.max(l_max, height[j]);
            }
            // 找出i右边最大值
            for (int j = i; j < len; j++) {
                r_max = Math.max(r_max, height[j]);
            }
            // 这一步的关键是以当前i，利用木桶效应找到左右两侧最小的，然后减去当前i的值
            sum += Math.min(l_max, r_max) - height[i];
        }
        return sum;
    }

    /**
     * 第二种使用双指针方法 （推荐使用）
     * right_max
     * left_max                             __
     * __                                |  |
     * |  |__   __??????????????????????  |  |
     * __|     |__|                       __|  |__
     * left                      right
     * <p>
     * 1. 首先进行是需要 最左 最右指针游标，和左边最大值，右边最大值 这俩值都是动态更新的
     * 2. 有一点核心思想，就是在比较左右两边的值的大小的时候，如果右边的值比较大，那么能盛多少水，其实是有左边的最高值来决定的【类似木桶效应】。
     */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int left_max = 0, right_max = 0;
        int sum = 0;
        // 第一层大循环遍历整个数组
        while (left < right) {
            // 第二层就是判断那个值大，就是在比较左右两边的值的大小的时候，如果右边的值比较大，那么能盛多少水，其实是由左边的最高值来决定的【类似木桶效应】
            if (height[left] >= height[right]) {
                // 在遍历的过程中需要维护右边的最大值，用当前的小值 比较是不是大于 移动方的最大值，大于则更新。否则移动指针
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    // 因为每次都是移动一个单元格，所以直接用最大值减去当前值就是可以盛水的单元格
                    sum += (right_max - height[right]) * 1;
                }
                --right;
            } else {
                // 右边的值 》 左边，移动左指针，更新左边最大值
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    sum += (left_max - height[left]);
                }
                ++left;
            }
        }
        return sum;
    }

    /**
     * 第三种双指针法思路：
     * 1. 通过双指针类型的遍历，找到左右两边的最大值
     * 2. 根据左边最大值和右边最大值的比较，来确定是使用左边最大值还是右边最大值来作为接雨水的基准值，
     * 在遍历的过程中，其实就是再一格一格的计算相邻两个柱子之间能接到的雨水之和
     */
    public int trap(int[] height) {
        int len = height.length;
        int sum = 0;
        int left = 0;
        int right = len - 1;
        if (height.length <= 1) {
            return 0;
        }
        int l_max = height[0];
        int r_max = height[len - 1];
        // 这里左右指针相等的时候跳出循环
        while (left < right) {
            // 先找到左右两侧的最大值，如果右边的值比较大，那么能盛多少水，其实是由左边的最高值来决定的【类似木桶效应】
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
            // 找出较小的那个最大值，如果用左侧的最大值比较小，则移动左指针，和当前侧正在遍历的柱子和较小的那个最大值进行计算面积，
            if (l_max < r_max) {
                sum += (Math.min(l_max, r_max) - height[left]) * 1;
                left++;
            } else {
                sum += (Math.min(l_max, r_max) - height[right]) * 1;
                right--;
            }
        }
        return sum;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
