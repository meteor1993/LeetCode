package com.geekdigging.day015;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * 二进制求和
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * @Date: 2020/8/10
 * @Time: 10:00
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    // 偷鸡方案
    public String addBinary(String a, String b) {
        return (new BigInteger(a, 2).add(new BigInteger(b, 2))).toString(2);
    }

    // 定义二进制转十进制
    private BigInteger binaryToDecimal(String binarySource) {
        return new BigInteger(binarySource, 2);
    }

    // 定义十进制转二进制
    private String decimalToBinary(BigInteger decimalSource) {
        return decimalSource.toString(2);
    }

    // 二进制加法
    public String addBinary_1(String a, String b) {
        StringBuilder sb = new StringBuilder();
        // 定义进位
        int pre = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = pre;
            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';
            // 当前位添加至 sb
            sb.append(sum % 2);
            // 计算进位
            pre = sum / 2;
        }
        // 进位如果为 1 则添加到 sb 上
        if (pre == 1) sb.append('1');
        // 反转字符串输出
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "1010", b = "1011";
        System.out.println(solution.addBinary_1(a, b));
    }
}
