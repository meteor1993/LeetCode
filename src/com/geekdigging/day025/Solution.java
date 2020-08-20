package com.geekdigging.day025;

import com.geekdigging.commonDataStructure.TreeNode;

/**
 * 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 *
 */
public class Solution {
    // 自顶向下递归
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        else return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(height(root.left), height(root.right)) + 1;
    }

    // 自底向上递归
    public boolean isBalanced_1(TreeNode root) {
        return height_1(root) >= 0;
    }

    public int height_1(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height_1(root.left);
        int rightHeight = height_1(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
