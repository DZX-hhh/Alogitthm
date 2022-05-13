#### [剑指 Offer 37. 序列化二叉树](https://leetcode.cn/problems/xu-lie-hua-er-cha-shu-lcof/)

难度困难303收藏分享切换为英文接收动态反馈

请实现两个函数，分别用来序列化和反序列化二叉树。

你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

**提示：**输入输出格式与 LeetCode
目前使用的方式一致，详情请参阅 [LeetCode 序列化二叉树的格式](https://support.leetcode-cn.com/hc/kb/article/1194353/)。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

**示例：**

![img](https://assets.leetcode.com/uploads/2020/09/15/serdeser.jpg)

```
输入：root = [1,2,3,null,null,4,5]
输出：[1,2,3,null,null,4,5]
```

注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/

#### 思路

序列化与反序列化

- 序列化也就是将二叉树前后序遍历,记录成字符串的形式
- 反序列化也就是将字符串记录成链表,并通过先后序递归构造二叉树的过程

#### 层序遍历

```java
public class Codec {

    String SEP = ",";
    String NULL = "#";

    /**
     * 层序遍历,使用队列解决
     * 步骤:父节点出队,同时左右孩子节点入队
     *
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            return "";
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            //如果节点为空,则进入下一次循环
            if (tempNode == null) {
                sb.append(NULL).append(SEP);
                continue;
            } else {//如果不为空,则将其孩子节点入队做父节点
                sb.append(tempNode.val).append(SEP);

                //子节点递归进队列
                queue.offer(tempNode.left);
                queue.offer(tempNode.right);
            }

        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        //储存节点的数组
        String[] res = data.split(SEP);
        //创建根节点
        TreeNode root = new TreeNode(Integer.parseInt(res[0]));
        //队列记录  父节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < res.length && !queue.isEmpty(); ) {
            //弹出父节点
            TreeNode parent = queue.poll();
            //判断左右子节点是否为空
            //获取孩子节点的 val值
            String left = res[i++];
            //如果不为空,就创建左孩子节点,并且将这个节点作为父节点入队
            if (!left.equals(NULL)) {
                parent.left = new TreeNode(Integer.parseInt(left));
                queue.offer(parent.left);
            } else {
                parent.left = null;
            }
            //获取孩子节点的val值
            String right = res[i++];
            //如果不为空,就创建右孩子节点,并且将这个节点作为父节点入队
            if (!right.equals(NULL)) {
                parent.right = new TreeNode(Integer.parseInt(right));
                queue.offer(parent.right);
            } else {
                parent.right = null;
            }
        }
        return root;
    }
}
```

#### 先序遍历

```java
public class Codec {

    String SEP = ",";
    String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //先序遍历
        StringBuffer sb = new StringBuffer();
        seri(root, sb);
        return sb.toString();
    }

    public void seri(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        /*
         * 前序位置
         */
        sb.append(root.val).append(SEP);
        seri(root.left, sb);
        seri(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return desri(nodes);
    }

    //通过列表构造二叉树
    public TreeNode desri(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        //先序遍历,列表最左侧就是根节点
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = desri(nodes);
        root.right = desri(nodes);
        return root;
    }
}
```

#### 后序遍历

```java
public class Codec {
    String SEP = ",";
    String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        ser(root, sb);
        return sb.toString();
    }

    public void ser(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        ser(root.left, sb);
        ser(root.right, sb);
        sb.append(root.val).append(SEP);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> res = new LinkedList<>();
        for (String s : data.split(SEP)) {
            res.addLast(s);
        }
        return desr(res);
    }

    public TreeNode desr(LinkedList<String> res) {
        if (res.isEmpty()) {
            return null;
        }
        //由于后序遍历,从后往前取出元素
        String s = res.removeLast();
        if (s.equals(NULL)) {
            return null;
        }
        //先构造右子树,再构造左子树
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.right = desr(res);
        root.left = desr(res);
        return root;
    }
}
```