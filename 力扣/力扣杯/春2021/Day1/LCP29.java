package 力扣.力扣杯.春2021.Day1;

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
