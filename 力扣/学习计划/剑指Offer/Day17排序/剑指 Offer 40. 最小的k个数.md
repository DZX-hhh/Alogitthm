#### [剑指 Offer 40. 最小的k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)

难度简单426收藏分享切换为英文接收动态反馈

输入整数数组 `arr` ，找出其中最小的 `k` 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

**示例 1：**

```
输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
```

**示例 2：**

```
输入：arr = [0,1,2,1], k = 1
输出：[0]
```

**限制：**

- `0 <= k <= arr.length <= 10000`
- `0 <= arr[i] <= 10000`

**`直接排序`**

```java
public int[]getLeastNumbers(int[]arr,int k){
        //直接排序
        int[]res=new int[k];
        Arrays.sort(arr);
        for(int i=0;i<k; ++i){
        res[i]=arr[i];
        }
        return res;
        }
```

**`优先队列`**

```java
/*
    优先队列
 */
public int[]getLeastNumbers2(int[]arr,int k){
        int[]res=new int[k];
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        for(int num:arr){
        priorityQueue.offer(num);
        }
        for(int i=0;i<k; i++){
        res[i]=priorityQueue.poll();
        }
        return res;
        }
```

**`快速排序`**

```java
  /*
        快速排序
     */
public int[]getLeastNumbers3(int[]arr,int k){
        quickSort(arr,0,arr.length-1);
        return Arrays.copyOf(arr,k);
        }

private void quickSort(int[]arr,int low,int high){
        if(low>=high){
        return;
        }
        int pilot=partition(arr,low,high);
        quickSort(arr,low,pilot-1);
        quickSort(arr,pilot+1,high);
        }

    /*
        找到pilot左边的比他小,右边的比它大
     */
private int partition(int[]arr,int low,int high){
        Random random=new Random();
        int r=random.nextInt(high+1-low)+low;
        swap(arr,r,high);
        int i=low;
        for(int j=i;j<high; j++){
        if(arr[j]<arr[high]){
        swap(arr,i,j);
        i++;
        }
        }
        swap(arr,i,high);
        return i;
        }

private void swap(int[]arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
        }
        }
```