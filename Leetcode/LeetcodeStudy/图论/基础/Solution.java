package Leetcode.LeetcodeStudy.图论.基础;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    //定义全局变量,res
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //onPath记录当前访问图的路径
        LinkedList<Integer> onPath = new LinkedList<>();
        //遍历图,找到符合要求的路径并加入res
        traverse(graph, 0, onPath);
        return res;
    }

    /**
     * 遍历访问图
     *
     * @param graph  邻接表
     * @param i      表示第i个节点
     * @param onPath 记录当前访问图的路径
     */
    public void traverse(int[][] graph, int i, LinkedList<Integer> onPath) {
        int numsOfGraph = graph.length;
        //将第i个节点加入访问路径
        onPath.addLast(i);

        //如果已经访问到了最后一个节点
        if (i == numsOfGraph - 1) {
            //将此时访问路径加入到res
            res.add(new LinkedList<>(onPath));
            onPath.removeLast();
            return;
        }

        //否则,依次递归访问第i个节点的邻接点
        for (int v : graph[i]) {
            traverse(graph, v, onPath);
        }

        //将访问路径移除节点i,说明就不走这条路了
        onPath.removeLast();
    }
}
