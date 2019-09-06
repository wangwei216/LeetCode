package com.demo.zuoshen_videocode;

import java.util.Arrays;

/**
 * @Author: wangwei
 * @Date: 2019/8/31 17:24
 * @Version 1.0
 */
public class FindString {


    public static void main(String[] args) {

        String str = "aba";

        FindString findString = new FindString();
        findString.findStr(str);

    }

    public int findStr(String str){

        if (str.length() <= 0){
            return 0;
        }
        else {
            char[] strs = str.toCharArray();
            if (strs .length > 0){
                for (int i=0;i<strs.length;i++){
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str.charAt(i));
                    System.out.print(" "+stringBuilder);
                    stringBuilder.append(str.charAt(i));
                    for (int j=1; j<strs.length; j++){

                    }
                }
            }
        }
        return 0;
    }
}
