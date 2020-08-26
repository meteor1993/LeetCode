package com.geekdigging.day032;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * @Date: 2020/8/26
 * @Time: 19:45
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        s = s.trim().toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        int len = s.length()/2;
        if (s.length() % 2 > 0) len = len + 1;
        boolean flag = true;
        for (int i = 0; i <= len; i++) {
            if (s.charAt(i) == s.charAt(s.length() - 1 - i)) {
                continue;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean isPalindrome_1(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    public boolean isPalindrome_2(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

    public boolean isPalindrome_3(String s) {
        int left = 0;
        int right = s.length() -1;
        while(left <right) {
            if(!isAlphaNu(s.charAt(left))) {
                left++;
            }
            else if (!isAlphaNu(s.charAt(right))){
                right--;
            }
            else if((s.charAt(left) + 32 - 'a') % 32 != (s.charAt(right) + 32 - 'a') % 32){
                return false;
            }
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    boolean isAlphaNu(char ch) {
        if (ch >= 'a' && ch <= 'z') return true;
        if (ch >= 'A' && ch <= 'Z') return true;
        if (ch >= '0' && ch <= '9') return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome_1("Damosel, a poem? A carol? Or a cameo pale? (So mad!)"));
    }
}
