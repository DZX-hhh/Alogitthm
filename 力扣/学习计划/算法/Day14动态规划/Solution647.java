package 力扣.学习计划.算法.Day14动态规划;

public class Solution647 {
    /*
        dp[i][j]含义:[i,j]范围的字串是回文串
        递推方程:如果[i]!=[j],说明dp=false;
                   [i]==[j],说明有可能是回文串;
               一般出现3种情况:
                1.i=j,也就是"a"这种情况,dp=true
                2.j-1=1,也就是二者是相邻,"aa",dp=true
                3.j-i>1;"cbabc"-->"bab",转换成dp[i+1][j-1]==true?true:false
                         这里考虑到[i][j]依赖于[i+1][j-1],因此需要先知道[i+1][j-1]才能知道[i][j]
                         因此由下往上(i--),由左往右(j++)
     */
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i; j < dp[0].length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;//情况1,2:dp=true
                        res++;
                    } else if (dp[i + 1][j - 1]) {//情况3
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }


    /*
        双指针:也称中间扩散法
        中心点出现两种情况:
                1.一个中心点
                2.两个中心点
     */
    public int countSubstrings2(String s) {
        int res = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            res += extend(s, i, i, len);//以i为中心点向旁边扩散
            res += extend(s, i, i + 1, len);//以i,i+1作为中心点往旁边扩散
        }
        return res;
    }

    /**
     * @param centerLeft  中心左端
     * @param centerRight 中心右端
     * @return center的回文数目
     */
    private int extend(String s, int centerLeft, int centerRight, int len) {
        int res = 0;
        //确保范围以及相等
        while (centerLeft >= 0 && centerRight < len && s.charAt(centerLeft) == s.charAt(centerRight)) {
            centerLeft--;
            centerRight++;
            res++;
        }
        return res;
    }
}
