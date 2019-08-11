/**
 * Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
package com.wangwei.Singleton;

/**
 * @FileName: LazySingleton2.java
 * @Description: LazySingleton2.java类说明
 * @Author: wangwei
 * @Date: 2019/8/11 23:27
 */
public class LazySingleton2 {

    private  static LazySingleton2 instance;
    private LazySingleton2(){
    }
    /**
     * 使用Synchronize进行上锁，但是这种锁的力度比较大
     */
    public static synchronized LazySingleton2 getInstance(){
        if (instance == null){
            instance = new LazySingleton2();
        }
        return instance;
    }

}
