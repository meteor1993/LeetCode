package com.geekdigging.day026;

import com.geekdigging.commonDataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 路径总和
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        Queue<TreeNode> queueNode = new LinkedList<>();
        queueNode.offer(root);

        Queue<Integer> queueInts = new LinkedList<> ();
        queueInts.offer(root.val);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int temp = queueInts.poll();
            if (node.left == null && node.right == null) {
                if (temp == sum) {
                    return true;
                }
            }

            if (node.left != null) {
                queueNode.offer(node.left);
                queueInts.offer(temp + node.left.val);
            }

            if (node.right != null) {
                queueNode.offer(node.right);
                queueInts.offer(temp + node.right.val);
            }
        }
        return false;
    }

    public boolean hasPathSum_1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum_1(root.left, sum - root.val) || hasPathSum_1(root.right, sum - root.val);
    }
}
