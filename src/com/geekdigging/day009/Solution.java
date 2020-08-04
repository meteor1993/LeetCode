package com.geekdigging.day009;

/**
 * Created with IntelliJ IDEA.
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 *
 * @Date: 2020/8/4
 * @Time: 21:22
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr_1(String haystack, String needle) {

        int h = haystack.length(), n = needle.length();

        for (int i = 0; i < h - n + 1; i++) {
            if (needle.equals(haystack.substring(i, i + n))) {
                return i;
            }
        }

        return -1;
    }

    public int strStr_2(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;

        int pn = 0;
        while (pn < n - L + 1) {
            // 第一次循环 pn ，寻找和 needle 第一位相同的子串
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

            // 从 pn 开始，按位比较字符，获得相同位数长度 currLen
            int currLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++currLen;
            }

            // 如果 currLen 长度等于 needle 长度，匹配结束
            if (currLen == L) return pn - L;

            // 如果不等于，开始回溯
            pn = pn - currLen + 1;
        }
        return -1;
    }

    public int strStr_3(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;
        int pn = 0;
        while (pn < n - L + 1) {
            // 第一次循环 pn ，寻找和 needle 第一位相同的子串
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0))  ++pn;
            // 如果 pn + L 的长度大于当前字符串长度，直接返回 -1
            if (pn + L > n) return -1;
            // 如果 pn + L 得到的子串和 needle 相同，直接返回 pn
            if (haystack.substring(pn, pn + L).equals(needle)) {
                return pn;
            }
            // 没匹配到 ++pn
            ++pn;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "aaaaa";
        String needle = "bba";
        Solution solution = new Solution();
        System.out.println(solution.strStr(haystack, needle));
    }
}
