/**
 * Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
package com.wangwei.Singleton;

/**
 * @FileName: InnerSingleton.java
 * @Description: InnerSingleton.java类说明
 * @Author: wangwei
 * @Date: 2019/8/11 23:45
 */
public class InnerSingleton {
    private InnerSingleton(){
    }
    public static InnerSingleton getInstance(){
        return SingletonHolder.instance;
    }
    //这里是使用到了内部类，并且把内部类定义为私有的静态变量
    private static class SingletonHolder{
        private static final InnerSingleton instance = new InnerSingleton();
    }

}
