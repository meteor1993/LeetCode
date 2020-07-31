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

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix_1(strs));
    }
}
