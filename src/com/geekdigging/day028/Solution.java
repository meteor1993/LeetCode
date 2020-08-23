package com.geekdigging.day028;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * 杨辉三角
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * @Date: 2020/8/23
 * @Time: 0:35
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        // 如果是 0 ，直接返回空
        if (numRows == 0) {
            return triangle;
        }

        // 直接给第一行赋值，永远是 1
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            // 定义当前行
            List<Integer> row = new ArrayList<>();
            // 定义上一行
            List<Integer> prevRow = triangle.get(i - 1);
            // 当前行开头为 1
            row.add(1);
            // 计算每一个数值，结果是上一行的 j 和 j + 1 位置的和
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            // 当前行添加末尾数字 1
            row.add(1);
            // 把当前行添加到要返回的列表中
            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generate(2);
    }
}
