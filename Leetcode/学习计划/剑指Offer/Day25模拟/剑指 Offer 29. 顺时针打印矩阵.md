#### [剑指 Offer 29. 顺时针打印矩阵](https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/)

难度简单404

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

**示例 1：**

```
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
```

**示例 2：**

```
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
```

**限制：**

- `0 <= matrix.length <= 100`
- `0 <= matrix[i].length <= 100`

注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/

**模拟**:

`left=top=0,right=below=length`

* 左->右
* 上->下
* 右->左
* 下->上

```java
public int[]spiralOrder(int[][]matrix){
        if(matrix.length==0){
        return new int[0];
        }
        //左右边界
        int left=0,right=matrix[0].length-1;
        //上下边界
        int top=0,below=matrix.length-1;
        int[]res=new int[(right+1)*(below+1)];
        int idx=0;
        while(true){
        for(int i=left;i<=right;i++){//1.左-->右
        res[idx++]=matrix[top][i];
        }
        if(++top>below){//层数+1,到达最后返回
        break;
        }
        for(int i=top;i<=below;i++){//2.上-->下
        res[idx++]=matrix[i][right];
        }
        if(left>--right){//层数-1,到达最后返回
        break;
        }
        for(int i=right;i>=left;i--){//3.右-->左
        res[idx++]=matrix[below][i];
        }
        if(top>--below){//层数-1
        break;
        }
        for(int i=below;i>=top;i--){//4.下-->上
        res[idx++]=matrix[i][left];
        }
        if(++left>right){
        break;
        }
        }
        return res;
        }
```