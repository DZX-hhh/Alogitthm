package LeetCode.知识点.KMP;

public class Solution {
    public int strStr(String haystack, String needle) {

        //return haystack.indexOf(needle);

        int[] next = new int[needle.length()];
        getNext(needle, next);
        int slow = 0, fast = 0;
        while (slow < haystack.length() && fast < needle.length()) {
            if ((fast == -1) || (haystack.charAt(slow) == needle.charAt(fast))) {
                //如果匹配就继续遍历
                fast++;
                slow++;
            } else {
                //将fast较快的指针回退
                fast = next[fast];
            }
        }

        //如果fast成功走到needle的尾部,那么就用当前的slow-全部匹配成功的needle.length
        if (fast >= needle.length()) {
            return slow - needle.length();
        }
        return -1;//未找到
    }

    /**
     * 构造next数组
     *
     * @param needle
     * @param next
     */
    public void getNext(String needle, int[] next) {
        //初始化next[0]=-1
        int i = 0, j = -1;
        next[0] = -1;
        while (i < needle.length() - 1) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
    }
}
