package 力扣.知识点.回溯.全排列;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new LinkedList<>();

    /**
     * @param nums
     * @return 全排列结果:使用回溯算法,在递归之前做出选择,,在递归之后撤销选择,,
     */
    public List<List<Integer>> permute(int[] nums) {

        //记录路径---做出的选择
        LinkedList<Integer> path = new LinkedList<>();
        //开始回溯
        backPath(path, nums);
        return res;
    }

    /**
     * @param path 经过的路径---做出的选择
     * @param nums 选择列表:除去path的nums中的元素
     *             回溯结束条件:当选择列表的元素为空,即nums的元素全部都出现在path中
     */
    public void backPath(LinkedList<Integer> path, int[] nums) {
        //当nums中的元素全部被选择,更新答案,并结束,返回到上一级
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        //回溯核心
        for (int i = 0; i < nums.length; i++) {
            //更新选择列表,如果nums[]中的元素已经做出选择,那么就跳过这个选择
            if (path.contains(nums[i])) {
                continue;
            }

            //做出选择
            path.add(nums[i]);
            //开始回溯
            backPath(path, nums);
            //撤销选择
            path.removeLast();
        }
    }
}

