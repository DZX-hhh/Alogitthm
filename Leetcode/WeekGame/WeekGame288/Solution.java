package Leetcode.WeekGame.WeekGame288;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int largestInteger(int num) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();

        PriorityQueue<Integer> queue1 = new PriorityQueue<>(
                (a, b) -> {
                    return b - a;
                }
        );
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(
                (a, b) -> {
                    return b - a;
                }
        );
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            if (n % 2 != 0) {
                queue1.offer(n);
            } else {
                queue2.offer(n);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            sb.append(n % 2 != 0 ? queue1.poll() : queue2.poll());
        }
        return Integer.parseInt(String.valueOf(sb));
    }

    /**
     * @param expression
     * @return 利用String.format拼接
     */
    public String minimizeResult(String expression) {
        int n = expression.length();
        int min = Integer.MAX_VALUE;
        int index = expression.indexOf('+');
        String res = new String();
        for (int left = 0; left < index; left++) {
            for (int right = index + 1; right < n; right++) {
                //将expression截取成3个部分
                String s1 = expression.substring(0, left);//截取[0,left-1]
                String s2 = expression.substring(left, right + 1);//截取[left,right+1-1]
                String s3 = expression.substring(right + 1, n);//截取[right,n-1]
                int num = toNum(s1, s2, s3);
                if (num < min) {
                    min = num;
                    res = String.format("%s(%s)%s", s1, s2, s3);
                }
            }
        }
        return res;
    }

    /**
     * @param s1
     * @param s2
     * @param s3
     * @return 将s1s2s3转化成s1*s2*s3的值
     */
    private int toNum(String s1, String s2, String s3) {

        //将s2转化成a+b两个部分,以"+"分割
        //这里分割"+"并不能直接写"+",而是需要转义,'\\'代表\    \+代表+  这里有两次转义
        String[] split = s2.split("\\+");
        int res = Integer.parseInt(split[0]) + Integer.parseInt(split[1]);

        //排除s1刚开始为空的情况
        if (!s1.isEmpty()) {
            res *= Integer.parseInt(s1);
        }
        if (!s3.isEmpty()) {
            res *= Integer.parseInt(s3);
        }
        return res;
    }
}
