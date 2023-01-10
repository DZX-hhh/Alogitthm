package LeetCode.学习计划.剑指Offer.Day28搜索与回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution38 {
    List<String> res = new ArrayList<>();
    StringBuffer sb = new StringBuffer();
    boolean[] isVisited;

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        isVisited = new boolean[s.length()];
        String str = new String(chars);
        dfs(str);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(String str) {
        if (sb.length() == str.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (i > 0 && str.charAt(i - 1) == str.charAt(i) && !isVisited[i - 1]) {//这里发生相同的字符,因此不可以重复用分支
                continue;//跳过
            }
            if (!isVisited[i]) {
                isVisited[i] = true;
                sb.append(str.charAt(i));
                dfs(str);
                isVisited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
