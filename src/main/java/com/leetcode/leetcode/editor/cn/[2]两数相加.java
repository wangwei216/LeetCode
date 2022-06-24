//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5195 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.wangwei.algorithm.LinkedList.ListNode;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l2 == null) {
            return addTwoNumbers(l1, l2);
        }


        l1.next = addTwoNumbers(l1.next, )

    }

    /**
     * 思路就是使用一个循环进行遍历
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 开始的核心就是在返回的结果集链表中创建一个pre头节点 和一个游标节点（游标节点用于遍历给链表添加节点）
        ListNode pre = new ListNode(0);
        ListNode curr = pre;

        ListNode p = l1;
        ListNode q = l2;
        // 这个用来记录进位的变量，每次遍历会进行更新
        int carry = 0;
        while (p != null || q != null) {
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            // 把两个节点相加，同时需要加上初始值的进位值
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            // 把最终要返回的结果集添加一个节点
            curr.next = new ListNode(sum);
            // 然后把返回结果集的游标 和 双指针都向后移动
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
            // 这里是对最后对进位
            if (carry == 1){
                curr.next = new ListNode(carry);
            }
        }
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
