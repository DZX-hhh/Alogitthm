package 力扣.力扣杯.秋2019.Day2;

import java.util.HashMap;
import java.util.Map;

/**
 * DFS+剪枝
 */
class LCP04 {

    int stack_ptr = 0;

    int[][] vis = new int[10][10];
    int m;
    int n;
    long[] b2 = new long[64];
    int final_ans = 0;
    int[][] bk_cnt = new int[10][10];

    Map<Long, Integer> dp_vis = new HashMap<>();

    public int domino(int n, int m, int[][] broken) {

        b2[0] = 1;
        for (int i = 1; i < m * n; ++i) {
            b2[i] = 2 * b2[i - 1];
        }

        this.n = n;
        this.m = m;
        for (int i = n; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                vis[i][j] = 1;
            }
        }

        for (int i = 0; i < 10; ++i) {
            for (int j = m; j < 10; ++j) {
                vis[i][j] = 1;
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int cnt = 0;
                for (int k = 0; k < broken.length; ++k) {
                    int[] item = broken[k];
                    int bk_x = item[0];
                    int bk_y = item[1];
                    if (bk_x * m + bk_y >= i * m + j) {
                        bk_cnt[i][j]++;
                    }
                }
            }
        }


        for (int i = 0; i < broken.length; ++i) {
            int[] xy = broken[i];
            vis[xy[0]][xy[1]] = 1;
        }

        long key = get_key();
        dfs(0, 0, key);
        return final_ans;

    }

    public long get_key() {
        int x = 0;
        int y = 0;
        long sum = 0;
        sum += b2[0] * vis[x][y];
        for (int i = 1; i <= m * n - 1; ++i) {
            int[] xy = nxt(x, y);
            x = xy[0];
            y = xy[1];
            sum += b2[i] * vis[x][y];
        }
        return sum;
    }

    public void dfs(int x, int y, long key) {
        if (x >= n) {
            if (stack_ptr > final_ans) {
                final_ans = stack_ptr;
            }
            return;
        }

        if (dp_vis.get(key) != null) {
            return;
        }

        //剪枝
        int r = m * n - (x * m + y) - bk_cnt[x][y];
        if (stack_ptr + r / 2 <= final_ans) {
            return;
        }

        int[] nxt_xy = nxt(x, y);
        int nxt_x = nxt_xy[0];
        int nxt_y = nxt_xy[1];

        if (vis[x][y] == 0 && vis[x + 1][y] == 0) {
            int idx_1 = x * m + y;
            int idx_2 = (x + 1) * m + y;

            key += b2[idx_1];
            key += b2[idx_2];
            mp_do(x, y, 1);

            dfs(nxt_x, nxt_y, key);

            mp_undo(x, y, 1);
            key -= b2[idx_1];
            key -= b2[idx_2];
        }

        if (vis[x][y] == 0 && vis[x][y + 1] == 0) {
            int idx_1 = x * m + y;
            int idx_2 = idx_1 + 1;

            key += b2[idx_1];
            key += b2[idx_2];
            mp_do(x, y, 2);

            dfs(nxt_x, nxt_y, key);

            mp_undo(x, y, 2);
            key -= b2[idx_1];
            key -= b2[idx_2];
        }

        //pass
        dfs(nxt_x, nxt_y, key);
        dp_vis.put(key, 0);

    }

    public int[] nxt(int x, int y) {
        int[] ret = new int[2];
        if (y == m - 1) {
            ret[0] = x + 1;
            ret[1] = 0;
        } else {
            ret[0] = x;
            ret[1] = y + 1;
        }
        return ret;
    }

    public void mp_do(int x, int y, int type) {
        if (type == 1) {
            vis[x][y] = 1;
            vis[x + 1][y] = 1;
        } else {
            //type == 2
            vis[x][y] = 1;
            vis[x][y + 1] = 1;
        }
        stack_ptr++;
    }

    public void mp_undo(int x, int y, int type) {
        if (type == 1) {
            vis[x][y] = 0;
            vis[x + 1][y] = 0;
        } else {
            //type == 2
            vis[x][y] = 0;
            vis[x][y + 1] = 0;
        }
        stack_ptr--;
    }
}