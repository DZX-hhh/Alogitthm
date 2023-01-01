### B树的插入

![image-20220629144017803](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629144017803.png)

![image-20220629144059983](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629144059983.png)

###### 插入位置:最底层`终端节点`,用查找确认位置

- 因为失败节点需要保持在同一层

  ![image-20220629144920926](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629144920926.png)

#### 核心要求

![image-20220629145754185](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629145754185.png)



### B树的删除

##### ==**删除关键字在终端节点**==![image-20220629145958067](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629145958067.png)

​		如果出现了删除节点`38`之后,,一个节点的关键字的个数小于**⌈m/2⌉ - 1**,那么需要**借兄弟**

![image-20220629153622171](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629153622171.png)

###### 	**1. 借右兄弟(后继顶上)**![image-20220629153758954](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629153758954.png)

###### **2. 借左兄弟(前驱后移)**

![image-20220629154039297](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629154039297.png)

###### **3. 兄弟不够借**

![image-20220629154415484](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629154415484.png)

> 如果兄弟不够借:合并这两个节点以及中间的关键字==合并==

![image-20220629160554818](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629160554818.png)

![image-20220629160738902](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629160738902.png)





##### ==**删除关键字在非终端节点**==

> **非终端节点的删除可以转化成终端节点的删除**

![image-20220629152314755](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629152314755.png)



![image-20220629152507430](https://cdn.jsdelivr.net/gh/DZX-hhh/Pictures/images/image-20220629152507430.png)



#### 本质:保证B树的特性
