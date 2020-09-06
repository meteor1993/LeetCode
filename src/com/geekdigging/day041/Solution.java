package com.geekdigging.day041;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * 阶乘后的零
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * @Date: 2020/9/5
 * @Time: 19:35
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    // 暴力硬算
    public int trailingZeroes(int n) {
        // 先定义第一个数字
        BigInteger bi = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            bi = bi.multiply(BigInteger.valueOf(i));
        }

        // 定义 0 出现的次数
        int count = 0;
        while (bi.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            bi = bi.divide(BigInteger.TEN);
            count++;
        }
        return count;
    }

    // 计算因子 5
    public int trailingZeroes_1(int n) {
        int count = 0;
        for (int i = 5; i <= n; i += 5) {
            int current = i;
            while (current % 5 == 0) {
                count++;
                current /= 5;
            }
        }
        return count;
    }

    // 计算因子 5 的次幂
    public int trailingZeroes_2(int n) {
        int count = 0;
        for (int i = 5; i <= n; i += 5) {
            int powerOf5 = 5;
            while (i % powerOf5 == 0) {
                count += 1;
                powerOf5 *= 5;
            }
        }
        return count;
    }

    // 更加高效的计算因子 5
    public int trailingZeroes_3(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
