#### [剑指 Offer 04. 二维数组中的查找](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/)

难度中等651收藏分享切换为英文接收动态反馈

在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

**示例:**

现有矩阵 matrix 如下：

```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```

给定 target = `5`，返回 `true`。

给定 target = `20`，返回 `false`。

**限制：**

```
0 <= n <= 1000
0 <= m <= 1000
```

**注意：**本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/

#### [240. 搜索二维矩阵 II](https://leetcode-cn.com/problems/search-a-2d-matrix-ii/)

难度中等990收藏分享切换为英文接收动态反馈

编写一个高效的算法来搜索 `*m* x *n*` 矩阵 `matrix` 中的一个目标值 `target` 。该矩阵具有以下特性：

- 每行的元素从左到右升序排列。
- 每列的元素从上到下升序排列。

**示例 1：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/11/25/searchgrid2.jpg)

```
输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
输出：true
```

**示例 2：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/11/25/searchgrid.jpg)

```
输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
输出：false
```

**提示：**

- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= n, m <= 300`
- `-109 <= matrix[i][j] <= 109`
- 每行的所有元素从左到右升序排列
- 每列的所有元素从上到下升序排列
- `-109 <= target <= 109`

**暴力**

```java
 //暴力
public boolean searchMatrix(int[][]matrix,int target){
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m; i++){
        for(int j=0;j<n; j++){
        if(matrix[i][j]==target)return true;
        }
        }
        return false;
        }
```

**每行二分**

```java
/*二分法:每行都二分查*/
public boolean searchMatrix2(int[][]matrix,int target){
        for(int[]row:matrix){
        int index=search(row,target);
        if(index>=0){
        return true;
        }
        }
        return false;
        }

public int search(int[]nums,int target){
        int low=0,high=nums.length-1;
        while(low<=high){
        int mid=(high-low)/2+low;
        int num=nums[mid];
        if(num==target){
        return mid;
        }else if(num>target){
        high=mid-1;
        }else{
        low=mid+1;
        }
        }
        return-1;
        }
```

**Z字查找**

```java
 /*Z字查找*/
//从右上角开始看: 左边的都比它小,,下边的都比它大,,符合BST的逻辑
public boolean searchMatrix3(int[][]matrix,int target){
        int row=0,col=matrix[0].length-1;
        while(row<matrix.length&&col>=0){
        if(matrix[row][col]==target){
        return true;
        }else if(matrix[row][col]>target){
        //当前位置已经大于target,因此往下走已经行不通了,所以往左走(col--)
        col--;
        }else if(matrix[row][col]<target){
        //当前位置小于target,可以往下走,继续尝试
        row++;
        }
        }
        return false;
        }
```

