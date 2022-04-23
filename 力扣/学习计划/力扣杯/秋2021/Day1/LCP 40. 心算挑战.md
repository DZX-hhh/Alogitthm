#### [LCP 40. 心算挑战](https://leetcode-cn.com/problems/uOAnQW/)

难度简单31

「力扣挑战赛」心算项目的挑战比赛中，要求选手从 `N` 张卡牌中选出 `cnt` 张卡牌，若这 `cnt` 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 `cnt` 张卡牌数字总和。 给定数组 `cards` 和 `cnt`
，其中 `cards[i]` 表示第 `i` 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡牌方案，则返回 0。

**示例 1：**

> 输入：`cards = [1,2,8,9], cnt = 3`
>
> 输出：`18`
>
> 解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。

**示例 2：**

> 输入：`cards = [3,3,1], cnt = 1`
>
> 输出：`0`
>
> 解释：不存在获取有效得分的卡牌方案。

**提示：**

- `1 <= cnt <= cards.length <= 10^5`
- `1 <= cards[i] <= 1000`

**排序** + **分类讨论**



> 如果倒数`cnt`个和不为偶数
> 将倒数第`cnt+1`个数,去取代从`cnt`开始到末尾与其奇偶性不同的第一个数
> (因为需要调整奇数偶数的个数)

```java
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
```
