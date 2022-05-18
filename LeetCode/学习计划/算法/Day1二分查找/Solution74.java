package LeetCode.学习计划.算法.Day1二分查找;

public class Solution74 {
    //二分法,,题目宏观上是升序的,用一次循环解决[mid/n][mid%n]
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (matrix[mid / n][mid % n] > target) {
                right = mid - 1;
            } else if ((matrix[mid / n][mid % n]) < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}
