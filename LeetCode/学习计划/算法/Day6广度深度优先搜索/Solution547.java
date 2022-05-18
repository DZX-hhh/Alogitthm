package LeetCode.学习计划.算法.Day6广度深度优先搜索;

public class Solution547 {
    /*
        这一题的dfs有所区别,,岛屿类的题目是相连的网格状的图,这里不是,因此使用一个isValid[]记录是否访问过
     */
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        int n = isConnected.length;
        boolean[] isValid = new boolean[n];
        for (int i = 0; i < n; i++) {
            //拉黑这个还没有访问的人的朋友圈
            if (!isValid[i]) {
                res++;
                dfs(isConnected, isValid, i);
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected, boolean[] isValid, int i) {
        if (i < 0 || i >= isValid.length) {
            return;
        }
        if (isValid[i]) {
            return;
        }
        //记录访问
        isValid[i] = true;
        //dfs这个人的朋友圈
        for (int j = 0; j < isConnected.length; j++) {
            //只有相连接的才能dfs
            if (isConnected[i][j] == 1) {
                dfs(isConnected, isValid, j);
            }
        }
    }

    /*
         连通的省份-->连通分量-->union-->并查集
    */
    public int findCircleNum2(int[][] isConnected) {
        int res = 0;
        int n = isConnected.length;
        UF uf = new UF(n);//设置刚开始的连通分量
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //将连通分量连通起来
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

}

/**
 * 并查集
 */
class UF {
    int[] parent;//连通分量的根源节点
    int count;//节点的个数

    public UF(int size) {
        count = size;//设置大小
        parent = new int[size];//初始化根源节点为自己
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    /**
     * @param i 当前节点
     * @return 迭代找到当前节点的根源节点
     */
    public int findParent(int i) {
        while (parent[i] != i) {//当这个节点的父亲不是自己(只有根源节点的父亲是自己)
            parent[i] = parent[parent[i]];//"爸爸"-->"爷爷"
            i = parent[i];//"自己"-->"爸爸"
        }
        return i;
    }

    /**
     * @param i
     * @param j
     * @return i和j节点是否为连通分量, 主要在于这两个节点是否为同一个根源节点
     */
    public boolean isConnected(int i, int j) {
        return findParent(i) == findParent(j);
    }

    /**
     * 连通i和j这两个节点
     */
    public void union(int i, int j) {
        int parentI = findParent(i);
        int parentJ = findParent(j);
        if (parentI != parentJ) {
            //让i,j的这两个节点的任意一个父亲节点作为根源节点
            parent[parentI] = parentJ;
            count--;//节点数目减少()连通分量
        }
    }

    public int getCount() {
        return count;
    }
}
