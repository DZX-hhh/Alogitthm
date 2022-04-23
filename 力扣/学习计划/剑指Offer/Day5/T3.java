package 力扣.学习计划.剑指Offer.Day5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T3 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) return c;
        }
        return ' ';
    }

    //对于哈希表里面已经存在的key,put()一个false,说明这个字符不只出现一次
    public char firstUniqChar2(String s) {
        Map<Character, Boolean> dic = new HashMap<>();

        char[] array = s.toCharArray();

        for (char c : array) {
            dic.put(c, !dic.containsKey(c));
        }

        for (char c : array) {
            if (dic.get(c)) return c;
        }

        return ' ';
    }

    public char firstUniqChar3(String s) {
        //计数数组
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        for (char c : s.toCharArray()) if (count[c - 'a'] == 1) return c;
        return ' ';
    }
}

class T2 {
    //暴力,直接排序
    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }

    //这里发现一个规律,反转之后存在两段有序的部分,比较这两个部分的第一个元素大小即可
    public int minArray2(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] > numbers[i]) {
                min = Math.min(numbers[i], min);
                break;
            }
        }
        return min;
    }

    //二分法
    //[mid]>target  :说明可能在mid后面会存在更小的,所以left=mid+1
    //[mid]<target :更新min,但是mid前面可能还有更小的,所以right=mid-1
    public int minArray3(int[] numbers) {
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
}

class T1 {
    //暴力
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }

    /*二分法:每行都二分查*/
    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = search(row, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /*Z字查找*/
    //从右上角开始看: 左边的都比它小,,下边的都比它大,,符合BST的逻辑
    public boolean searchMatrix3(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                //当前位置已经大于target,因此往下走已经行不通了,所以往左走(col--)
                col--;
            } else if (matrix[row][col] < target) {
                //当前位置小于target,可以往下走,继续尝试
                row++;
            }
        }
        return false;
    }
}


