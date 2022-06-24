package com.wangwei.algorithm.LinkedList;

/**
 * @Description ReorderList
 * @Date 2022/3/14
 * @Author wangwei
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        dfs(head, head);
    }
    // 其实两个都是头节点，但是这个tail节点其实是递归到结尾时要返回到尾部节点，在最深后一层递归出来的时候就是 tail 节点
    public ListNode dfs(ListNode head, ListNode tail) {
        if (tail == null) {
            return head;
        }
        ListNode returnTailNode = dfs(head, tail.next);
        // 到这里的时候，其实tail表示的头节点已经遍历到尾部了，表示源链表的最后一个非NULL节点
        if (returnTailNode == null) {
            return null;
        }

        // 如果returnNode或returnNode的后继等于tail，说明完成，注意tail即为尾节点，next需要set null
        if (returnTailNode == tail || returnTailNode.next == tail) {
            tail.next = null;
            return null;
        }

        // 将尾部遍历节点指向对应的头部遍历节点的next，正向节点指向尾部遍历节点
        tail.next = returnTailNode.next;
        returnTailNode.next = tail;
        return tail.next;
    }

    public static void main(String[] args) {


    }

}
