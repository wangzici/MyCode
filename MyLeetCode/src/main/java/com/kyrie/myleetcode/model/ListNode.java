package com.kyrie.myleetcode.model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode createNode(int[] ints) {
        if (ints == null || ints.length == 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i : ints) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return head.next;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ListNode) {
            ListNode node1 = (ListNode) o;
            ListNode node2 = this;
            while (node1 != null || node2 != null) {
                if (node1 == null || node2 == null) {
                    return false;
                }else if (node1.val != node2.val) {
                    return false;
                }
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        return super.equals(o);
    }
}
