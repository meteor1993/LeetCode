package com.geekdigging.day029;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 杨辉三角 II
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * @Date: 2020/8/23
 * @Time: 17:50
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    // 昨天的解题方案
    public List<Integer> getRow(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        // 直接给第一行赋值，永远是 1
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int i = 1; i <= numRows; i++) {
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

        return triangle.get(numRows);
    }

    // 方案优化
    public List<Integer> getRow_1(int numRows) {
        List<Integer> row = new ArrayList<> ();
        List<Integer> prevRow = new ArrayList<> ();
        for (int i = 0; i <= numRows; i++) {
            row = new ArrayList<> ();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }
            }
            prevRow = row;
        }
        return row;
    }

    // 通项公式
    public List<Integer> getRow_2(int numRows) {
        List<Integer> list = new ArrayList<>();
        int N = numRows;
        for (int k = 0; k <= N; k++) {
            list.add(combination(N, k));
        }
        return list;
    }

    private int combination(int N, int k) {
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (N - k + i) / i;
        }
        return (int) res;
    }

    // 通项公式直接求解
    public List<Integer> getRow_3(int numRows) {
        List<Integer> list = new ArrayList<>();
        int N = numRows;
        long pre = 1;
        list.add(1);
        for (int k = 1; k <= N; k++) {
            long cur = pre * (N - k + 1) / k;
            list.add((int) cur);
            pre = cur;
        }
        return list;
    }

    // 通项公式只计算一半
    public List<Integer> getRow_4(int numRows) {
        List<Integer> list = new ArrayList<>();
        int N = numRows;
        long pre = 1;
        list.add(1);
        for (int k = 1; k <= N; k++) {
            if (k <= (N + 1) / 2) {
                long cur = pre * (N - k + 1) / k;
                list.add((int) cur);
                pre = cur;
            } else {
                list.add(list.get(N - k));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int j = 0; j < 100; j++) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 33; i++) {
                solution.getRow_4(i);
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }
}
