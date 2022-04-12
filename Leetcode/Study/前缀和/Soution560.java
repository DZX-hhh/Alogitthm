package Leetcode.Study.前缀和;

import java.util.HashMap;

public class Soution560 {
//    public int subarraySum(int[] nums, int k) {
//        int[] preSum = new int[nums.length+1];
//        //构造前缀数组
//        for (int i = 1; i < nums.length + 1; i++) {
//            preSum[i] = preSum[i - 1] + nums[i - 1];
//        }
//        int count=0;
//        /*
//         * 遍历子数组,验证之和
//         */
//        for (int j = 1; j <= nums.length; j++) {
//            for (int t = 0; t < j; t++) {
//                if (k==preSum[j]-preSum[t]){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    /**
     * 优化,在第二层for循环中的判断条件k==preSum[j]-preSum[t]
     * 优化之后:preSum[t]=preSum[j]-k
     * 意思就是希望找到前缀和preSum[t]为preSum[j]-k
     * 使用一个HashMap记录 Study.前缀和------>该前缀和出现的次数
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        //构造前缀和以及出现的次数,,hash表

        //防止特殊情况,num[0.....j]为k的情况,这个时候应该结果直接在原来的基础上ans+1,而非赋值为1
        preSum.put(0, 1);

        int sum_j = 0, ans = 0;
        for (int j = 0; j < nums.length; j++) {//第一次循环
//            取而代之第二次循环  换成hashmap寻找前缀和等于preSum[j]-k
            sum_j += nums[j];//[0....j]的前缀和

            //寻找的目标值sum_t
            int sum_t = sum_j - k;
            //如果找到,更新答案
            if (preSum.containsKey(sum_t)) {
                ans += preSum.get(sum_t);//考虑sum_j-k=0也就是目标为0的情况,也是直接+1,否则的话就没有+1
            }
            //将前缀和[0....j]sum_j存到preSum中
            // 如果已经存在,在它的值上+1
            //如果不存在,就默认为0+1
            preSum.put(sum_j, preSum.getOrDefault(sum_j, 0) + 1);
        }
        return ans;
    }
}

