package com.github.linklist.review;

import org.junit.Test;

/**
 * Created by admin on 2019/四月/26.
 */
public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * 时间 O(n)   空间O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        ListNode p = l1, q = l2, temp = new ListNode(-1);
        ListNode head = temp;
        while (null != p && null != q) {
            if (p.val > q.val) {
                temp.next  = q;
                q = q.next;
            } else if (p.val <= q.val) {
                temp.next = p;
                p = p.next;
            }
            temp = temp.next;
        }
        if (null != p) {
            temp.next = p;
        } else if (null != q)  {
            temp.next = q;
        }
        return head.next;
    }


    /**
     * 递归遍历  时间0(n) 空间O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsByRecursion(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoListsByRecursion(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoListsByRecursion(l1, l2.next);
            return l2;
        }
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
        ListNode l3 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;


        ListNode l6 = new ListNode(4);
        ListNode l5 = new ListNode(3);
        ListNode l4 = new ListNode(1);
        l4.next = l5;
        l5.next = l6;
        l6.next = null;


//        prinf(mergeTwoLists(l1, l4));
        prinf(mergeTwoListsByRecursion(l1, l4));
    }


}
