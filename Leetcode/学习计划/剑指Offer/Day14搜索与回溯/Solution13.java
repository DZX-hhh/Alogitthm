package LeetCode.学习计划.剑指Offer.Day14搜索与回溯;

public class Solution13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] isValid = new boolean[m][n];
        return dfs(m, n, 0, 0, k, isValid);
    }

    private int dfs(int m, int n, int r, int c, int k, boolean[][] isValid) {
        //1.超过边界,返回0
        if (r >= m || c >= n || r < 0 || c < 0) {
            return 0;
        }
        //2.位和大于k,返回0
        if ((r % 10 + r / 10 + c % 10 + c / 10) > k) {
            return 0;
        }
        //3.已经访问过,返回0
        if (isValid[r][c]) {
            return 0;
        }
        //4.开始选择
        isValid[r][c] = true;
        //5.递归
        return dfs(m, n, r - 1, c, k, isValid) +
                dfs(m, n, r + 1, c, k, isValid) +
                dfs(m, n, r, c - 1, k, isValid) +
                dfs(m, n, r, c + 1, k, isValid) + 1;

        /*
            这里不需要回溯,撤销选择,因为这里是标记某个点能否通过,能通过就true,反之false
         */
    }
}
