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
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
