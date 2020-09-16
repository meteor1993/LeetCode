package com.geekdigging.day048;

/**
 * Created with IntelliJ IDEA.
 *
 * 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @Date: 2020/9/16
 * @Time: 22:36
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        // 先把字符串转成数组
        char[] charArray = s.toCharArray();
        // 定义初始位置
        int left = 0;
        // 定义字符串长度
        int length = 1;
        // 获取所有子串
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > length && valid(charArray, i, j)) {
                    left = i;
                    length = j - i + 1;
                }
            }
        }
        return s.substring(left, left + length);
    }

    // 判断是否回文串
    private boolean valid(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 中心扩散
    public String longestPalindrome_1(String s) {
        if (s == null || s.length() == 0) return "";

        int length = s.length();
        // 定义左右指针
        int left = 0, right = 0;
        // 定义长度
        int len = 1;
        // 定义最大开始位置和最长子串长度
        int maxStart = 0, maxLen = 0;
        for (int i = 0; i < length; i++) {
            left = i - 1;
            right = i + 1;
            // 计算左边
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            // 计算右边
            while (right < length && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            // 两边一起扩散
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                len += 2;
                left--;
                right++;
            }
            // 如果当前长度大于最大长度
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            // 下次循环前重置 len
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + 1 + maxLen);
    }

    // 动态规划
    public String longestPalindrome_2(String s) {
        if (s == null || s.length() == 0) return s;
        int length = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        // 定义一个布尔矩阵
        boolean[][] dp = new boolean[length][length];
        for (int r = 1; r < length; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(r) == s.charAt(l) && (r - l <= 2 || dp[l + 1][r - 1] == true)) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
