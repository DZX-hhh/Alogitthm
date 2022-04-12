package Leetcode.Study.图论.拓扑排序;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 核心在于记录后序遍历结果,并反转
 * 即为"左右根"--->"根右左"
 */

public class DFS2 {
    //有向无环图,是否访问过
    boolean[] isVisited;
    //当前经过的路径
    boolean[] onPath;
    //是否存在环
    boolean hasCycle = false;
    //DFS后续遍历结果翻转结果
    // "左右根-->根右左"  正好符合前后依赖关系
    List<Integer> postorder = new LinkedList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //建图的邻接表
        List<Integer>[] graph = BuildGraph(numCourses, prerequisites);
        //初始化访问记录
        isVisited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        //遍历图的每一个节点,因为并非所有节点都相邻
        for (int i = 0; i < numCourses; i++) {
            DFStraverse(graph, i);
        }
        if (hasCycle) {
            return new int[]{};
        }

        int[] ans = new int[postorder.size()];
        /**
         * 反转后序遍历  "左右根"-->"根左右"
         */
        Collections.reverse(postorder);
        for (int i = 0; i < ans.length; i++) {
            ans[i] = postorder.get(i);
        }
        return ans;
    }

    /**
     * @param numCourses    图中节点的个数
     * @param prerequisites 先修课程表
     * @return 建立有向图  相关的邻接表
     */
    public List<Integer>[] BuildGraph(int numCourses, int[][] prerequisites) {
        //图中有numCourse个节点
        List<Integer>[] graph = new LinkedList[numCourses];

        //初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] arr : prerequisites) {
            int From = arr[1];
            int To = arr[0];

            //添加一条从From到To的有向边
            //边的方向是依赖关系,修完From才能修To
            graph[From].add(To);
        }
        return graph;
    }

    /**
     * 遍历数组
     *
     * @param graph 图的邻接表
     * @param i     第i个节点
     */
    public void DFStraverse(List<Integer>[] graph, int i) {
        if (onPath[i]) {
            hasCycle = true;//如果这个节点已经出现在了这条路上,那么说明迷路了,存在环!!!
        }

        //如果已经访问过或者存在环,那么直接返回,否则继续DFS遍历
        if (isVisited[i] || hasCycle) {
            return;
        }

        /*这里采用前序遍历*/
        //记录访问的节点
        isVisited[i] = true;
        //将这个节点加入当前访问路径
        onPath[i] = true;

        //访问这个节点的邻接点
        for (int t : graph[i]) {
            DFStraverse(graph, t);
        }

        /**
         * 后序遍历  "左右根"
         */
        postorder.add(i);

        //撤回选择,不再选择这条路
        onPath[i] = false;
    }
}
