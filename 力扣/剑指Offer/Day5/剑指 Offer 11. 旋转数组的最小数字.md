#### [剑指 Offer 11. 旋转数组的最小数字](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)

难度简单604收藏分享切换为英文接收动态反馈

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。

给你一个可能存在 **重复** 元素值的数组 `numbers` ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的**最小元素**。例如，数组 `[3,4,5,1,2]` 为 `[1,2,3,4,5]`
的一次旋转，该数组的最小值为 1。

注意，数组 `[a[0], a[1], a[2], ..., a[n-1]]` 旋转一次 的结果为数组 `[a[n-1], a[0], a[1], a[2], ..., a[n-2]]` 。

**示例 1：**

```
输入：numbers = [3,4,5,1,2]
输出：1
```

**示例 2：**

```
输入：numbers = [2,2,2,0,1]
输出：0
```

**提示：**

- `n == numbers.length`
- `1 <= n <= 5000`
- `-5000 <= numbers[i] <= 5000`
- `numbers` 原来是一个升序排序的数组，并进行了 `1` 至 `n` 次旋转

注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/

**暴力**

```java
 //暴力,直接排序
public int minArray(int[]numbers){
        Arrays.sort(numbers);
        return numbers[0];
        }
```

**规律**

```java
//这里发现一个规律,反转之后存在两段有序的部分,比较这两个部分的第一个元素大小即可
public int minArray2(int[]numbers){
        int min=numbers[0];
        for(int i=1;i<numbers.length;i++){
        if(numbers[i-1]>numbers[i]){
        min=Math.min(numbers[i],min);
        break;
        }
        }
        return min;
        }
```

**二分法**

> * `[mid] > target ` :说明可能在mid后面会存在更小的,所以`left = mid+1``
> * `[mid] < target` :更新min,但是mid前面可能还有更小的,所以`right = mid-1`

```java
//二分法
public int minArray3(int[]numbers){
        int min=numbers[0];
        int left=0,right=numbers.length-1;
        while(left<=right){
        int mid=left+(right-left)/2;
        if(numbers[mid]<min){
        min=numbers[mid];
        right=mid-1;
        }else{
        left=mid+1;
        }
        }
        return min;
        }
```
