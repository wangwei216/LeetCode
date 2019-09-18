package com.wangwei.algorithm.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Description Main2
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/16 21:38
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        List<String> result = new ArrayList<>();
        result.add("");
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < num.length(); i++) {
            int cur = Integer.parseInt(num.substring(i, i + 1));
            String str = map[cur];
            List<String> tmp = new ArrayList<>();
            for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < result.size(); k++) {
                    tmp.add(result.get(k) + str.substring(j, j + 1));
                }
            }
            result = tmp;
        }

        Object[] strs = result.toArray();
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if (i == 0) {
                sb.append("[").append(strs[i]).append(", ");
            } else if (i == strs.length - 1) {
                sb.append(strs[i]).append("]");
            } else {
                sb.append(strs[i]).append(", ");
            }
        }
        System.out.println(sb.toString());
    }
}
