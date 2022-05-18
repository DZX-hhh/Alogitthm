package LeetCode.学习计划.编程能力.Day1;

public class Solution28 {
    //直接调用库函数
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 字符串匹配问题,,KMP算法
     */
    public int strStr2(String haystack, String needle) {

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
