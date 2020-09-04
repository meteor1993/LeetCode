package com.geekdigging.day040;

/**
 * Created with IntelliJ IDEA.
 *
 * Excel表列序号
 *
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 *
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 *
 * @Date: 2020/9/4
 * @Time: 19:15
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            sum += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - i - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.titleToNumber("ZY"));
    }
}
