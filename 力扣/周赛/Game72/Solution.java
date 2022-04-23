package 力扣.周赛.Game72;


import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && ((i * j) % k == 0)) {
                    count++;
                }
            }
        }
        return count;
    }

    public long[] sumOfThree(long num) {
        if (num % 3 != 0) {
            return new long[]{};
        }
        return new long[]{num / 3 - 1, num / 3, num / 3 + 1};
    }

    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 != 0) {
            return new LinkedList<>();
        }
        List<Long> res = new LinkedList<>();
        long targrt = finalSum;//目标拆分值
        long base = 2;//起始拆分数
        while (targrt > base * 2) {//base<target/2;否则会出现重复
            res.add(base);
            targrt -= base;//目标拆分值,拆分成为base和target-base
            base += 2;//起始拆分数增加到下一个偶数
        }
        //当跳出循环的时候,target显然是无法差分的,并且也一直是从大到小拆分,因此将target加入res
        res.add(targrt);
        return res;
    }
}

