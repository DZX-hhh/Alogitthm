#### [剑指 Offer 34. 二叉树中和为某一值的路径](https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/)

难度中等329收藏分享切换为英文接收动态反馈

给你二叉树的根节点 `root` 和一个整数目标和 `targetSum` ，找出所有 **从根节点到叶子节点** 路径总和等于给定目标和的路径。

**叶子节点** 是指没有子节点的节点。

**示例 1：**

![img](https://assets.leetcode.com/uploads/2021/01/18/pathsumii1.jpg)

```
输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]
```

**示例 2：**

![img](https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg)

```
输入：root = [1,2,3], targetSum = 5
输出：[]
```

**示例 3：**

```
输入：root = [1,2], targetSum = 0
输出：[]
```

**提示：**

- 树中节点总数在范围 `[0, 5000]` 内
- `-1000 <= Node.val <= 1000`
- `-1000 <= targetSum <= 1000`

注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/

```java
public class Solution34 {
    /*
        DFS+回溯:搜索路径和为target的叶子节点的列表
     */
    LinkedList<Integer> onPath = new LinkedList<>();
    LinkedList<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        //1.1做出选择
        onPath.add(root.val);
        target -= root.val;
        //1.2判断是或否要继续选择,也就是到达叶子节点是否和恰好为target
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(onPath));
            onPath.removeLast();//做出选择并撤销选择
            return;
        }
        //2.递归DFS
        dfs(root.left, target);
        dfs(root.right, target);
        //3.撤销选择
        onPath.removeLast();
    }
}
```