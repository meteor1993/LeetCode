package com.geekdigging.day016;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *     由于返回类型是整数，小数部分将被舍去。
 *
 */
public class Solution {
    // 数学方案 将问题转化另一个数据公式作答
    // 这个方案没点数学功底的人绝对想不到
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long)(ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    // 二分查找，这个也是我最开始想到的方案
    public int mySqrt_1(int x) {
        if (x == 0) return 0;
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                ans = mid;
                right =
            } else {

            }
        }
        return ans;
    }
}
