package 力扣.学习计划.剑指Offer.Day17排序;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Solution40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        //直接排序
        int[] res = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; ++i) {
            res[i] = arr[i];
        }
        return res;
    }

    /*
        优先队列
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : arr) {
            priorityQueue.offer(num);
        }
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }

    /*
        快速排序
     */
    public int[] getLeastNumbers3(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pilot = partition(arr, low, high);
        quickSort(arr, low, pilot - 1);
        quickSort(arr, pilot + 1, high);
    }

    /*
        找到pilot左边的比他小,右边的比它大
     */
    private int partition(int[] arr, int low, int high) {
        Random random = new Random();
        int r = random.nextInt(high + 1 - low) + low;
        swap(arr, r, high);
        int i = low;
        for (int j = i; j < high; j++) {
            if (arr[j] < arr[high]) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
