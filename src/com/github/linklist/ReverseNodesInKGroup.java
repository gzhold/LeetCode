package com.github.linklist;

/**
 * 25. Reverse Nodes in k-Group
 * Created by admin on 2019/二月/18.
 */
public class ReverseNodesInKGroup {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head || null == head.next || k == 0) {
            return head;
        }
        return null;
    }

    /**
     * reversr link list
     * @param head
     * @return
     */
    public ListNode reverseLinkList(ListNode head) {
        ListNode cur = head, prev = null, temp = head;
        while(null != cur) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup rnikg = new ReverseNodesInKGroup();
        ListNode l5 = rnikg.new ListNode(5);
        ListNode l4 = rnikg.new ListNode(4);
        ListNode l3 = rnikg.new ListNode(3);
        ListNode l2 = rnikg.new ListNode(2);
        ListNode l1 = rnikg.new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode temp = rnikg.reverseKGroup(l1, 2);
        System.out.println(null != temp ? temp.val: null);
    }

}
