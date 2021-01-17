package com.geekdigging.day056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * 18. 四数之和
 *
 * @Date: 2021/1/17
 * @Time: 17:10
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        // 先对数组做排序
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            // 特殊情况判断
            // 最小数字不可重复
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 如果和大于 target ，那么接下来所有的结果肯定都大于 target ，直接 break
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            // 最大的结果也小于 target 时，直接最小数进入下一次循环
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) continue;
            for (int j = i + 1; j < length - 2; j++) {
                // 特殊情况判断，和最小的数字判断规则相同
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) continue;
                // left 和 right 分别代表第 3 、4 个数
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    // 当结果和 target 相同时
                    if (sum == target) {
                        // 结果存入 result 中
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 去重第三个数
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        left++;
                        // 去重第四个数
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
