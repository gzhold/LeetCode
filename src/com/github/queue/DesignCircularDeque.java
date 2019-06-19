package com.github.queue;


import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 *
 * Created by admin on 2019/五月/6.
 */
public class DesignCircularDeque {
    /**
     * 容量大小
     */
    private int capacity = 4;
    private int offset = 0;

    private ListNode head;

    private ListNode tail;

    public class ListNode {
        Integer val;
        ListNode next;
        ListNode pre;
        ListNode(int x) { val = x; }
    }

    public DesignCircularDeque() {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.pre = tail;
        tail.next = head;
        this.offset = 0;
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
//    public DesignCircularDeque(int k) {
//        head = new ListNode(-1);
//        tail = new ListNode(-1);
//        head.pre = tail;
//        tail.next = head;
//        this.capacity = k;
//        this.offset = 0;
//    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (offset == capacity)
            return false;
        ListNode node = new ListNode(value);
        node.next = head;
        node.pre = head.pre;
        head.pre.next = node;
        head.pre = node;
        offset++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (offset == capacity)
            return false;
        ListNode node = new ListNode(value);
        node.next = tail.next;
        tail.next.pre = node;
        tail.next = node;
        node.pre = tail;
        offset++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (offset == 0)
            return false;
        head.pre.pre.next = head;
        head.pre = head.pre.pre;
        offset--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (offset == 0)
            return false;
        tail.next.next.pre = tail;
        tail.next = tail.next.next;
        offset--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return head.pre.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return tail.next.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return offset == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return offset == capacity;
    }


    @Ignore
    public void test () {
        // set the size to be 3
        DesignCircularDeque circularDeque = new DesignCircularDeque();
        System.out.println(circularDeque.insertLast(1));			// return true
        System.out.println(circularDeque.insertLast(2));			// return true
        System.out.println(circularDeque.insertFront(3));			// return true
        System.out.println(circularDeque.insertFront(4));			// return false, the queue is full
        System.out.println(circularDeque.getRear());  			// return 2
        System.out.println(circularDeque.isFull());				// return true
        System.out.println(circularDeque.deleteLast());			// return true
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.insertFront(4));			// return true
        System.out.println(circularDeque.getFront());			// return 4
    }

    @Ignore
    public void test1 () {
        /**
         * ["MyCircularDeque","insertFront","getFront","isEmpty","deleteFront","insertLast",
         *  "getRear","insertLast","insertFront","deleteLast","insertLast","isEmpty"]
         * [[8],[5],[],[],[],[3],[],[7],[7],[],[4],[]]
         * output: [null,true,5,false,true,true,3,true,true,true,true,false]
         */
        DesignCircularDeque circularDeque = new DesignCircularDeque();
        System.out.println(circularDeque.insertFront(5));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.isEmpty());
        System.out.println(circularDeque.deleteFront());
        System.out.println(circularDeque.insertLast(3));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.insertLast(7));
        System.out.println(circularDeque.insertFront(7));
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.insertLast(4));
        System.out.println(circularDeque.isEmpty());

    }


    @Ignore
    public void test2 () {
        /**
         * ["MyCircularDeque","insertFront","insertLast","getFront","insertLast","getFront",
         * "insertFront","getRear","getFront","getFront","deleteLast","getRear"]
         [[5],[7],[0],[],[3],[],[9],[],[],[],[],[]]
         * output: [null,true,true,7,true,7,true,3,9,9,true,0]
         */
        DesignCircularDeque circularDeque = new DesignCircularDeque();
        System.out.println(circularDeque.insertFront(7));
        System.out.println(circularDeque.insertLast(0));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.insertLast(3));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.getRear());
    }


    @Ignore
    public void test3 () {
        /**
         * ["MyCircularDeque","insertFront","getRear","insertFront","getRear","insertLast",
         * "getFront","getRear","getFront","insertLast","deleteLast","getFront"]
         * [[3],[9],[],[9],[],[5],[],[],[],[8],[],[]]
         */
        DesignCircularDeque circularDeque = new DesignCircularDeque();
        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.insertLast(5));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.insertLast(8));
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.getFront());
    }


    @Test
    public void test4 () {
        /**
         * ["MyCircularDeque","insertFront","deleteLast","getRear","getFront","getFront",
         * "deleteFront","insertFront","insertLast","insertFront","getFront","insertFront"]
         * [[4],[9],[],[],[],[],[],[6],[5],[9],[],[6]]
         */
        DesignCircularDeque circularDeque = new DesignCircularDeque();
        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.deleteFront());
        System.out.println(circularDeque.insertFront(6));
        System.out.println(circularDeque.insertLast(5));
        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.insertFront(6));
    }


}
