package com.github.linklist.review;

import org.junit.Test;

/**
 * Created by admin on 2019/四月/29.
 */
public class RemoveNthNodeFromEndofList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 时间 O(n)  空间 O(1)
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        if (n <= 0) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (n > 0 && null != fast) {
            --n;
            fast = fast.next;
        }
        if (null == fast) {
            return head.next;
        }
        while (fast != null && null != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        if (null != slow && slow.next != null)
            slow.next = slow.next.next;
        return head;
    }

    public void prinf(ListNode head) {
        if (null == head) {
            return;
        }
        ListNode p = head;
        while (p != null && p.next != null) {
            System.out.print(p.val + "  ");
            p = p.next;
        }
        if (null != p) {
            System.out.println(p.val);
        }
    }


    @Test
    public void test () {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;

        prinf(removeNthFromEnd(l1, 2));
    }

    /**
     * [1,2], n = 2
     * Expected [2]
     */
    @Test
    public void test1 () {
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        l1.next = l2;
        l2.next = null;

        prinf(removeNthFromEnd(l1, 2));
    }

}
