//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 759 👎 0


import java.util.PriorityQueue;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 第一种方法是使用快排
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int lenth = nums.length;
        int left = 0;
        int right = lenth - 1;

        int target = lenth - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    // 这个其实就是快排的partition的过程
    public int partition(int[] nums, int left, int right) {
        // 以第一个值作为基准，然后从左往右找比基准值小的，如果小就交换，遍历完成后就是比基准值小的都在前面
        int position = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            //TODO 这里的核心是边查找位置，边划分区域，始终保持 j 之前的值都是小于基准值 ，j之后的值都大于一开始的基准值
            if (nums[i] < position) {
                j++;
                swap(nums, j, i);
            }
        }
        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
        swap(nums, j, left);
        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp;
        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 第二种方法使用优先级队列本身的最小堆来进行实现的
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        queue.poll();
    }

    /**
     * 第二次写快排
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        // 这里的都是指下标
        int target = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        // 其实这里可以改成一个递归，但是也可以用一个循环
        while (true) {
            // 首先需要进行一个partition 的过程，第一次结束后，其实就是把这个数组拆分为两个数组了
            int index = partition(nums, left, right);
            // 其实是根据下标去判断我们要找的那个值在原数组中哪里
            if (index == target) {
                return nums[index];
            } else if (index > target) {
                // 这里因为是一个死循环，所以此时重置 左右指针
                right = index - 1;
            } else {
                left = index + 1;
            }
        }

    }

    public int partion(int[] nums, int left, int right) {

    }


    /**
     * 标准版本的快排
     *
     * @param nums
     * @return
     */
    public int sort(int[] nums) {
        return quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int left, int right) {
        if (right < left) {
            return;
        }
        int L = left;
        int R = right;
        // 随便取一个基准值
        int povit = nums[L];
        // 最外层其实就是一个双指针的遍历
        while (L < R) {
            // 先从右往左找到一个比基准值小的
            while (L < R && nums[R] >= povit) {
                R--;
            }
            nums[L] = nums[R];

            // 从左向右找大于基准值的
            while (L < R && nums[L] <= povit) {
                L++;
            }
            nums[R] = nums[L];
        }
        // 到这里说明L和R相遇了，已经跳出循环了，把他们两个相遇的位置和一开始的基准值进行交换位置
        nums[L] = povit;
        quickSort(nums, L, left - 1);
        partion(nums, left + 1, R);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
