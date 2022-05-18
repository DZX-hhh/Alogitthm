package 力扣.每日一题.Four.Four29;

public class Soluton {
    int[][] g;

    public Node construct(int[][] grid) {
        g = grid;
        return dfs(0, 0, g.length - 1, g.length - 1);
    }

    /**
     * @param row1 左上角的行
     * @param col1 左上角的列
     * @param row2 右下角的行
     * @param col2 右下角的列
     * @return 返回能够代表矩阵的根节点
     * 这里判断矩阵是否全为0或者全为1
     * - 如果是,直接创造根节点,并设置子节点为空并返回
     * - 反之,创建根节点,递归创建四个子节点并赋值,,利用左上角(row1,col1)和右下角(row2,col2)
     * 算的横纵坐标的长度为row2-row1+1和col2-col2+1
     * 从而,,计算当前矩阵坐标
     */
    private Node dfs(int row1, int col1, int row2, int col2) {
        boolean isAllSame = true;
        //1.记录左上角开头的数字为0或者1
        /*
            这里判断全为0或者全为1
            可以使用前缀和优化
            如果前缀和为0或者是dtX*dtY的情况下则证明全为一致,反之不然
         */
        int start = g[row1][col1];
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                if (g[i][j] != start) {
                    isAllSame = false;//只要出现和左上角开头数字不同,则标记为false
                }
            }
        }

        //2.根据isAllSame创建节点
        if (isAllSame) {
            return new Node(start == 1, true);//直接创建为叶子节点,并返回
        }
        Node res = new Node(start == 1, false);//开始递归创建四个孩子节点
        int dtX = row2 - row1 + 1, dtY = col2 - col1 + 1;
        //这里根据跨度分成四个部分,,左上,右上,左下,右下
        res.topLeft = dfs(row1, col1, row1 + dtX / 2 - 1, col1 + dtY / 2 - 1);
        res.topRight = dfs(row1, col1 + dtY / 2, row1 + dtX / 2 - 1, col2);
        res.bottomLeft = dfs(row1 + dtX / 2, col1, row2, col1 + dtY / 2 - 1);
        res.bottomRight = dfs(row1 + dtX / 2, col1 + dtY / 2, row2, col2);
        return res;
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
