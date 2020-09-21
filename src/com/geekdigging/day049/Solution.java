package com.geekdigging.day049;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * Z 字形变换
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * @Date: 2020/9/21
 * @Time: 22:03
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public String convert(String s, int numRows) {
        // 极限值判断
        if (numRows == 1) return s;
        // 定义行
        List<StringBuilder> rows = new ArrayList<>();
        // 每一行都增加一个列
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());
        // 定义当前行数
        int curRow = 0;
        // 定义是否转向
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            // 当前行添加一个字符
            rows.get(curRow).append(c);
            // 如果当前行是第一行或者是最后一行，转向标记位取反
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            // 注意：这里计算了下一次循环的行数，并且完成了循环中转向
            curRow += goingDown ? 1 : -1;
        }
        // 定义输出
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public String convert_1(String s, int numRows) {
        if (numRows == 1) return s;
        // 定义输出
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }

        return ret.toString();
    }
}
