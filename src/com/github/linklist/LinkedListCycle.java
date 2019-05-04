package com.github.linklist;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2019/四月/18.
 */
public class LinkedListCycle {

    /**
     * inner class
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }


    public static boolean hasCycle1(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (null != p.next) {
            if (set.contains(p)) {
                return true;
            }
            set.add(p);
            p = p.next;
        }
        return false;
    }



    @Test
    public void test1() {
        ListNode ln1 = new ListNode(3);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(0);
        ListNode ln4 = new ListNode(4);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln2;

        System.out.println(hasCycle1(ln1));
    }


    @Test
    public void test2() {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ln1.next = ln2;
//        ln2.next = ln1;
        System.out.println(hasCycle1(ln1));
    }

    @Test
    public void test3() {
        ListNode ln1 = new ListNode(1);
        System.out.println(hasCycle1(ln1));
    }

}
