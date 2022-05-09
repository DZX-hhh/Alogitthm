package 力扣.学习计划.剑指Offer.Day25模拟;

import java.util.ArrayList;
import java.util.List;

public class Solution29 {
    /*
        模拟二维数组,,四个边界
        1.左(left)-->右(right)
        2.上(top)-->下(below)
        3.右(right)-->左(left)
        4.下(below)-->上(top)
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        //左右边界
        int left = 0, right = matrix[0].length - 1;
        //上下边界
        int top = 0, below = matrix.length - 1;
        int[] res = new int[(right + 1) * (below + 1)];
        int idx = 0;
        while (true) {
            for (int i = left; i <= right; i++) {//1.左-->右
                res[idx++] = matrix[top][i];
            }
            if (++top > below) {//层数+1,到达最后返回
                break;
            }
            for (int i = top; i <= below; i++) {//2.上-->下
                res[idx++] = matrix[i][right];
            }
            if (left > --right) {//层数-1,到达最后返回
                break;
            }
            for (int i = right; i >= left; i--) {//3.右-->左
                res[idx++] = matrix[below][i];
            }
            if (top > --below) {//层数-1
                break;
            }
            for (int i = below; i >= top; i--) {//4.下-->上
                res[idx++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }


    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        //左右边界
        int left = 0, right = matrix[0].length - 1;
        //上下边界
        int top = 0, below = matrix.length - 1;
        int idx = 0;
        while (true) {
            for (int i = left; i <= right; i++) {//1.左-->右
                res.add(matrix[top][i]);
            }
            if (++top > below) {//层数+1,到达最后返回
                break;
            }
            for (int i = top; i <= below; i++) {//2.上-->下
                res.add(matrix[i][right]);
            }
            if (left > --right) {//层数-1,到达最后返回
                break;
            }
            for (int i = right; i >= left; i--) {//3.右-->左
                res.add(matrix[below][i]);
            }
            if (top > --below) {//层数-1
                break;
            }
            for (int i = below; i >= top; i--) {//4.下-->上
                res.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
