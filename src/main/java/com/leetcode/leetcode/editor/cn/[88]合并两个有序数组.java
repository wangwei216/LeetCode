//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明： 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6] 
//
// 
//
// 提示： 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针 
// 👍 723 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 第一种方法是使用一个临时数组作为额外空间
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        // 遍历的时候需要
        int i = 0, j = 0, k = 0;
        // 这里的目标就是为了处理两个共同长度的处理，而且只能处理和两个数组相同部分的数据
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                result[k] = nums1[i];
                i++;
                k++;
            } else {
                result[k] = nums2[j];
                j++;
                k++;
            }
        }
        // 然后去处理剩下的其中又一个数组没有处理的数据，直接把剩下的都放到结果集中
        if (i != m) {
            while (i < m) {
                result[k++] = nums1[i++];
            }
        }
        if (j != n) {
            while (j < n) {
                result[k++] = nums2[j++];
            }
        }
        // 因为最后返回的结果是void 不是一个新的结果集，所以需要把结果集遍历复制给nums1
        int d = 0;
        for (int l = 0; l < m + n; l++) {
            nums1[l] = result[d++];
        }
    }

    /**
     * 第二种方法是直接不实用任何的额外辅助空间
     *  思路就是：倒着放每一个数据，比较两个数组中最后一位那个最大，然后放到 result[m + n - 1]上
     *  1. 因为数组是有序的, 所以可以先把两个数组相同的部分排好序，然后对较长的那个数组多出来的部分，进行单独排序
     *  2.
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 需要定义一个最终数组的长度，就是nums1，
        int k = m + n - 1;
        // m, n 代表的是两个数组的下标，所以赋值完事后就需要把其进行更新
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[k] = nums1[m - 1];
                m--;
            } else {
                nums1[k] = nums2[n -1];
                n--;
            }
            k--;
        }
        // 因为是把数组2都需要放到数组1上进行排序，如果数组1元素比较多的话，那么就不需要额外的处理，但是如果数组2的元素比较多，那就需要额外对数组2进行赋值到数组1中
        for (int i = 0; i < n; i++) {
            nums1[i] = nums2[i];
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)













