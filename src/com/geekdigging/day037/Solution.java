package com.geekdigging.day037;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * 两数之和 II - 输入有序数组
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * @Date: 2020/9/1
 * @Time: 19:24
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (target - numbers[i] == numbers[j]) {
                    return new int[] {i + 1, j + 1};
                }
            }
        }
        return null;
    }

    // 哈希表
    public int[] twoSum_1(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[] {map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return null;
    }

    // 二分法
    public int[] twoSum_2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[] {i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return null;
    }

    // 双指针
    public int[] twoSum_3(int[] numbers, int target) {
        int left  = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (target == sum) {
                return new int[] {left + 1, right + 1};
            } else if (sum < target){
                ++left;
            } else {
                --right;
            }
        }
        return null;
    }
}
