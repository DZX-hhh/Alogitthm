

### B+树

#### 概念

![image-20220629165023406](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629165023406.png)

![image-20220629163620214](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629163620214.png)

#### 查找方法

1. 从头节点开始**往下查找**

   - **B+树**:无论查找成功与否,,最终一定要走到叶子节点(这一点和**分块查找**类似):::为了更多的存储关键字,减少磁盘访问次数

   - **B树**:如果在某个节点查找到目标关键字,那么就查找成功;查找失败则继续

2. 从叶子节点往右查找(**顺序查找**)

#### 和B树的区别

1. 关键字和子树的关系

   ![image-20220629171059982](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629171059982.png)

   ![image-20220629171204627](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629171204627.png)

2. 关键字的范围

![image-20220629170447347](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629170447347.png)

![image-20220629170546355](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629170546355.png)

3. 关键字出现的次数

![image-20220629170615673](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629170615673.png)

![image-20220629170651857](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629170651857.png)

4. 非叶节点以及关键字的意义

![image-20220629171839441](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629171839441.png)

![image-20220629171948417](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629171948417.png)

> **由此可以解释为什么B树查找到关键字即结束而B+树需要到最后的叶子节点才能结束**

![image-20220629173034338](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629173034338.png)

##### 读入磁盘的速度

![image-20220629172722841](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629172722841.png)

典型应用:关系型数据库`MySQL`的索引功能:**B+树**