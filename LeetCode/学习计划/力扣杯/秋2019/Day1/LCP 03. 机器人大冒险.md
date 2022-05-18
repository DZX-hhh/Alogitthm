#### [LCP 03. 机器人大冒险](https://leetcode-cn.com/problems/programmable-robot/)

难度中等105收藏分享切换为英文接收动态反馈

力扣团队买了一个可编程机器人，机器人初始位置在原点`(0, 0)`。小伙伴事先给机器人输入一串指令`command`，机器人就会**无限循环**这条指令的步骤进行移动。指令有两种：

1. `U`: 向`y`轴正方向移动一格
2. `R`: 向`x`轴正方向移动一格。

不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用`obstacles`表示。机器人一旦碰到障碍物就会被**损毁**。

给定终点坐标`(x, y)`，返回机器人能否**完好**地到达终点。如果能，返回`true`；否则返回`false`。

**示例 1：**

```
输入：command = "URR", obstacles = [], x = 3, y = 2
输出：true
解释：U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)。
```

**示例 2：**

```
输入：command = "URR", obstacles = [[2, 2]], x = 3, y = 2
输出：false
解释：机器人在到达终点前会碰到(2, 2)的障碍物。
```

**示例 3：**

```
输入：command = "URR", obstacles = [[4, 2]], x = 3, y = 2
输出：true
解释：到达终点后，再碰到障碍物也不影响返回结果。
```

**限制：**

1. `2 <= command的长度 <= 1000`
2. `command`由`U，R`构成，且至少有一个`U`，至少有一个`R`
3. `0 <= x <= 1e9, 0 <= y <= 1e9`
4. `0 <= obstacles的长度 <= 1000`
5. `obstacles[i]`不为原点或者终点

**解题思路**

* 先判断能否到达终点
* 判断在到达终点前能否到达障碍物，若能则返回false
* 判断时，使用取模优化
* 第一轮机器人从坐标`(0, 0)->(fx, fy)`
* 若能到达目标点`(tx, ty) `则 必然满足 `tx = kfx + x0, ty = kfy + y0`
* 其中 `k = min(tx/fx, ty/fy)`

```java
public class LCP3 {
    /**
     * 1:先判断能否到达终点
     * 2:在到达重点钱是否到达陷阱,若能则返回false
     * 3:判断时取模优化
     * 4:第一轮机器人坐标(0,0)->(fx,fy),,记录一轮下来坐标总体发生的变化
     * 5:若能到达(tx,ty),必然满足tx=k*fx+x0,,,,,ty=k*fy+yo
     * 6:其中k=min(tx/fx,ty/fy)
     *
     * @param command   无限循环命令
     * @param obstacles 陷阱
     * @param tx        目标横坐标x
     * @param ty        目标纵坐标
     * @return
     */
    public boolean robot(String command, int[][] obstacles, int tx, int ty) {
        int n = command.length();
        int sx = 0, sy = 0;
        //记录走完一轮机器人的位置
        for (int i = 0; i < n; i++) {
            char c = command.charAt(i);
            if (c == 'U') ++sy;
            else ++sx;
        }

        //先计算能否达到重点,不考虑障碍物
        boolean canFinish = canReach(command, tx, ty, sx, sy);
        if (!canFinish) return false;
        //如果能在不考虑陷阱的情况下到达重点,那么就开始检查到达终点前能否到达陷阱,反之返回false
        for (int[] a : obstacles) {
            if (a[0] > tx || a[1] > ty) {//陷阱超过终点,不会爆炸
                continue;
            }
            if (canReach(command, a[0], a[1], sx, sy)) return false;
        }
        return true;
    }

    /*
    这里fx表示一轮下来,x的变化量
    判断是否能从(sx,sy)->(tx,ty)
    */
    private boolean canReach(String command, int tx, int ty, int fx, int fy) {
        //至少走这么多轮,在这之后必然有一个坐标等于目标值,这是唯一机会
        int loops = Math.min(tx / fx, ty / fy);
        int nowX = loops * fx, nowY = loops * fy;
        if (nowX == tx && nowY == ty) return true;
        int len = command.length();
        for (int i = 0; i < len; i++) {
            char c = command.charAt(i);
            if (c == 'U') ++nowY;
            else ++nowX;
            if (nowX > tx || nowY > ty) return false;
            if (nowX == tx && nowY == ty) return true;
        }
        return true;
    }
}

```

