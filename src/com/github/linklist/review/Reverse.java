package com.github.linklist.review;

import org.junit.Test;

/**
 * Created by admin on 2019/四月/25.
 */
public class Reverse {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode q = head, p = null, temp = null;
        while (q != null && null != q.next) {
            temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        if (null != q) {
            q.next = p;
        } else {
            return p;
        }
        return q;
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
    public void test() {
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

        prinf(reverseList(l1));
    }



}
