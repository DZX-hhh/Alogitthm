#### [剑指 Offer 55 - II. 平衡二叉树](https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/)

难度简单273收藏分享切换为英文接收动态反馈

输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

**示例 1:**

给定二叉树 `[3,9,20,null,null,15,7]`

```
    3
   / \
  9  20
    /  \
   15   7
```

返回 `true` 。

**示例 2:**

给定二叉树 `[1,2,2,3,3,null,null,4,4]`

```
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
```

返回 `false` 。

**限制：**

- `0 <= 树的结点个数 <= 10000`

注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/

**递归**`先序遍历`

```java
public class Solution55_2 {
    /*
        递归1.0,有很多冗余运算
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }
```

**剪枝**`后序遍历`

```java
  /*
        递归2.0,后序遍历+剪枝
     */
public boolean isBalanced2(TreeNode root){
        return dfs2(root)!=-1;
        }

/**
 * @return 如果为-1:说明不是平衡二叉树
 * 如果不为-1,就是数的高度
 */
private int dfs2(TreeNode root){
        if(root==null){
        return 0;
        }
        int leftHeight=dfs2(root.left);
        int rightHeight=dfs2(root.right);
        if(leftHeight==-1||rightHeight==-1){
        //左右子树存在不平衡子树,直接返回-1
        return-1;
        }
        return Math.abs(leftHeight-rightHeight)<=1?Math.max(leftHeight,rightHeight)+1:-1;
        }
        }
```

