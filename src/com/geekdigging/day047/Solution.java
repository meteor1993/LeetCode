package com.geekdigging.day047;

/**
 * Created with IntelliJ IDEA.
 *
 * 寻找两个正序数组的中位数
 *
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @Date: 2020/9/15
 * @Time: 21:24
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] nums = new int[n1 + n2];
        // 先处理极限情况, nums1 为空
        if (n1 == 0) {
            // 如果 nums2 长度是偶数
            if (n2 % 2 == 0) {
                return (nums2[n2 / 2 - 1] + nums2[n2 / 2]) / 2.0;
            } else {
                return nums2[n2 / 2];
            }
        }
        // 同上，如果 nums2 为空
        if (n2 == 0) {
            if (n1 % 2 == 0) {
                return (nums1[n1 / 2 - 1] + nums1[n1 / 2]) / 2.0;
            } else {
                return nums1[n1 / 2];
            }
        }

        // 定义新数组的指针
        int count = 0;
        int i = 0, j = 0;

        while (count != (n1 + n2)) {
            // 当 nums1 循环结束而 nums2 还有的时候
            if (i == n1) {
                while (j != n2){
                    nums[count++] = nums2[j++];
                }
                break;
            }
            // 当 nums2 循环结束而 nums1 还有的时候
            if (j == n2) {
                while (i != n1) {
                    nums[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

    public double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int totalLength = l1 + l2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            return getKthElement(nums1, nums2, midIndex + 1);
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            return (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
        }
    }

    // 获取第 k 小的数字
    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findMedianSortedArrays(new int[] {1, 3}, new int[]{2});
    }
}
