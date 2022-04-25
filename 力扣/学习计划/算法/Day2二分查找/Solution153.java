package 力扣.学习计划.算法.Day2二分查找;

public class Solution153 {
    //二分法
    //左边界为基准
    //[mid]>target  :说明可能在mid后面会存在更小的,所以left=mid+1
    //[mid]<target :更新min,但是mid前面可能还有更小的,所以right=mid-1
    public int findMin(int[] numbers) {
        int min = numbers[0];
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < min) {
                min = numbers[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }

    //右边界为基准
    public int find(int[] numbers) {
        int min = numbers[0];
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                min = Math.min(min, numbers[mid]);
                right = mid - 1;
            }
        }
        return numbers[left];
    }
}
