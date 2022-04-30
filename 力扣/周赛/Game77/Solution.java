package 力扣.周赛.Game77;

public class Solution {
    /*
        indexOf()==1
     */
    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for (String s1 : words) {
            if (s.indexOf(s1) == 0) {
                count++;
            }
        }
        return count;
    }

    /*
        前缀和,注意溢出long
     */
    public int minimumAverageDifference(int[] nums) {
        int idx = 0, res = Integer.MAX_VALUE;
        if (nums.length == 1) {
            return 1;
        }
        long[] preSum = new long[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                if ((preSum[i + 1] - preSum[0]) / (i + 1) < res) {
                    res = (int) ((preSum[i + 1] - preSum[0]) / (i + 1));
                    idx = i;
                    return idx;
                }
            } else {
                long ave1 = (preSum[i + 1] - preSum[0]) / (i + 1);
                long ave2 = (preSum[preSum.length - 1] - preSum[i + 1]) / (nums.length - i - 1);
                if (Math.abs(ave1 - ave2) < res) {
                    res = (int) Math.abs(ave1 - ave2);
                    idx = i;
                }
            }
        }
        return idx;
    }


    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int grid[][] = new int[m][n], count = 0;
        //不能到达的都置为2
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }
        //这里开始让guard护卫,,被护卫的位置置为1
        for (int[] guard : guards) {
            //列不变,行减少,往上走
            for (int i = guard[0] - 1; i >= 0 && grid[i][guard[1]] < 2; i--) {
                grid[i][guard[1]] = 1;
            }
            //列不变,行增加,往下走
            for (int i = guard[0] + 1; i < grid.length && grid[i][guard[1]] < 2; i++) {
                grid[i][guard[1]] = 1;
            }
            //行不变,列减少,往左走
            for (int i = guard[1] - 1; i >= 0 && grid[guard[0]][i] < 2; i--) {
                grid[guard[0]][i] = 1;
            }
            //行不变,列增加,让右走
            for (int i = guard[1] + 1; i < grid[0].length && grid[guard[0]][i] < 2; i++) {
                grid[guard[0]][i] = 1;
            }
        }
        for (int[] i : grid) {
            for (int j : i) {
                count += 1 - Math.min(1, j);//只有当board[i,j]为0的时候,才是没有被保护的,需要+1,其他的都不算忽略
            }
        }
        return count;
    }
}