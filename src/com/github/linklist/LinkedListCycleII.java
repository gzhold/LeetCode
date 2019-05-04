package com.github.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Created by admin on 2019/二月/18.
 */
public class LinkedListCycleII {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode detectCycle(ListNode head) {
        if (null == head || null == head.next)
            return null;
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (null != p) {
            if (set.contains(p)) {
                return p;
            }
            set.add(p);
            p = p.next;
        }
        return null;

    }


    public ListNode detectCycle1(ListNode head) {
        if (null == head || null == head.next)
            return null;
        ListNode slow = head, fast = head;
        while(fast != null && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (head != fast) {
                    fast = fast.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        LinkedListCycleII llc = new LinkedListCycleII();

        ListNode l4 = llc.new ListNode(-4);
        ListNode l3 = llc.new ListNode(0);
        ListNode l2 = llc.new ListNode(2);
        ListNode l1 = llc.new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

//        ListNode l2 = llc.new ListNode(2);
//        ListNode l1 = llc.new ListNode(1);
//        l1.next = l2;

        ListNode temp = llc.detectCycle1(l1);
        System.out.println(null != temp ? temp.val: null);
    }


}
