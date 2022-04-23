#### [剑指 Offer 32 - I. 从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/)

难度中等189

从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

例如:
给定二叉树: `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回：

```
[3,9,20,15,7]
```

**提示：**

1. `节点总数 <= 1000`

**层序遍历**

```java
public class T1 {
    //层序遍历,,使用队列,,一般也称为BFS
    public int[] levelOrder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return new int[]{};
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                res.add(poll.val);
                //如果左孩子为空,那么访问之后就不需要再将其加入队列了
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
        int[] ansArr = new int[res.size()];
        for (int i = 0; i < ansArr.length; i++) {
            ansArr[i] = res.get(i);
        }
        return ansArr;
    }
}
```

