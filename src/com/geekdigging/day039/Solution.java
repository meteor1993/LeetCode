package com.geekdigging.day039;

import java.util.*;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        if (nums.length == 1) return nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                // 如果当前大于一半直接返回
                if (map.get(nums[i]) > nums.length / 2) {
                    return nums[i];
                }
            } else {
                map.put(nums[i], 1);
            }
        }

        return -1;
    }

    public int majorityElement_1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement_2(int[] nums) {
        int count = nums.length / 2;
        Random rand = new Random();
        while (true) {
            int index = rand.nextInt(nums.length);
            if (countOccurences(nums, nums[index]) > count) {
                return nums[index];
            }
        }

    }

    // 计算 num 出现的次数
    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[] {1}));
    }
}
