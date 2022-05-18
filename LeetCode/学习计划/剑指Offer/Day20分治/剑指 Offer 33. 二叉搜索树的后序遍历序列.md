#### [剑指 Offer 33. 二叉搜索树的后序遍历序列](https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/)

难度中等504

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 `true`，否则返回 `false`。假设输入的数组的任意两个数字都互不相同。

参考以下这颗二叉搜索树：

```
     5
    / \
   2   6
  / \
 1   3
```

**示例 1：**

```
输入: [1,6,3,2,5]
输出: false
```

**示例 2：**

```
输入: [1,3,2,6,5]
输出: true
```

**提示：**

1. `数组长度 <= 1000`

> 递归
> 找到第一个比最后元素大的下标`m`,,也就是右子树开始下标
> 继续遍历
> `[start,m-1]`是否全部都小于最后元素
> `[m,end-1]`是否全大于最后元素,如果遍历到最后,说明`true`
> 递归左右子树

```java
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
```