package 力扣.学习计划.力扣杯.秋2021;

import java.util.Arrays;

public class LCP40 {
    /**
     * 取出最大的cnt的个数和,如果为偶数,直接返回,为奇数,分两种情况
     * 1.cnt=1,找到最大的偶数即可,找不到返回0
     * 2.cnt!=1,和为奇数,必然存在奇数和偶数,,只需倒数cnt+1的数,替换cnt个数中的一个(奇偶性不同,差值最小)
     *
     * @param cards
     * @param cnt
     * @return
     */
    public int maxmiumScore(int[] cards, int cnt) {
        int res = 0;
        //排序
        Arrays.sort(cards);
        //对cnt为1的情况单独处理,先找最大偶数,,失败返回0
        if (cnt == 1) {
            for (int i = cards.length - 1; i >= 0; i--) {
                if (cards[i] % 2 == 0) return cards[i];
            }
            return 0;
        }

        //获取倒数cnt个数
        int i = cards.length - 1;
        for (; i >= cards.length - cnt; i--) {
            res += cards[i];
        }
        //如果倒数cnt个数和为偶数
        if (res % 2 == 0) return res;

        //i<0表示cnt==cards.length,,即只有一种选择
        if (i < 0) return 0;

        //倒数cnt个数的奇偶性,必然有奇数偶数
        // true为偶数,false为奇数
        boolean flag = cards[i] % 2 == 0;
        //此时,i为倒数第cnt+1个数,替代在倒数cnt之内的和i   `奇偶性不同的差值最小的数`
        int index = i + 1;//从cnt开始

        //找到奇偶性不同的数
        while (index < cards.length && (flag == (cards[index] % 2 == 0))) {
            index++;
        }

        //替换这两个数
        res = res - cards[index] + cards[i];

        return res;
    }
}
