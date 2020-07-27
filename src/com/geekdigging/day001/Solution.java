package com.geekdigging.day001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @Date: 2020/7/26
 * @Time: 23:56
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    /**
     * 暴力方案
     * @param nums
     * @param target
     * @return
     * @Desc 时间复杂度 O(n^2)
     *       空间复杂度 O(1)
     */
    public int[] twoSum_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == temp) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 两遍哈希表
     * @param nums
     * @param target
     * @return
     * @Desc 时间复杂度 O(n)
     *       空间复杂度 O(n)
     */
    public int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍哈希表
     * @param nums
     * @param target
     * @return
     * @Desc 时间复杂度 O(n)
     *       空间复杂度 O(n)
     */
    public int[] twoSum_3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 4};
        int target = 6;

        Solution solution = new Solution();
        int[] ints = solution.twoSum_1(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
