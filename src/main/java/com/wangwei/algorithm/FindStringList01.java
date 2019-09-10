package com.wangwei.algorithm;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description FindStringList01
 * @Date: 2019/9/9 20:28
 * @Version 1.0
 * @Author: wangwei
 */
public class FindStringList01 {

    public List<String> findListByString(String string){
        List list = new ArrayList<String>();
        int length = string.length();
        if (length == 0){
            return list;
        }
        if (length == 1){
            list.add(string);
            return list;
        }else {
            for (int i=0; i<length; i++){
                for (int j=i+1; j<length; j++){
                    System.out.println("打印字符串："+string.substring(i,j));
                    list.add(string.substring(i,j)) ;
                }

            }
        }
        return  list;
    }

    public static void main(String[] args) {

        String str = "abcd";
        FindStringList01 findStringList01 = new FindStringList01();
        List<String> list = findStringList01.findListByString(str);
        System.out.print(Arrays.toString(new List[]{list}));

    }
}
