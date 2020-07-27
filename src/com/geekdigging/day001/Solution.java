package com.geekdigging.day001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
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
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
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
        int[] ints = solution.twoSum_2(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
