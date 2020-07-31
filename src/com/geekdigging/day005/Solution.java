package com.geekdigging.day005;

/**
 * Created with IntelliJ IDEA.
 *
 * 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 *
 * @Date: 2020/7/30
 * @Time: 23:58
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {

    // 方案一：暴力横向查找
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            prefix = compareTwoStrs(prefix, strs[i]);
            if (prefix.length() == 0) break;
        }

        return prefix;
    }

    // 获取两个字符串的公共前缀
    private String compareTwoStrs(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);

    }

    // 暴力纵向查找
    public String longestCommonPrefix_1(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    // 分治方案
    public String longestCommonPrefix_2(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }

    // 二分查找
    public String longestCommonPrefix_3(String[] strs) {
        if (strs.length == 0) return "";
        // 先获取最小长度
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        // 定义变量，开始二分法
        int low = 0, high = minLength;
        while (low < high) {
            // 获取中间点
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    public Boolean isCommonPrefix(String[] strs, int length) {
        // 先获取前一半要比较的字符串
        String str0 = strs[0].substring(0, length);
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < length; j++) {
                // 按字符进行判断，如果有不一样的字符直接返回 false
                if (str0.charAt(j) != strs[i].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"aaa","aa","aaa"};
        System.out.println(solution.longestCommonPrefix_2(strs));
    }
}
