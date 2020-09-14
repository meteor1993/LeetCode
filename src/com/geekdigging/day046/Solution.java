package com.geekdigging.day046;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @Date: 2020/9/14
 * @Time: 22:11
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> setChars = new HashSet<>();
        int length = s.length();
        // 定义右指针
        int right = -1;
        // 定义返回结果
        int result = 0;
        for (int i = 0; i < length; ++i) {
            if (i != 0) {
                // 左指针右移一次，删掉前一个字符
                setChars.remove(s.charAt(i - 1));
            }
            while (right + 1 < length && !setChars.contains(s.charAt(right + 1))) {
                // 移动右指针，像 set 中添加字符
                setChars.add(s.charAt(right + 1));
                ++right;
            }
            result = Math.max(result, right - i + 1);
        }
        return result;
    }

    public int lengthOfLongestSubstring_1(String s) {
        int length = s.length(), result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < length; right++) {
            // 如果含有右指针指向的元素，则移动左指针
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)), left);
            }
            result = Math.max(result, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }
        return result;
    }

    public int lengthOfLongestSubstring_2(String s) {
        int n = s.length();
        int result = 0;
        int[] charIndex = new int[128];
        for (int left = 0, right = 0; right < n; right++) {
            char c = s.charAt(right);
            left = Math.max(charIndex[c], left);
            result = Math.max(result, right - left + 1);
            charIndex[c] = right + 1;
        }
        return result;
    }
}
