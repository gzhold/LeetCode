package com.github.linklist.review;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2019/四月/25.
 */
public class Cycle {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 时间O(n) 空间 O(n)
     * @param head
     * @return
     */
    public boolean hasCycleBySet(ListNode head) {
        if (null == head || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (null != p) {
            if (set.contains(p)) {
                return true;
            }
            set.add(p);
            p = p.next;
        }
        return false;
    }


    /**
     * 时间O(n) 空间 O(1)
     * @param head
     * @return
     */
    public boolean hasCycleByPointer(ListNode head) {
        if (null == head || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (null != fast && null != fast.next) {
            if (slow == fast) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }





    /**
     * head = [3,2,0,-4], pos = 1
     */
    @Test
    public void test1() {
        ListNode l4 = new ListNode(-4);
        ListNode l3 = new ListNode(0);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

//        System.out.println((hasCycleBySet(l1)));
        System.out.println((hasCycleByPointer(l1)));
    }

    /**
     * head = [1,2], pos = 0
     */
    @Test
    public void test2() {
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        l1.next = l2;
        l2.next = l1;

//        System.out.println((hasCycleBySet(l1)));
        System.out.println((hasCycleByPointer(l1)));
    }

    /**
     * head = [1], pos = -1
     */
    @Test
    public void test3() {
        ListNode l1 = new ListNode(1);
        l1.next = null;

//        System.out.println((hasCycleBySet(l1)));
        System.out.println((hasCycleByPointer(l1)));
    }


}
