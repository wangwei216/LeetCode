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
     * 第二种使用双指针方法
     * 1.还是先遍历每个元素，然后找出该元素的左右两侧的最大值，然后找出其中的一个最小值
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
            // 先找到左右两侧的最大值
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
            // 然后根据左右两侧最大值不同，因此计算方式不一致
            if (l_max < r_max) {
                sum += Math.min(l_max, r_max) - height[left];
                left++;
            } else {
                sum += Math.min(l_max, r_max) - height[right];
                right--;
            }
        }
        return sum;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
