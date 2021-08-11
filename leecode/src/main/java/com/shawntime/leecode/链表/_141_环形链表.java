package com.shawntime.leecode.链表;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class _141_环形链表 {

    /**
     * 快慢指针
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode first = head;
        ListNode second = head.next;
        while (second != null && second.next != null && first != second) {
            first = first.next;
            second = second.next.next;
        }
        return second != null && second.next != null;
    }

    class ListNode {
        int val;
        ListNode next;ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
