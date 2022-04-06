package Leetcode.LeetcodeStudy.前缀和.树状数组;

public class Solution {
}

/**
 * Study.前缀和.树状数组
 */
class NumArray {
    //前缀和数组
    int[] preSum;
    //更后的数组
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        preSum = new int[nums.length + 1];
        //初始化前缀数组
        for (int i = 0; i < nums.length; i++) {
            insert(i, nums[i]);
        }
    }

    /**
     * @param x 传入的下标
     * @return 返回树状数组的移动下标
     */
    public int lowBit(int x) {
        return x & (-x);
    }

    /**
     * 在index处插入val元素
     *
     * @param index
     * @param val
     */
    public void insert(int index, int val) {
        //i+=lowBit(i)是树状数组被影响的下一个下标
        for (int i = index + 1; i < preSum.length; i += lowBit(i)) {
            preSum[i] = preSum[i] + val;
        }
    }

    /**
     * 与插入的区别就在于后面的更新的一行代码
     *
     * @param index
     * @param val
     */
    public void update(int index, int val) {
        //i+=lowBit(i)是树状数组被影响的下一个下标
        for (int i = index + 1; i < preSum.length; i += lowBit(i)) {
            preSum[i] = preSum[i] - nums[index] + val;
        }
        //更新数组元素
        nums[index] = val;
    }

    /**
     * @param index
     * @return [1, , , , index]的前缀和
     */
    public int queryPreSum(int index) {
        int sum = 0;
        while (index != 0) {
            sum += preSum[index];
            index -= lowBit(index);
        }
        return sum;
    }

    public int sumRange(int left, int right) {
        return queryPreSum(right + 1) - queryPreSum(left);
//        return preSum[right + 1] - preSum[left];
//这里不可以这样直接使用前缀数组,因为树状数组的下标不是+1,而是+lowBit(i)
    }
}
