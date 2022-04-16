#### [LCP 28. 采购方案](https://leetcode-cn.com/problems/4xy4Wx/)

难度简单46

小力将 N 个零件的报价存于数组 `nums`。小力预算为 `target`，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。

注意：答案需要以 `1e9 + 7 (1000000007)` 为底取模，如：计算初始结果为：`1000000008`，请返回 `1`

**示例 1：**

> 输入：`nums = [2,5,3,5], target = 6`
>
> 输出：`1`
>
> 解释：预算内仅能购买 nums[0] 与 nums[2]。

**示例 2：**

> 输入：`nums = [2,2,1,9], target = 10`
>
> 输出：`4`
>
> 解释：符合预算的采购方案如下：
> nums[0] + nums[1] = 4
> nums[0] + nums[2] = 3
> nums[1] + nums[2] = 3
> nums[2] + nums[3] = 10

**提示：**

- `2 <= nums.length <= 10^5`
- `1 <= nums[i], target <= 10^5`

**排序+双指针**

- 注意取模(每一次循环都结束都取模,最终return取模)

```java
public class LCP28 {
    /*
        排序+双指针
     */
    public int purchasePlans(int[] nums, int target) {
        int mod = 1000000007;
        int left = 0;
        int right = nums.length - 1;
        int num = 0;
        Arrays.sort(nums);//排序保证更好确定预算的范围
        while (left < right) {
            if (nums[left] + nums[right] > target) {//超出预算,需要将贵的(right--)便宜一点
                right--;
            } else {
                //如果成功了,说明这个范围最便宜的+最贵的不超预算,那么最便宜的+任意一个不超过最贵的都可以
                num += right - left;
                left++;
            }
            num %= mod;
        }
        return num % mod;
    }
}
```