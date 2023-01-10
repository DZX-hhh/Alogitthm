#### [剑指 Offer 35. 复杂链表的复制](https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/)

难度中等504

请实现 `copyRandomList` 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 `next` 指针指向下一个节点，还有一个 `random` 指针指向链表中的任意节点或者 `null`。

**示例 1：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e1.png)

```
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
```

**示例 2：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e2.png)

```
输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
```

**示例 3：**

**![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e3.png)**

```
输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
```

**示例 4：**

```
输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。
```

**提示：**

- `-10000 <= Node.val <= 10000`
- `Node.random` 为空（null）或指向链表中的节点。
- 节点数目不超过 1000 。

**注意：**本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-pointer/

#### [138. 复制带随机指针的链表](https://leetcode-cn.com/problems/copy-list-with-random-pointer/)

难度中等865收藏分享切换为英文接收动态反馈

给你一个长度为 `n` 的链表，每个节点包含一个额外增加的随机指针 `random` ，该指针可以指向链表中的任何节点或空节点。

构造这个链表的 **[深拷贝](https://baike.baidu.com/item/深拷贝/22785317?fr=aladdin)**。 深拷贝应该正好由 `n` 个 **全新**
节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 `next` 指针和 `random` 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。**
复制链表中的指针都不应指向原链表中的节点** 。

例如，如果原链表中有 `X` 和 `Y` 两个节点，其中 `X.random --> Y` 。那么在复制链表中对应的两个节点 `x` 和 `y` ，同样有 `x.random --> y` 。

返回复制链表的头节点。

用一个由 `n` 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 `[val, random_index]` 表示：

- `val`：一个表示 `Node.val` 的整数。
- `random_index`：随机指针指向的节点索引（范围从 `0` 到 `n-1`）；如果不指向任何节点，则为 `null` 。

你的代码 **只** 接受原链表的头节点 `head` 作为传入参数。

**示例 1：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e1.png)

```
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
```

**示例 2：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e2.png)

```
输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
```

**示例 3：**

**![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e3.png)**

```
输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
```

**提示：**

- `0 <= n <= 1000`
- `-104 <= Node.val <= 104`
- `Node.random` 为 `null` 或指向链表中的节点。

> 题意:其实就是不让返回原来的节点,都是`新的节点`,只是结构和节点的值一样
>
> ​ 但是`地址`却不一样



**哈希表**

```java
 //哈希表,k-源节点 v-新节点  "映射"
public Node copyRandomList2(Node head){
        if(head==null)return null;
        //源节点-新节点
        HashMap<Node, Node> map=new HashMap<>();
        Node temp=head;
        while(temp!=null){
        //创建新节点
        Node newNode=new Node(temp.val);
        map.put(temp,newNode);
        temp=temp.next;
        }
        temp=head;
        //设置新节点的next和random
        while(temp!=null){
        Node newNode=map.get(temp);
        //newNode是源节点对应的新节点,newNode.next是源节点的下一个
        //map.get(temp.next)是源节点的下一个对应的新节点
        if(temp.next!=null){
        newNode.next=map.get(temp.next);
        }
        //newNode的random为源节点的random对应的
        if(temp.random!=null){
        newNode.random=map.get(temp.random);
        }
        temp=temp.next;
        }

        //返回全新的头节点
        return map.get(head);
        }
```

**迭代**

```java
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node temp = head;
        //第一步,在每个源节点后面创建一个新节点
        //1->1'->2->2'->3->3'
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }
        temp = head;
        //第二步,设置新节点的随机节点,新节点的随机指针在源节点的随即指针后面一位
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        temp = head;
        Node res = new Node(-1);
        Node curr = res;
        //第三步,将两个链表分离
        while (temp != null) {
            curr.next = temp.next;//新链表
            curr = curr.next;
            temp.next = curr.next;//旧链表
            temp = temp.next;
        }
        return res.next;
    }
}

```

