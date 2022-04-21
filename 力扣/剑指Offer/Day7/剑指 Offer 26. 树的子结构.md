#### [剑指 Offer 26. 树的子结构](https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/)

难度中等541收藏分享切换为英文接收动态反馈

输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

例如:
给定的树 A:

`   3 / \ 4  5 / \ 1  2`
给定的树 B：

`  4 / 1`
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

**示例 1：**

```
输入：A = [1,2,3], B = [3,1]
输出：false
```

**示例 2：**

```
输入：A = [3,4,5,1,2], B = [4,1]
输出：true
```

**限制：**

```
0 <= 节点个数 <= 10000
```

**`DFS`+递归模拟**

```java
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        //DFS(A,B) --当前节点B是否是A的子树,若不是,判断当前节点的孩子节点
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean dfs(TreeNode a, TreeNode b) {
        //当递归到子树的时候,,b已经到达了尽头,所以返回true,后面多出来的可能是a的
        if (b == null) return true;
        //当 a已经到达了尽头,,但是b还没到尽头,说明b并不是a的孩子节点
        if (a == null) return false;
        //如果二者都不为空,,并且当前值相等,那么就递归孩子节点
        return (a.val == b.val) && dfs(a.left, b.left) && dfs(a.right, b.right);
    }
}
```