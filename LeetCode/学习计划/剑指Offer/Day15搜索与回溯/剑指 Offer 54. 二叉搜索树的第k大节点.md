#### [剑指 Offer 54. 二叉搜索树的第k大节点](https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/)

难度简单291收藏分享切换为英文接收动态反馈

给定一棵二叉搜索树，请找出其中第 `k` 大的节点的值。

**示例 1:**

```
输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
```

**示例 2:**

```
输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4
```

**限制：**

- 1 ≤ k ≤ 二叉搜索树元素个数

**先序遍历**

```java
public class Solution54 {
    List<Integer> list = new LinkedList<>();

    public int kthLargest(TreeNode root, int k) {
        postSearch(root);
        return list.get(list.size() - k);
    }

    private void postSearch(TreeNode root) {
        if (root == null) {
            return;
        }
        postSearch(root.left);
        list.add(root.val);
        postSearch(root.right);
    }
}
```

**右->根->左**

```java
/*
        '右-->根-->左`
        此时二叉搜索树为降序
     */
    int res=0,count=0;

public int kthLargest2(TreeNode root,int k){
        postSearch2(root,k);
        return res;
        }

private void postSearch2(TreeNode root,int k){
        if(root==null){
        return;
        }
        postSearch2(root.right,k);
        if(++count==k){
        res=root.val;
        return;
        }
        postSearch2(root.left,k);
        }
        }
```