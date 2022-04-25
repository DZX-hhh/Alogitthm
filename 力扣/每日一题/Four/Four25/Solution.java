package 力扣.每日一题.Four.Four25;

import java.util.Random;

//暴力随机,数组太长不行
public class Solution {
    int[] nums;
    int first, second;
    Random random;

    public Solution(int[] nums) {
        first = -1;
        second = -1;
        random = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                first = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                second = i;
                break;
            }
        }
        return first > second ? -1 : first + random.nextInt(second - first);
    }
}

//水塘抽样法
class waterPick {
    int[] arr;
    Random random;

    public waterPick(int[] nums) {
        arr = nums;
        random = new Random();
    }

    public int pick(int target) {
        int res = 0;
        int count = 0;//目标值的数量
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                count++;//数量+1
                if (random.nextInt(count) == 0) {
                    //水塘抽样,如果在[0,,count-1]的情况下抽到第一个,也就是等概率抽到
                    res = i;
                }
            }
        }
        return res;
    }
}
