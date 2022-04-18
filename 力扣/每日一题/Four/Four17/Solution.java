package 力扣.每日一题.Four.Four17;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> ban = new HashSet<>();
        for (String s : banned) ban.add(s);
        int max = 0;
        String res = "";
        HashMap<String, Integer> map = new HashMap<>();
        paragraph = paragraph.toLowerCase();
        String[] splits = paragraph.split("[ ,.!?:;']");//正则表达式[]表示[里面的一种]
        //split("[^a-zA-Z]+")也可以这样
        for (String split : splits) {
            if (!ban.contains(split) && split.length() > 0) {
                map.put(split, map.getOrDefault(split, 0) + 1);
                if (map.get(split) > max) {
                    max = map.get(split);
                    res = split;
                }
            }
        }
        return res;
    }
}
