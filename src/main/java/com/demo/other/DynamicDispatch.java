package com.demo.other;

/**
 * @Author: wangwei
 * @Date: 2019/8/25 16:51
 * @Version 1.0
 */
public class DynamicDispatch {

    static abstract class Human{
        protected abstract void sayHello();
    }

    static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("Man say Hello");
        }
    }

    static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("WoMan say Hello");
        }
    }

    public static void main(String[] args) {
        Woman woman = new Woman();
        Human man = new Man();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }

}
