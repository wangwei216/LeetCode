//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 669 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 第一种方法就是快慢指针的方法
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        // 首先处理特殊情况
        if (head == null || head.next == null) {
            return false;
        }
        // 第二步就是使用快慢指针找到链表中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 然后把后半部分链表进行反转
        ListNode newHead = revserList(slow);

        while (newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    // 反转一个链表
    public ListNode revserList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 先定义一个变量
        ListNode tail = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = tail;
            tail = head;
            head = tmp;
        }
        return tail;
    }

    /**
     * 第二种方法 递归
     */
    LisNode tmpNode;
    public boolean isPalindrome(ListNode head) {
        this.tmpNode = head;
        return check(head);
    }

    public boolean check(ListNode head) {
        if (head == null) {
            return true;
        }
        // 核心是递归，因为要先执行 check，比较值是不是相等的时候的 head 的val 其实是刚刚递归之后的最后一个元素，也就是链表的尾部
        // 然后用 head（尾部链表元素）和一开始构造进来的 链表头元素进行依次比较，然后退出当前的check递循环
        boolean res = check(head.next) && (head.val == tmpNode.val);
        tmpNode = tmpNode.next;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
