#### [剑指 Offer 12. 矩阵中的路径](https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/)

难度中等582收藏分享切换为英文接收动态反馈

给定一个 `m x n` 二维字符网格 `board` 和一个字符串单词 `word` 。如果 `word` 存在于网格中，返回 `true` ；否则，返回 `false` 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。

![img](https://assets.leetcode.com/uploads/2020/11/04/word2.jpg)

**示例 1：**

```
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
```

**示例 2：**

```
输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
```

**提示：**

- `1 <= board.length <= 200`
- `1 <= board[i].length <= 200`
- `board` 和 `word` 仅由大小写英文字母组成

**注意：**本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/

**`DFS`**

* 注意`boolean[]`可以通过将棋盘当前字符修改为`'\0'`替代

```java
public class Solution12 {
    public boolean exist(char[][] board, String word) {
        char[] wordArr = word.toCharArray();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, wordArr, 0, r, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param idx 字符当前索引
     * @param r   当前行
     * @param c   当前列
     */
    private boolean dfs(char[][] board, char[] wordArr, int idx, int r, int c) {
        //1.递归终止条件,,超出边界
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return false;
        }
        //2.当前位置和字符数组不同,,就直接返回
        if (board[r][c] != wordArr[idx]) {
            return false;
        }
        //3.如果访问到了最后,返回true
        if (idx == wordArr.length - 1) {
            return true;
        }

        /*4.开始做出选择,让当前位置为空'\0'*/
        board[r][c] = '\0';

        //5开始递归dfs,,只要当前有一个选择可行,那就直接返回true
        if (    dfs(board, wordArr, idx + 1, r, c + 1) ||
                dfs(board, wordArr, idx + 1, r, c - 1) ||
                dfs(board, wordArr, idx + 1, r + 1, c) ||
                dfs(board, wordArr, idx + 1, r - 1, c)
        ) {
            return true;
        }
        //5.撤销选择
        board[r][c] = wordArr[idx];

        return false;
    }
}
```