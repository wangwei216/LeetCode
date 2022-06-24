//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 链表 
// 👍 1055 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import scala.sys.process.ProcessBuilderImpl;

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
     * 严格基于反转链表实现的
     *  1。首先先定义好dummy节点，pre和 end 节点，然后让end 节点先走到第 K 个节点
     *  2。然后把第 K 个节点后面的次头节点保留下来，找到 start 节点，用来进行反转 从 【start，end】位置的节点
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        // 1。先把end 指向到第 K 个节点，并且保证
        // dummy 1,2,3   4,5  k = 3
        // dummy 3 2 1   4 5
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 如果链表的节点小于要反转的k值
            if (end == null) {
                break;
            }

            // 先把要反转的指针都用变量先存起来
            ListNode nextHeader = end.next;
            ListNode start = pre.next;
            // 把 3 -> 4 直接的衔接指针先断开，反正已经存了 4 位置的下一个要反转的Header节点
            end.next = null;
            // 这里需要把 pre 跟反转链表之后的连接起来
            pre.next = reverse(start);
            // 因为反转之后的结果应该得把原来变量存下来的 1 指向-> 4，到这里算是上一轮的衔接完成
            start.next = nextHeader;

            // 构造下一次需要遍历的节点，依次循环下去，此时的start 就是 4，和刚开始的构造变量的时候一样，
            // 都把 pre 和 end指针指向珍视节点值的head，也就是 1
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    // 基础版的反转链表
    // null 1 2 3
    // 1 null 2 3
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 反转单链表的 pre 节点可以直接用 null ，因为最后的单链表最后的一个节点其实也是 Null
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode nextHead = cur.next;
            // 因为最终的结果是 1 后面跟的是 null， 所以相当于新建了一个链表
            cur.next = pre;
            // 然后cur指针 和 pre 指针都向前移动
            pre = cur;
            // 这一步刚好衔接住下一次要遍历的 nexthead
            cur = nextHead;
        }
        return pre;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
