package com.geekdigging.day042;

/**
 * Created with IntelliJ IDEA.
 *
 * 旋转数组
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * @Date: 2020/9/8
 * @Time: 22:38
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    public void rotate_1(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    public void rotate_2(int[] nums, int k) {
        // 先计算 k ，这个 k 为当前需要移动的位置，防止 k 超出数组长度
        k = k % nums.length;
        // 初始化移动的次数
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            // 初始化当前位置
            int current = start;
            // 初始化要移动的数
            int prev = nums[start];
            do {
                // 计算目标要移动的位置
                int next = (current + k) % nums.length;
                // 定义中间变量
                int tmp = nums[next];
                // 将要移动的数字进行赋值
                nums[next] = prev;
                // 这时，接着移动刚才被挤掉位置的数
                prev = tmp;
                // 变化当前的位置为刚才移动的位置
                current = next;
                // 将操作次数 +1
                count++;
            } while (start != current);
        }
    }

    public void rotate_3(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
