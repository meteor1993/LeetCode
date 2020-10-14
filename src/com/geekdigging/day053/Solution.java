package com.geekdigging.day053;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2020/10/14
 * @Time: 23:52
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;
        // 外层循环 a
        for (int a = 0; a < n; ++a) {
            // 保证和上一次循环的元素不相等
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            int b = a + 1, c = n - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int c0 = c - 1;
                    // 移动到下一个不相等的元素
                    while (b < c0 && nums[c0] == nums[c]) {
                        --c0;
                    }
                    c = c0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = b + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < b && nums[j0] == nums[b]) {
                        ++j0;
                    }
                    b = j0;
                }
            }
        }
        return best;
    }
}
