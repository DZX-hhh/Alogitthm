package LeetCode.每日一题.Five.Day17;

public class Solution {
    /**
     * @param words 一组单词
     * @param order 火星上的单词顺序
     * @return 数组存储顺序, 返回是否按照火星上的单词顺序
     */
    int[] dictionary = new int[26];//火星上的字典

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            //这里将字典上的第char(i)-'a'位的权重设置为0...25(依次递增)
            //比如,如果char(i)='h',那么'h'-'a',那么第'h'-'a'的权重就是i(也就是0,最大)
            dictionary[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (!isValid(words[i - 1], words[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param word1 第一个单词
     * @param word2 第二个单词
     * @return 判断word1字典序是否在word前面
     */
    private boolean isValid(String word1, String word2) {
        if (word1.length() <= word2.length()) {//先保证word1的长度小于word2的长度
            for (int i = 0; i < word1.length(); i++) {
                if (dictionary[word1.charAt(i) - 'a'] > dictionary[word2.charAt(i) - 'a']) {//出现不合法,返回false
                    return false;
                } else if (dictionary[word1.charAt(i) - 'a'] < dictionary[word2.charAt(i) - 'a']) {//合法,不需要再遍历了
                    return true;
                }
            }
            return true;
        }
        //返回word2是否不在word1的前面
        return !isValid(word2, word1);//这里是为了避免"kuvp","q"的案例出现,因为可能word1在q的前面,但是word1的长度大于word2
    }
}
