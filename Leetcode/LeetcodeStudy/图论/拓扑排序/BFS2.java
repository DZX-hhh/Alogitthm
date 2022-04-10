package Leetcode.LeetcodeStudy.图论.拓扑排序;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS2 {
    /**
     * 借助indegree[]记录入度数组,和环检测算法相同
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //建图的邻接表
        List<Integer>[] graph = BuildGraph(numCourses, prerequisites);
        //返回队列遍历节点的顺序结果
        return BFStraverse(graph, numCourses, prerequisites);
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
     * @param graph
     * @param numCourses
     * @param prerequisites
     * @return 当队列中所有元素不存在入度为0的元素, 返回记录节点的遍历顺序res[],因为遍历顺序也是入度为0的课程,没有先修课程符合规律
     */
    public int[] BFStraverse(List<Integer>[] graph, int numCourses, int[][] prerequisites) {

        //借助indegree数组记录每个节点的入度
        int[] indegree = new int[numCourses];
        //初始化入度数组
        for (int[] arr : prerequisites) {
            int From = arr[1];
            int To = arr[0];
            //节点to的入度+1,也就是to的先修课程数量+1
            indegree[To]++;
        }

        //根据入度初始化队列中的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                //如果节点i没有入度,即没有依赖的先修课程
                //可以作为拓扑排序的起点,加入队列
                queue.offer(i);
            }
        }

        //记录遍历的节点数目
        int count = 0;
        int[] res = new int[numCourses];
        //开始执行BFS循环,当入度为0的数目不存在之后结束
        while (!queue.isEmpty()) {
            //弹出节点i,让i指向的课程入度-1
            int i = queue.poll();
            res[count] = i;//第count个访问的节点是i,记录
            count++;

            //graph[i]表示邻接表第i个节点指向的节点
            for (int next : graph[i]) {
                //入度-1
                indegree[next]--;
                //如果入度变为0,说明next依赖的前置节点都已经遍历,先修课程都已经学完
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        //存在环,那么就不存在拓扑排序
        if (count != numCourses) {
            return new int[]{};
        }
        return res;
    }
}
