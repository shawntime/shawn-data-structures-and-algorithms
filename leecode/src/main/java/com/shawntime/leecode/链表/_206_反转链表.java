package com.shawntime.leecode.链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class _206_反转链表 {

    /**
     * 递归
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next = head.next;
        if (next == null) {
            return head;
        }
        ListNode listNode = reverseList(next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    /**
     * 头插法
     */
    public ListNode reverseList2(ListNode head) {
        ListNode newNode = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newNode;
            newNode = head;
            head = nextNode;
        }
        return newNode;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
