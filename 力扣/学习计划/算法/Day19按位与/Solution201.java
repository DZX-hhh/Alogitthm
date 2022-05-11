package 力扣.学习计划.算法.Day19按位与;

public class Solution201 {
    /**
     * @param left
     * @param right
     * @return 按位与, 找left和right的公共前缀
     */
    public int rangeBitwiseAnd(int left, int right) {
        int step = 0;
        for (; left != right; step++) {
            left = left >> 1;
            right = right >> 1;
        }
        return left = left << step;
    }
}
