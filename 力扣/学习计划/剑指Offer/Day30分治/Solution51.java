package 力扣.学习计划.剑指Offer.Day30分治;

public class Solution51 {
    int[] temp;
    int res = 0;

    /*
        这里可以联想到归并排序
        合并两个升序数组
        当第一个有序数组的某个数字固定好
        后面合并的时候另外一个数组找到大于这个数字的下标和起始下标之间的元素个数就是逆序对的个数
     */
    public int reversePairs(int[] nums) {
        //辅助合并有序数组
        temp = new int[nums.length];
        //排序数组
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    /**
     * @param nums 归并排序nums
     * @param low  左边界
     * @param high 右边界
     */
    private void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        //归并排序,中点下标
        int mid = (low + high) / 2;
        //利用定义,排序nums[low,mid]
        mergeSort(nums, low, mid);
        //利用定义,排序nums[low,mid]
        mergeSort(nums, mid + 1, high);

        //两个子数组排好序
        //合并两个有序数组,使nums[low,high]有序
        merge(nums, low, mid, high);
    }

    /**
     * 合并nums[low,mid]和nums[mid+1,high]两个有序数组
     * 利用归并排序解答，在合并的时候，当左边的大于右边，就计算逆序数。
     * 计算公式； mid-left+1
     *
     * @param nums 数组
     * @param low  数组的左边界
     * @param mid  数组的分割线mid
     * @param high 数组的右边界
     */
    private void merge(int[] nums, int low, int mid, int high) {
        //复制辅助数组
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }
        int slow = low, fast = mid + 1;
        for (int i = low; i <= high; i++) {
            if (slow > mid) {
                nums[i] = temp[fast++];
            } else if (fast > high) {
                nums[i] = temp[slow++];
            } else if (temp[slow] > temp[fast]) {
                res += mid - slow + 1;
                nums[i] = temp[fast++];
            } else {
                nums[i] = temp[slow++];
            }
        }
    }
}
