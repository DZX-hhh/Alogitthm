#### B树(多路平衡查找树)

![image-20220629095255161](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629095255161.png)

```c++
#define N 5 //定义N叉树

typedef struct Node {
	int arr[N];//关键字
	struct Node* child[N + 1];//最多N+1个孩子
	int num;//节点中有几个关键字
}Node;
```

#### 如何保证查找效率

1. **保证节点的分叉数以及关键字数**

![image-20220629100520110](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629100520110.png)

- 根节点是个例外,因为可能出现只有一个元素的树

2. **保证平衡**(类似二叉树的平衡左右高度差小于1难实现),,因此让所有子树的**高度相同**



#### 具体概念

![image-20220629111808819](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629111808819.png)

1. **B树的阶**:**分叉的最大值**
2. **若根节点不是终端节点,至少有两棵子树,因为需要满足完全平衡条件**

![image-20220629131704989](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629131704989.png)

#### 核心特性

![image-20220629142109527](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629142109527.png)

#### 例题

![image-20220629132004848](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629132004848.png)

- **最小高度   h >= logm(n+1)**![image-20220629132748799](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629132748799.png)
- **最大高度  **![image-20220629133845866](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629133845866.png)



