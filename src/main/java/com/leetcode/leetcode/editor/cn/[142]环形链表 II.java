//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，po
//s 仅仅是用于标识环的情况，并不会作为参数传递到函数中。 
//
// 说明：不允许修改给定的链表。 
//
// 进阶： 
//
// 
// 你是否可以使用 O(1) 空间解决此题？ 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 104] 内 
// -105 <= Node.val <= 105 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
// Related Topics 链表 双指针 
// 👍 729 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {

    /**
     *
     *  第一种方式: 使用两个速度为1的指针，一个从头结点开始走，一个从快慢指针相遇结点开始走，他们最终会在环入口结点相遇
     *      思路：
     *          1. 首先需要找到两个指针相遇的地方，其实也就是环形链表一的答案，
     *          2. 然后在此基础上，如果从两个快慢指针相遇的地方，和头指针再从头开始走，他们最终会在环入口节点相遇
     *
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;

        while (fast != null) {
            // 因为快指针一次走两步，防止一次走到头导致的越界，所以需要做个判断
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                meet = fast;
                // 这里让相遇节点和头节点同步开始走, 因为他们最终肯定会相遇，且相遇的那个节点就是环的入口节点，所以只要他们不相同就继续向前走
                while (meet != head) {
                    meet = meet.next;
                    head = head.next;
                }
                return meet;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
