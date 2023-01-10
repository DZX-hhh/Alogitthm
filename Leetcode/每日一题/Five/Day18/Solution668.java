package LeetCode.每日一题.Five.Day18;

public class Solution668 {
    /*
        第k大或者第k小的
        一般medium使用优先队列,hard使用二分法查找
        这里可能优先队列内存会爆掉,这里某一行升序,,某一列也是升序因此使用二分查找
        这里求第k小的数,,属于二分查找的左边界
     */
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;//二分
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countLessK(m, n, mid) < k) {//这里查找小于当前mid值的个数
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * @param m       m行
     * @param n       n列
     * @param currVal 当前的值
     * @return m*n乘法表中的值 <= mid 的个数
     */
    private long countLessK(int m, int n, int currVal) {
        int count = 0;
        for (int i = 1; i <= m && i <= currVal; i++) {//遍历每一行
            //由于当前是在乘法表中,因此currVal/当前行i=当前列,,也就是有当前列个数<=currVal
            //当然一行最多也就只能是n个上限了
            count += Math.min(currVal / i, n);
        }
        return count;
    }
}
