package com.geekdigging.day052;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @Date: 2020/10/12
 * @Time: 20:55
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 最外层循环，迭代 a
        for (int a = 0; a < n; ++a) {
            // 由于元素不能重复，遇到相同的直接下次循环
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int c = n - 1;
            int target = -nums[a];
            // 迭代 b
            for (int b = a + 1; b < n; ++b) {
                // 一样先判断是否和上次迭代的元素是否相同
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                // b 的位置在 c 的左侧
                while (b < c && nums[b] + nums[c] > target) {
                    --c;
                }
                // 如果出现了指针重合，就可以退出循环了，说明没找到对应的 c
                if (b == c) {
                    break;
                }
                // 如果出现了 b 和 c 加起来等于 -a ，说明我们找到的最后的结果
                if (nums[b] + nums[c] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[a]);
                    list.add(nums[b]);
                    list.add(nums[c]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
