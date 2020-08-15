package com.geekdigging.commonDataStructure;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2020/8/15
 * @Time: 20:20
 * @email: inwsy@hotmail.com
 * Description:
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
