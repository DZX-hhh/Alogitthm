package LeetCode.学习计划.剑指Offer.Day13双指针;

public class Solution58 {
    /*
        split()特点:如果连续两个分隔符在一块,那么会得到(前面结果,空,后面结果)
     */
    public String reverseWords(String s) {
        String[] split = s.trim().split(" ");//这里python里面split()默认多个空格为一个空格
        StringBuilder res = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].equals("")) {//遇到空字符就跳过,,因为split()特点:如果连续两个分隔符在一块,那么会得到(前面结果,空,后面结果)
                continue;
            }
            res.append(split[i]).append(" ");
        }
        return res.toString().trim();
    }

    /*
        双指针
     */
    public String reverseWords2(String s) {
        char[] sArray = s.toCharArray();
        //1.先翻转整个字符串数组
        reverse(sArray, 0, s.length() - 1);
        //2.翻转每个单词
        reverseWord(sArray, s.length());
        //3.去除多余空格
        return cleanSpace(sArray, sArray.length);
    }

    /**
     * 翻转数组某个区间
     *
     * @param i 起始位置
     * @param j 结束位置
     */
    private void reverse(char[] sArray, int i, int j) {
        while (i < j) {
            char t = sArray[i];
            sArray[i++] = sArray[j];
            sArray[j--] = t;
        }
    }

    /**
     * 翻转数组的每个字母-->主要是找到
     */
    private void reverseWord(char[] sArray, int length) {
        int i = 0, j = 0;
        while (j < length) {
            //1.找到第一个首字母
            while (i < length && sArray[i] == ' ') {
                i++;
            }
            j = i;
            //2.找到末尾字母
            while (j < length && sArray[j] != ' ') {
                j++;
            }
            //3.开始翻转字母
            reverse(sArray, i, j - 1);
            //4.继续寻找下一个首字母
            i = j;
        }
    }

    /**
     * 去除多余空格
     */
    private String cleanSpace(char[] sArray, int length) {
        int i = 0, j = 0;
        while (j < length) {
            //1.跳过前置空格
            while (j < length && sArray[j] == ' ') {
                j++;
            }
            //2.找到非空格,即为单词,修改
            while (j < length && sArray[j] != ' ') {
                sArray[i++] = sArray[j++];
            }
            //3.单词记录结束,继续跳过空格
            while (j < length && sArray[j] == ' ') {
                j++;
            }
            //4.如果后面还有单词,就在当前位置加一个' '
            if (j < length) {
                sArray[i++] = ' ';
            }
        }
        //返回[0,i-1]的字符串
        return new String(sArray).substring(0, i);
    }
}
