package 力扣.知识点.随机算法.随机数索引;

import java.util.Random;

public class Solution {
    /**
     * 水塘抽样,保持1/i的概率更新答案
     */
    //HashMap<Integer, List<Integer>> targetToIndexs;
    int[] arr;
    Random random;

    public Solution(int[] nums) {
        //targetToIndexs = new HashMap<>();
        arr = nums;
        random = new Random();
    }

    public int pick(int target) {
        int res = 0;
        int count = 0;//值=target的元素个数
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == target) {
                count++;
                if (random.nextInt(count) == 0) {//第i个元素有i/i的概率更新答案
                    res = index;//更新答案
                }
            }
        }
        return res;
    }
}
