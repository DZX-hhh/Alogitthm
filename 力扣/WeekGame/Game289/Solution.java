package 力扣.WeekGame.Game289;

import java.util.HashMap;

public class Solution {
    public String digitSum(String s, int k) {
        if (s.length() <= k) return s;
        int len = s.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i += k) {//将字符串截取
            int sum = 0;
            for (int t = 0; t < k && i + t < len; t++) {//累加起来,这里t为计数器
                sum += (s.charAt(i + t) - '0');
            }
            sb.append(sum);//这里将第一次拆分后的累加结果
        }
        return digitSum(sb.toString(), k);//将第一次结果当作新的s,递归
    }


    public int minimumRounds(int[] tasks) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : tasks) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int key : map.keySet()) {
            int num = map.get(key);
            if (num > 3) {
                if (num % 3 == 0) {
                    res += num / 3;
                } else if (num % 3 == 2) {
                    res += num / 3 + 1;
                } else {
                    while (num % 3 != 0) {
                        num -= 2;
                        res++;
                    }
                    res += num / 3;
                }
            } else if (num > 1) {
                res++;
            } else {
                return -1;
            }
        }
        return res;
    }


    public int maxTrailingZeros(int[][] grid) {
        // 总体思路:枚举四种拐角路径->[左上,左下,右上,右下]
        // 这里由于是求路径中尾随0的的最大个数,因此肯定是路径某个方向取最长的结果(多了某个格子不影响0*其他数都为0)
        // 我们要找尾随0的个数必须要10因子,必然可以分解为2与5因子,[2,5]的对数就是尾随0个数->min(2的个数,5的个数)
        int m = grid.length, n = grid[0].length;
        // 创建四个二维数组分别代表:grid[i - 1][j - 1](含)左边的2,5因子总个数;grid[i][j](含)上边的2,5因子总个数
        int[][] r2 = new int[m + 1][n + 1], r5 = new int[m + 1][n + 1], c2 = new int[m + 1][n + 1], c5 = new int[m + 1][n + 1];
        // 默认左边界和上边界的为r2[i][0]=c2[0][j]=r5[i][0]=c5[0][j]=0
        // 遍历每个格子完善r2,r5,c2,c5
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 当前格子的值
                int cur = grid[i - 1][j - 1];
                int num2 = getFactorNum(cur, 2), num5 = getFactorNum(cur, 5);
                // 进行转移求前缀和
                r2[i][j] = r2[i][j - 1] + num2;
                r5[i][j] = r5[i][j - 1] + num5;
                c2[i][j] = c2[i - 1][j] + num2;
                c5[i][j] = c5[i - 1][j] + num5;
            }
        }
        // 结果
        int res = 0;
        // 遍历四种拐弯方向(其余的都可以进行等价)
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // grid[i-1][j-1]为拐弯的格子,总体计算方法就是横竖的2或者5因子个数相加,注意避免重叠
                // 左边向右出发,然后向上走
                int min1 = Math.min(r2[i][j] + c2[i - 1][j], r5[i][j] + c5[i - 1][j]);
                res = Math.max(res, min1);
                // 左边向右出发,然后向下走
                int min2 = Math.min(r2[i][j] + c2[m][j] - c2[i][j], r5[i][j] + c5[m][j] - c5[i][j]);
                res = Math.max(res, min2);
                // 右边向左出发,然后向上走
                int min3 = Math.min(r2[i][n] - r2[i][j] + c2[i][j], r5[i][n] - r5[i][j] + c5[i][j]);
                res = Math.max(res, min3);
                // 右边向左出发,然后向下走
                int min4 = Math.min(r2[i][n] - r2[i][j] + c2[m][j] - c2[i - 1][j], r5[i][n] - r5[i][j] + c5[m][j] - c5[i - 1][j]);
                res = Math.max(res, min4);
            }
        }
        return res;
    }

    // 获取某个数字对应因子的数目:8=2*2*2
    private int getFactorNum(int num, int factor) {
        int k = 0;
        // 提取因子
        while (num % factor == 0) {
            num /= factor;
            k++;
        }
        return k;
    }
}

