package com.wangwei.algorithm;


/**
 * @Description ReverseList
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/11 13:49
 */
public class ReverseList {
    /**
     * 反转一个链表，这里用的是遍历实现
     * 思路：主要是需要三个指针变量进行控制
     *
     */
    public Node reverseList(Node head){
        if (head == null){
            return head;
        }
        //
        Node pre = head;
        Node cur = head.Next;
        Node tmp = null;
        while (cur != null){
            tmp = cur.Next;
            //这一步其实是改变指针方向
            cur.setNext(pre);
            //然后往下走
            pre = cur;
            cur = tmp;
        }
        //结束全部循环的时候，说明整个链表已经反转完成，需要把最开始的头结点的next置为尾部
        head.setNext(null);
        return pre;
    }

    //单链表Node节点内部类
    class Node {
        private int Data;// 数据域
        private Node Next;// 指针域

        public Node(int Data) {
            this.Data = Data;
        }

        public int getData() {
            return Data;
        }

        public void setData(int Data) {
            this.Data = Data;
        }

        public Node getNext() {
            return Next;
        }

        public void setNext(Node Next) {
            this.Next = Next;
        }

    }

}
