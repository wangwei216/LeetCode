//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3283 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();;
        // 先进行排序
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            // 1. 因为此时已经排序好了，固定住k，然后依次遍历
            if (nums[k] > 0) {
                break;
            }
            // 2. 如果当前的 k 的值 和上一次遍历的 k值相同的话，就跳过重复的（k>0 是为了保证）
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            // 3. 前面做的事情都是先固定住第一个值，后面再去使用双指针去确定后面的两个值
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                // 然后先固定住总和，先都用变量进行表示
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    i++;
                } else if (sum > 0) {
                    j--;
                } else if (sum == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    // 这里是进行去重的目的是为了去除掉 i 相同的值，和j相同的值
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j-1]) {
                        j--;
                    }
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
