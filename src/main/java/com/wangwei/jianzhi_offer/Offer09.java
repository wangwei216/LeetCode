/**
 * Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
package com.wangwei.jianzhi_offer;

import java.util.Stack;

/**
 * @FileName: Offer09.java
 * @Description: Offer09.java类说明
 * @Author: wangwei
 * @Date: 2019/6/23 14:53
 */
public class Offer09 {

    /**
     * @Author: wangwei
     * @Description: 用两个栈实现一个队列
     * @Param:  * @Param: null
     * @Date: 2019-06-23
     */
    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() {
        if (out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public static void main(String[] args) {
        Offer09 offer09 = new Offer09();
        offer09.push(2);
        System.out.println(offer09.pop());
        System.out.println(offer09.pop());
    }

}
