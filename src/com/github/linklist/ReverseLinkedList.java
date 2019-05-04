package com.github.linklist;

/**
 * 反转链表
 * Created by admin on 2019/二月/17.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode cur = head, prev = null, temp = null;
        while (null != cur) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        ReverseLinkedList rll = new ReverseLinkedList();

        ListNode l5 = rll.new ListNode(5);
        ListNode l4 = rll.new ListNode(4);
        ListNode l3 = rll.new ListNode(3);
        ListNode l2 = rll.new ListNode(2);
        ListNode l1 = rll.new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        rll.reverseList(l1);
    }

}
