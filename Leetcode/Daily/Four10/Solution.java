package Leetcode.Daily.Four10;

import java.util.HashMap;

public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] dict = new String[]{".-", "-...",
                "-.-.", "-..", ".", "..-.", "--.", "....",
                "..", ".---", "-.-", ".-..", "--", "-.", "---",
                ".--.", "--.-", ".-.", "...", "-", "..-", "...-",
                ".--", "-..-", "-.--", "--.."};
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                sb.append(dict[s.charAt(i) - 'a']);
            }
            String valueOf = String.valueOf(sb);
            map.put(valueOf, map.getOrDefault(valueOf, 0) + 1);
        }
        return map.keySet().size();
    }
}
