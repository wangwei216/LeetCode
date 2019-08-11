/**
 * Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
package com.wangwei.Singleton;

/**
 * @FileName: LazySingleton1.java
 * @Description: LazySingleton1.java类说明
 * @Author: wangwei
 * @Date: 2019/8/11 23:23
 */
public class LazySingleton1 {
    //线程不安全的
    private static LazySingleton1 instance;
    private  LazySingleton1(){
    }
    public static LazySingleton1 getInstance(){
        if (instance == null){
            instance = new LazySingleton1();
        }
        return instance;
    }


}
