//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 104] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 
// 👍 668 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
     * 第一种方法是使用双端队列来实现
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode>  list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        1 2 3 4 5
        1 5 2 4 3
        // 使用双指针，然后吧最后一个节点放到头节点的后面
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            // 吧 5 放到 1的位置
            list.get(i).next = list.get(j);
            i++;
            // 吧 2 放到 5 的位置，然后一次迭代
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
