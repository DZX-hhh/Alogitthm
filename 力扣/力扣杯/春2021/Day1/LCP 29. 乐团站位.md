#### [LCP 29. 乐团站位](https://leetcode-cn.com/problems/SNJvJP/)

难度中等61

某乐团的演出场地可视作 `num * num` 的二维矩阵 `grid`（左上角坐标为 `[0,0]`)，每个位置站有一位成员。乐团共有 `9` 种乐器，乐器编号为 `1~9`，每位成员持有 `1` 个乐器。

为保证声乐混合效果，成员站位规则为：自 `grid` 左上角开始顺时针螺旋形向内循环以 `1，2，...，9` 循环重复排列。例如当 num = `5` 时，站位如图所示

![image.png](https://pic.leetcode-cn.com/1616125411-WOblWH-image.png)

请返回位于场地坐标 [`Xpos`,`Ypos`] 的成员所持乐器编号。

**示例 1：**

> 输入：`num = 3, Xpos = 0, Ypos = 2`
>
> 输出：`3`
>
> 解释：
> ![image.png](https://pic.leetcode-cn.com/1616125437-WUOwsu-image.png)

**示例 2：**

> 输入：`num = 4, Xpos = 1, Ypos = 2`
>
> 输出：`5`
>
> 解释：
> ![image.png](https://pic.leetcode-cn.com/1616125453-IIDpxg-image.png)

**提示：**

- `1 <= num <= 10^9`
- `0 <= Xpos, Ypos < num`

  **剥皮法**

- 小心`int`溢出

```java
public class LCP29 {
    /**
     * 扒皮法:
     * 1.找到[xPos,yPos]这个位置在第几层
     * 2.将这层之外的皮扒掉
     * 3.找到这层的起始位置
     * 4.开始模拟
     *
     * @param num
     * @param xPos
     * @param yPos
     * @return
     */
    public int orchestraLayout(int num, int xPos, int yPos) {
        //当前数字
        long ceng = 0;
        long beginNum = 0;
        //当位置不是第0层,这个时候需要扒皮
        if (xPos != 0 && yPos != num - 1 && yPos != 0 && xPos != num - 1) {
            //1.找到第几层,这里的x,y二者的最小值,说明可以扒掉的层数
            long x = Math.min(xPos, num - 1 - xPos);
            long y = Math.min(yPos, num - 1 - yPos);
            //当前位置所在层数
            ceng = Math.min(x, y);
            //2.扒皮之后的起始位置:num²-扒皮后的正方形边长²,,也就是已经去除的数字个数
            beginNum = (long) (Math.pow(num, 2) - Math.pow(num - 2 * ceng, 2));
            //3.扒皮
            num -= ceng * 2;
            //4.开始模拟
            xPos -= ceng;
            yPos -= ceng;
        }
        /*开始找到[xpos,ypos]在'上右下左'的那个位置*/

        //'上'
        if (xPos == 0) {
            long mod = ((beginNum + 1) + yPos) % 9;
            //如果取余为0,返回9;反之直接返回
            if (mod == 0) {
                return 9;
            } else {
                return (int) mod;
            }
        }
        //'下'
        else if (xPos == num - 1) {
            long mod = ((beginNum + 1) + 2L * (num - 1) + (num - 1 - yPos)) % 9;
            if (mod == 0) {
                return 9;
            } else {
                return (int) mod;
            }
        }
        //'左'
        else if (yPos == 0) {
            long mod = ((beginNum + 1) + 3L * (num - 1) + (num - 1 - xPos)) % 9;
            if (mod == 0) {
                return 9;
            } else {
                return (int) mod;
            }
        }
        //'右'
        else if (yPos == num - 1) {
            //右移动num-1次
            long mod = (((beginNum + 1) + xPos) + num - 1) % 9;
            if (mod == 0) {
                return 9;
            } else {
                return (int) mod;
            }
        }
        return 0;
    }
}
```