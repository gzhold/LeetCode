package com.github.linklist.review;

import org.junit.Test;

/**
 * Created by admin on 2019/五月/3.
 */
public class MiddleofTheLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * 时间 O(n)  空间 O(1)
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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


    /**
     * 时间 O(n)  空间 O(1)
     * @param head
     * @return
     */
    public ListNode middleNode1(ListNode head) {
        int count = 1;
        ListNode listNode = head;

        while (head.next != null) {
            count++;
            head = head.next;
            if (count % 2 == 0) {
                listNode = listNode.next;
            }
        }
        return listNode;
    }


    /**
     * Input: [1,2,3,4,5]
     * Output: Node 3 from this list (Serialization: [3,4,5])
     */
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

        prinf(middleNode1(l1));
    }


    @Test
    public void test1 () {
        ListNode l6 = new ListNode(6);
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = null;

        prinf(middleNode1(l1));
    }

}
