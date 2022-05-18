package LeetCode.学习计划.剑指Offer.Day20分治;

public class Solution105 {
    public boolean verifyPostorder(int[] postorder) {
        return postorder(postorder, 0, postorder.length - 1);
    }

    private boolean postorder(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int t = start;
        while (postorder[t] < postorder[end]) {//这里遍历数组,找到第一个比根节点大的 下标,,也就是右子树的开始下标
            t++;
        }
        int m = t;//右子树的开始下标
        while (postorder[t] > postorder[end]) {
            t++;
        }
        //如果遍历到了t==end
        // 最后说明当前树根节点满足二叉搜索树要求
        // 任然需要左右子树也满足二叉搜索树,,递归
        return t == end &&//当前树
                postorder(postorder, start, m - 1)//左子树
                && postorder(postorder, m, end - 1);//右子树
    }
}
