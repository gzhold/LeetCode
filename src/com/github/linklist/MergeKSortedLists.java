package com.github.linklist;

import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by admin on 2019/四月/18.
 */
public class MergeKSortedLists {

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


    /**
     * PriorityQueue
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(List<ListNode> lists) {
        if (null == lists || lists.size() == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }


    /**
     * recursion
     * @param lists
     * @return
     */
    public static ListNode mergeKLists1(List<ListNode> lists){
        return partion(lists,0,lists.size()-1);
    }

    public static ListNode partion(List<ListNode> lists,int s,int e){
        if(s==e)  return lists.get(s);
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else
            return null;
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }




    @Test
    public void test() {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(4);
        ListNode ln3 = new ListNode(5);
        ln1.next = ln2;
        ln2.next = ln3;


        ListNode ln4 = new ListNode(1);
        ListNode ln5 = new ListNode(3);
        ListNode ln6 = new ListNode(4);
        ln4.next = ln5;
        ln5.next = ln6;

        ListNode ln7 = new ListNode(2);
        ListNode ln8 = new ListNode(6);
        ln7.next = ln8;

        List<ListNode> lists = new LinkedList<>();
        lists.add(ln1);
        lists.add(ln4);
        lists.add(ln7);

        ListNode end = mergeKLists(lists);
        ListNode temp = end;
        while (temp.next != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.print(temp.val);
    }


    @Test
    public void test1() {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(4);
        ListNode ln3 = new ListNode(5);
        ln1.next = ln2;
        ln2.next = ln3;


        ListNode ln4 = new ListNode(1);
        ListNode ln5 = new ListNode(3);
        ListNode ln6 = new ListNode(4);
        ln4.next = ln5;
        ln5.next = ln6;

        ListNode ln7 = new ListNode(2);
        ListNode ln8 = new ListNode(6);
        ln7.next = ln8;

        List<ListNode> lists = new LinkedList<>();
        lists.add(ln1);
        lists.add(ln4);
        lists.add(ln7);
        System.out.println();
        ListNode end = mergeKLists1(lists);
        ListNode temp = end;
        while (temp.next != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.print(temp.val);
    }


}
