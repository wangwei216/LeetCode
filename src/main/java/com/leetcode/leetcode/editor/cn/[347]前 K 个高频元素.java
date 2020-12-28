//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 579 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 第一种方式：是使用hash先进行对每个值进行统计，然后把统计的值的结果作为下标，key作为值，
     * 这样的思路就是倒叙遍历数组，就能知道原来每个值统计最大的从哪进行开始
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 先进行hash
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i] + 1));
            } else {
                map.put(nums[i], 1);
            }
        }
        // 这里使用到了一个List数组
        List<Integer>[] list = new List[];
        for (Integer key : map.keySet()) {
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // 然后倒叙进行遍历List
        for (int i = list.size() - 1; i >= 0 && res.size() < k; --i) {
            if (list[i] == null) {
                continue;
            } else {
                res.addAll(list[i]);
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
