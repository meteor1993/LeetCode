package com.geekdigging.day036;

import com.geekdigging.commonDataStructure.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * 相交链表
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 这道题就不抄了，没有图不是很好理解，力扣题号 160
 *
 * @Date: 2020/8/31
 * @Time: 20:17
 * @email: inwsy@hotmail.com
 * Description:
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = listNodeLength(headA);
        int lenB = listNodeLength(headB);

        if (lenA > lenB) {
            int num = lenA - lenB;
            while (num > 0) {
                headA = headA.next;
                num--;
            }
        } else {
            int num = lenB - lenA;
            while (num > 0) {
                headB = headB.next;
                num--;
            }
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }

        return null;
    }

    private int listNodeLength(ListNode head) {
        int len = 0;

        while (head != null) {
            len += 1;
            head = head.next;
        }

        return len;
    }

    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode ha = headA, hb = headB;
        while (ha != hb) {
            ha = ha != null ? ha.next : headB;
            hb = hb != null ? hb.next : headA;
        }
        return ha;
    }
}
