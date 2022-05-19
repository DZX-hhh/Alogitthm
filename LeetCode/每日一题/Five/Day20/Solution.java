package LeetCode.每日一题.Five.Day20;

public class Solution {
    /**
     * @param words 内涵单词的字符数组
     * @param word1 第一个单词
     * @param word2 第二个单词
     * @return 返回两个单词的最短距离, 这里分别记录字母出现的最新下标,并且比较更新res
     */
    public int findClosest(String[] words, String word1, String word2) {
        int res = (int) 1e5;
        int idxWord1 = -1, idxWord2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                idxWord1 = i;
            } else if (words[i].equals(word2)) {
                idxWord2 = i;
            }
            if (idxWord1 >= 0 && idxWord2 >= 0) {
                res = Math.min(res, Math.abs(idxWord1 - idxWord2));
            }
        }
        return res;
    }
}
