package com.geekdigging.day024;

import com.geekdigging.commonDataStructure.TreeNode;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * 将有序数组转换为二叉搜索树
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 *
 * @Date: 2020/8/19
 * @Time: 20:27
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    // 中序遍历，选择中间位置左边的数字作为根节点
    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);
        return node;
    }

    // 中序遍历，选择中间位置右边的数字作为根节点
    public TreeNode helper_1(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = (left + right + 1) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);
        return node;
    }

    // 中序遍历，选择任意一个中间位置数字作为根节点
    public TreeNode helper_2(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = (left + right + new Random().nextInt(2)) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);
        return node;
    }
}
