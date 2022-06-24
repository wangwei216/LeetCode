//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
// Related Topics 栈 链表 数学 
// 👍 505 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Stack;

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
     *  使用递归栈的方式
     *      0. 因为最终返回的是一个链表，所以得提前构造一个链表头，然后手动跌代这个值
     *      1。先把两个链表都放到栈中
     *      2. 然后进行遍历，只要两个栈中不为空，或者进位的变量有值的话，就继续
     *      3. 核心是把新的节点挂上去的时候，其实就是把原来的头节点 挂到新节点的后面，然后一直更新头节点
     */
    // 2,4,3
    // 5,6,4
    // 8,0,7 null
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new LinkedList<>();
        Deque<ListNode> stack2 = new LinkedList();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        ListNode head = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int a = !stack1.isEmpty() ? stack1.pop().val : 0;
            int b = !stack2.isEmpty() ? stack2.pop().val : 0;

            int sum = a + b + carry;
            carry = sum / 10;
            int value = sum % 10;
            ListNode node = new ListNode(value);
            node.next = head;
            head = node;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
