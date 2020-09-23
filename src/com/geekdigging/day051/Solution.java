package com.geekdigging.day051;

/**
 * Created with IntelliJ IDEA.
 *
 * 盛最多水的容器
 *
 * @Date: 2020/9/23
 * @Time: 22:28
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int start = 0, end = len - 1;
        int maxArea = 0;
        while (start != end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            maxArea = Math.max(area, maxArea);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
}
