package Leetcode.Study.二叉搜索树BST.不同的二叉树1;

public class Solution {
    //定义一个备忘录
    int[][] memorize;

    public int numTrees(int n) {
//        return count1(1, n);
        memorize = new int[n + 1][n + 1];
        return count2(1, n);
    }


    // 定义：闭区间 [lo, hi] 的数字能组成 count(lo, hi) 种 BST
    public int count1(int low, int high) {
        //base case
        if (low >= high) {
            return 1;
        }
        int res = 0;
        for (int i = low; i <= high; i++) {
            //每一个i都可以作为根节点,然后将区间分割成两段
            // (因为BST的左小右大特性)
            int left = count1(low, i - 1);
            int right = count1(i + 1, high);
            //每一个i作为根节点的结果就是左右排列组合
            res += left * right;
        }
        return res;
    }

    //定义:相比于之前,优化了重复子问题的情况
    //维护一个备忘录
    public int count2(int low, int high) {
        if (low > high) {
            return 1;
        }
        //如果备忘录里存在这个节点的计算结果,就直接返回,如果不存在,那么就继续计算
        if (memorize[low][high] != 0) {
            return memorize[low][high];
        }
        int res = 0;
        for (int i = low; i <= high; i++) {
            int left = count2(low, i - 1);
            int right = count2(i + 1, high);
            res += left * right;
        }
        //将最终结果存入备忘录维护
        memorize[low][high] = res;
        return res;
    }

}
