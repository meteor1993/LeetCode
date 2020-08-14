package com.geekdigging.day019;

/**
 * Created with IntelliJ IDEA.
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 *
 * @Date: 2020/8/14
 * @Time: 19:14
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    // 从前往后
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy_nums1 = new int[m];
        System.arraycopy(nums1, 0, copy_nums1, 0, m);

        // copy_nums1 的指针
        int n1 = 0;
        // nums2 的指针
        int n2 = 0;
        // nums1 的指针
        int n0 = 0;

        while ((n1 < m) && (n2 < n)) {
            nums1[n0++] = copy_nums1[n1] < nums2[n2] ? copy_nums1[n1++] : nums2[n2++];
        }

        if (n1 < m) {
            System.arraycopy(copy_nums1, n1, nums1, n1 + n2, m + n - n1 - n2);
        }
        if (n2 < n) {
            System.arraycopy(nums2, n2, nums1, n1 + n2, m + n - n1 - n2);
        }
    }

    // 从后往前
    public void merge_1(int[] nums1, int m, int[] nums2, int n) {
        // nums1 有数据的尾部指针
        int n1 = m - 1;
        // nums2 的尾部指针
        int n2 = n - 1;
        // nums1 最终的尾部指针
        int n0 = m + n - 1;

        while ((n1 >= 0) && (n2 >= 0)) {
            nums1[n0--] = nums1[n1] < nums2[n2] ? nums2[n2--] : nums1[n1--];
        }

        System.arraycopy(nums2, 0, nums1, 0, n2 + 1);

    }
}
