package com.demo.zuoshen_videocode;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class test {

    public static void main(String[] args) {

        HashMap map = new HashMap();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int [] rec = new int[26];
        int max = 0;
        for(int i=0;i<line.length();i++) {
            max = Math.max(max, rec[line.charAt(i)-'a']+=1);
        }
        System.out.println(max);

    }

    //abc  返回  {a,b,c,ab,ac,bc,abc}
//    public List<String> find(String input){
//        List<String> list = new ArrayList<>();
//        for（int i=0; i<input; i++）{
//            list [i] = input.charAt(i);
//
//        }
//        if（list .size() == 1）{
//            return list [0];
//        }
//        if(list .size() > 1){
//            for(int j=0 ;j <= list.size; j++ ){
//
//            }
//        }
//    }

}
