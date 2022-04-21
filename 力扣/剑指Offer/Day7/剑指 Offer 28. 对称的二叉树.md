#### [剑指 Offer 28. 对称的二叉树](https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/)

难度简单334

请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

`  1 / \ 2  2 / \ / \3  4 4  3`
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

```
  1  / \ 2  2  \  \  3   3
```

**示例 1：**

```
输入：root = [1,2,2,3,4,4,3]
输出：true
```

**示例 2：**

```
输入：root = [1,2,2,null,3,null,3]
输出：false
```

**限制：**

```
0 <= 节点个数 <= 1000
```

注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/

#### [101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)

难度简单1871

给你一个二叉树的根节点 `root` ， 检查它是否轴对称。

**示例 1：**

![img](https://assets.leetcode.com/uploads/2021/02/19/symtree1.jpg)

```
输入：root = [1,2,2,3,4,4,3]
输出：true
```

**示例 2：**

![img](https://assets.leetcode.com/uploads/2021/02/19/symtree2.jpg)

```
输入：root = [1,2,2,null,3,null,3]
输出：false
```

**提示：**

- 树中节点数目在范围 `[1, 1000]` 内
- `-100 <= Node.val <= 100`

**进阶：**你可以运用递归和迭代两种方法解决这个问题吗？

**递归**
> 左对右,,右对左

```java
 public boolean isSymmetric(TreeNode root){
        return dfs(root.left,root.right);
        }

public boolean dfs(TreeNode left,TreeNode right){
        if(left==null&&right==null)return true;
        else if((left==null&&right!=null)||(left!=null&&right==null))return false;
        return left.val==right.val&&dfs(left.right,right.left)&&dfs(left.left,right.right);
        }
```

**迭代**

```java
/**
 * @param root
 * @return 迭代BFS, , 队列
 */
public boolean isSymmetric2(TreeNode root){
        if(root==null||(root.left==null&&root.right==null)){
        return true;
        }
        //用队列保存节点
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        //将根节点的左右孩子放到队列中
        queue.add(root.left);
        queue.add(root.right);
        while(queue.size()>0){
        //从队列中取出两个节点，再比较这两个节点
        TreeNode left=queue.removeFirst();
        TreeNode right=queue.removeFirst();
        //如果两个节点都为空就继续循环，两者有一个为空就返回false
        if(left==null&&right==null){
        continue;
        }
        if(left==null||right==null){
        return false;
        }
        if(left.val!=right.val){
        return false;
        }
        //将左节点的左孩子， 右节点的右孩子放入队列
        queue.add(left.left);
        queue.add(right.right);
        //将左节点的右孩子，右节点的左孩子放入队列
        queue.add(left.right);
        queue.add(right.left);
        }

        return true;
        }
```
