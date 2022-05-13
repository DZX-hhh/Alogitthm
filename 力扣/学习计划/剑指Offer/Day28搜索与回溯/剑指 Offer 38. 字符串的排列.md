#### [剑指 Offer 38. 字符串的排列](https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/)

难度中等556收藏分享切换为英文接收动态反馈

输入一个字符串，打印出该字符串中字符的所有排列。

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

**示例:**

```
输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
```

**限制：**

```
1 <= s 的长度 <= 8
```

#### 思路

> 全排列问题,排序去重

#### Code

```java
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
```