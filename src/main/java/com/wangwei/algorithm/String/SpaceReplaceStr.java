package com.wangwei.algorithm.String;

import java.util.Scanner;

/**
 * @Description SpaceReplaceStr
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/23 22:28
 */
public class SpaceReplaceStr {

    public static String replaceSpace(StringBuffer str) {
        int spacenum = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                spacenum++;
            }
        }
        int indexold = str.length()-1;
        int newlength = str.length() + spacenum*3;
        int indexnew = newlength-1;
        str.setLength(newlength);
        for(;indexold>=0 && indexold<newlength;--indexold){
            if(str.charAt(indexold) == ' '){  //
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');

            }else{
                str.setCharAt(indexnew--, str.charAt(indexold));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println(arr[4]);
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        StringBuffer stringBuffer = new StringBuffer(str);
//        String s = replaceSpace(stringBuffer);
//        System.out.println(s);
    }


}
