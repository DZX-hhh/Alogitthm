#### [剑指 Offer 32 - II. 从上到下打印二叉树 II](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)

难度简单216

从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

例如:
给定二叉树: `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回其层次遍历结果：

```
[
  [3],
  [9,20],
  [15,7]
]
```

**提示：**

1. `节点总数 <= 1000`

注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/

**层序遍历**

> 定义一个循环弹栈k次`(k = queue.size )`    也就是将某一层的元素全部加入list

```java
class T2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> integerList = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        integerList.add(root.val);
        res.add(integerList);
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                    list.add(poll.left.val);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    list.add(poll.right.val);
                }
            }
            if (!list.isEmpty()) res.add(list);
        }
        return res;
    }
}
```

