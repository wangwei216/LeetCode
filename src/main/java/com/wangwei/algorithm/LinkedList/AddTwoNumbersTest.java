package com.wangwei.algorithm.LinkedList;

/**
 * @Description AddTwoNumbersTest
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @Date 2020/8/31
 * @Author wangwei
 */
public class AddTwoNumbersTest {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        // 代表进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = 0;
            int y = 0;
            x = l1 != null ? l1.val : 0;
            y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            // 这里需要进行判断相加是不是需要进位
            carry = sum / 10;
            // 把相加之和大于10的值给放到链表中
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            //让整个两个链表的循环继续走
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (carry > 0) {
                cur.next = new ListNode(carry);
            }
        }
        return pre.next;
    }

    public static void main(String[] args) {
        AddTwoNumbersTest test = new AddTwoNumbersTest();
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);

        ListNode b = new ListNode(5);
        a.next = new ListNode(6);
        a.next.next = new ListNode(4);
        ListNode resultListHeader = test.addTwoNumbers(a, b);
        while (resultListHeader != null) {
            System.out.println(resultListHeader.val);
            resultListHeader = resultListHeader.next;
        }
    }
}
