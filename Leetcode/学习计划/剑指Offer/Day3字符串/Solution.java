package LeetCode.学习计划.剑指Offer.Day3字符串;

public class Solution {
    public String replaceSpace(String s) {
        int len = s.length();
        char[] array = new char[3 * len];
        int size = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = s.charAt(i);
            }
        }
        String res = new String(array, 0, size);
        return res;
    }


    public String reverseLeftWords(String s, int n) {
        String res = "";
//        for (int i = n; i < s.length(); i++) {
//            sb.append(s.charAt(i));
//        }
//        for (int i = 0; i < n; i++) {
//            sb.append(s.charAt(i));
//        }
        //简化前面的代码  "取余操作"
        for (int i = n; i < s.length() + n; i++) {
            res += (s.charAt((i) % s.length()));
        }
        return res;
    }
}
