package com.geekdigging.day002;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @Date: 2020/7/27
 * @Time: 23:27
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            // 先获取末尾数字
            int tmp = x % 10;

            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }

            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }

            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }

    public int reverse_1(int x) {
        int res = 0;
        while (x != 0) {

            if (res > 214748364 || res < -214748364) {
                return 0;
            }

            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

    

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse_1(1463847412));
    }
}
