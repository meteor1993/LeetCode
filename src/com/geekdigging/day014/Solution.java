package com.geekdigging.day014;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @Date: 2020/8/9
 * @Time: 10:12
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        // 从末尾开始循环
        for (int i = digits.length - 1; i >= 0; i--) {
            // 先 +1
            digits[i]++;
            // 取余数， 10 的余数为 0
            digits[i] = digits[i] % 10;
            // 判断余数是否为 0 ，如果为 0 则再循环一次，产生了进位，不为 0 则可以直接返回
            if (digits[i] != 0) return digits;
        }
        // 如果在上面的循环未返回，则整体产生进位，类似于 9 ， 99 ， 999 ， 9999 这种数组
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] digits = {9, 9, 9, 9};
        System.out.println(Arrays.toString(solution.plusOne(digits)));
    }
}
