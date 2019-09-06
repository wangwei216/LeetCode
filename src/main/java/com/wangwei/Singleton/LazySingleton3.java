/**
 * Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
package com.wangwei.Singleton;

/**
 * @FileName: LazySingleton3.java
 * @Description: LazySingleton3.java类说明
 * @Author: wangwei
 * @Date: 2019/8/11 23:30
 */
public class LazySingleton3 {

    private static volatile LazySingleton3 instance;
    private LazySingleton3(){
    }
    //双锁进行检查
    public static LazySingleton3 getInstance(){
        if (instance == null){
            //到这里有可能会出现有两种线程同时走到这里，但是此时需要使用一次Synchronize的进行排队阻塞进行枷锁
           synchronized (LazySingleton3.class){
               if (instance == null){
                   instance = new LazySingleton3();
               }
           }
        }
        return instance;
    }
}
