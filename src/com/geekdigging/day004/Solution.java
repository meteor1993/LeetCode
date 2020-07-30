package com.geekdigging.day004;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
 *
 * 示例1:
 * 输入: "III"
 * 输出: 3
 *
 * 示例 2:
 * 输入: "IV"
 * 输出: 4
 *
 * 示例 3:
 * 输入: "IX"
 * 输出: 9
 *
 * 示例 4:
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 *
 * 示例 5:
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * 
 * @Date: 2020/7/29
 * @Time: 23:57
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public int romanToInt(String s) {
        // 定义返回结果
        int sum = 0;

        int preNum = getValue(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));

            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }

            preNum = num;
        }

        sum += preNum;

        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    // 放入 hash 表
    public int romanToInt_1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // 定义返回结果
        int sum = 0;

        int preNum = map.get(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int num = map.get(s.charAt(i));

            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }

            preNum = num;
        }

        sum += preNum;

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt_1("III"));
    }
}
