package com.wangwei.Singleton;

/**
 * @Author: wangwei
 * @Description: 恶汉的单例模式
 * @Param:  * @Param: null
 * @Date: 2019-08-11
 */
public class HungrySingleton {

    private static HungrySingleton Instance  = new HungrySingleton();

    private HungrySingleton(){
    }

    public HungrySingleton getInstance(){
        return Instance;
    }

}
