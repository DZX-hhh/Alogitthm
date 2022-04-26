package 力扣.周赛.Game277;

public class T4 {

    /**
     * 二进制枚举,,找到好人,,判断好人说的话与事实是否相符,符合count+1,反之,跳到外层循环
     *
     * @param statements 陈述
     */
    public int maximumGood(int[][] statements) {
        int res = 0;
        int n = statements.length;
        next:
        for (int i = 1; i < (1 << n); i++) {//范围为[0,2ⁿ-1],,这里(1<<n)的意思是1转化成二进制,并向左移动n位,,也就是`1*2*2*....*2=2ⁿ`
            int count = 0;//枚举的每个二进制数字i中好人的个数
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {//找到好人
                    //将二进制i有移动j位置,,并且`&` '00000.....1',意思就是取出i中二进制位置第j位的值,,如果为1,那么就说明这个人是好人,
                    // 只有好人才会发生矛盾,,检测好人的陈述和实际是否一致
                    for (int k = 0; k < n; k++) {
                        //当好人陈述k为真,并且二进制右移动k位与陈述结果不一致,,说明发生矛盾
                        if (statements[j][k] < 2 && statements[j][k] != ((i >> k) & 1)) {
                            continue next;
                        }
                    }
                    count++;//不发生矛盾,好人+1
                }
            }
            res = Math.max(res, count);
        }
        return res;
    }
}