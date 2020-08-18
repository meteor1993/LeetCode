package com.geekdigging.day023;

import com.geekdigging.commonDataStructure.TreeNode;

import java.util.*;

/**
 * 二叉树的层次遍历 II
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 */
public class Solution {
    // 顺序思维操作 耗时 2ms
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 新增一个数据结构，栈
        Stack<List<Integer>> stack = new Stack<>();

        // 外层循环，每次循环都是一层
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            // 循环这一层的所有节点
            while (size > 0) {
                TreeNode node = queue.poll();
                // 将这一层的所有节点放到 list 中
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            // 将列表当道栈中
            stack.push(list);
        }

        // 将栈中数据取出来放到列表中
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    // 优化代码，不适用栈，直接使用 list.add 方法，耗时 1ms
    public List<List<Integer>> levelOrderBottom_1(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            result.add(0, list);
        }
        return result;
    }
}
