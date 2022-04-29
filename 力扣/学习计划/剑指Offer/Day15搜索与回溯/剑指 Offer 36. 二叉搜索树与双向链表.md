#### [剑指 Offer 36. 二叉搜索树与双向链表](https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/)

难度中等486收藏分享切换为英文接收动态反馈

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。

为了让您更好地理解问题，以下面的二叉搜索树为例：

![img](https://assets.leetcode.com/uploads/2018/10/12/bstdlloriginalbst.png)

我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。

下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。

![img](https://assets.leetcode.com/uploads/2018/10/12/bstdllreturndll.png)

特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。

**示例 1：**

```
输入：root = [4,2,5,1,3] 


输出：[1,2,3,4,5]

解释：下图显示了转化后的二叉搜索树，实线表示后继关系，虚线表示前驱关系。
```

**示例 2：**

```
输入：root = [2,1,3]
输出：[1,2,3]
```

**示例 3：**

```
输入：root = []
输出：[]
解释：输入是空树，所以输出也是空链表。
```

**示例 4：**

```
输入：root = [1]
输出：[1]
```

**提示：**

- `-1000 <= Node.val <= 1000`
- `Node.left.val < Node.val < Node.right.val`
- `Node.val` 的所有值都是独一无二的
- `0 <= Number of Nodes <= 2000`

**注意：**本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

**注意：**此题对比原题有改动。

**题意**:将二叉搜索树-->排序的双向循环链表

<img src="https://pic.leetcode-cn.com/1599401091-PKIjds-Picture1.png" alt="Picture1.png" style="zoom:50%;" />

* 排序链表： 节点应从小到大排序，因此应使用 中序遍历 “从小到大”访问树的节点。
* 双向链表： 在构建相邻节点的引用关系时，设前驱节点` pre` 和当前节点 `cur `，不仅应构建 `pre.right = cur` ，也应构建 `cur.left = pre` 。
* 循环链表： 设链表头节点 `head` 和尾节点 `tail` ，则应构建` head.left = tail `和` tail.right = head `。

```java
public class Solution36 {

    Node head, pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        //1.构造有序的双向链表
        dfs(root);
        //2.构造循环链表
        pre.right = head;
        head.left = pre;
        return head;
    }

    /*
        二叉搜索树-->排序的双向循环链表
            1.排序:中序遍历
            2.双向:pre指针(更小的元素)和curr指针(更大的元素)
                -->pre.right=curr;curr.left=pre;
            3.循环:head指针(最小的元素)和tail指针(最大的元素)
                -->head.left=tail;tail.right=head;
     */
    private void dfs(Node curr) {
        if (curr == null) {//递归到最后节点退出
            return;
        }
        dfs(curr.left);
        if (pre == null) {//如果pre为空,那就说明当前节点的左节点为空,访问的是头节点,设置头节点
            head = curr;
        } else {//如果pre不为空,可以pre.right=curr,,而上面pre为空,无法设置pre的指针
            pre.right = curr;
        }
        curr.left = pre;//这里与上面的pre是否为空无关,,中序遍历curr.left=pre;
        pre = curr;//让当前节点开始往后走,,所以需要保存curr,让curr成为后面的前驱节点
        dfs(curr.right);
    }
}
```