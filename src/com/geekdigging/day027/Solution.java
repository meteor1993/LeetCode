package com.geekdigging.day027;

import com.geekdigging.commonDataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * @Date: 2020/8/22
 * @Time: 11:17
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth + 1;
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

                size--;
            }
            ++depth;
        }
        return depth;
    }

    public int minDepth_1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth_1(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth_1(root.right), min_depth);
        }

        return min_depth + 1;
    }
}
