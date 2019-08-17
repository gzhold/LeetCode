package com.github.queue;


/**
 * leetcode 641
 */
public class CircularDeque {

  private final int[] values;
  private volatile int head = 0;

  private volatile int tail = -1;
  private volatile int capacity;


  /** Initialize your data structure here. Set the size of the devalues to be k. */
  public CircularDeque(int k) {
    if (k < 0) {
      throw new RuntimeException("k less than zero.");
    }
    values = new int[k];
  }

  /** Adds an item at the front of Devalues. Return true if the operation is successful. */
  public boolean insertFront(int value) {
    if(isFull()) {
      return false;
    }
    if(!isEmpty()){
      head = head==0 ? values.length-1 : head-1;
    } else {
      head = 0;
      tail = 0;
    }
    values[head]=value;
    ++ capacity;
    return true;
  }

  /** Adds an item at the rear of Devalues. Return true if the operation is successful. */
  public boolean insertLast(int value) {
    if(isFull()) {
      return false;
    }
    tail = (tail+1)%values.length;
    values[tail]=value;
    ++ capacity;
    return true;
  }

  /** Deletes an item from the front of Devalues. Return true if the operation is successful. */
  public boolean deleteFront() {
    if(isEmpty()){
      return false;
    }
    head = (head+1)%values.length;
    -- capacity;
    return true;
  }

  /** Deletes an item from the rear of Devalues. Return true if the operation is successful. */
  public boolean deleteLast() {
    if(isEmpty()){
      return false;
    }
    tail = tail==0 ? values.length-1 :tail-1;
    -- capacity;
    return true;
  }

  /** Get the front item from the devalues. */
  public int getFront() {
    return isEmpty() ? -1 : values[head];
  }

  /** Get the last item from the devalues. */
  public int getRear() {
    return isEmpty() ? -1 : values[tail];
  }

  /** Checks whether the circular devalues is empty or not. */
  public boolean isEmpty() {
    if (capacity == 0) {
      return true;
    }
    return false;
  }

  /** Checks whether the circular devalues is full or not. */
  public boolean isFull() {
    if (values.length == capacity) {
      return true;
    }
    return false;
  }


  public static void main(String[] args) {
    CircularDeque circularDevalues = new CircularDeque(5); // set the size to be 3

    // return true
//    System.out.println(circularDevalues.insertLast(1));
//    // return true
//    System.out.println(circularDevalues.insertLast(2));
//    // return true
//    System.out.println(circularDevalues.insertFront(3));
//    // return false, the valuesue is full
//    System.out.println(circularDevalues.insertFront(4));
//    // return 2
//    System.out.println(circularDevalues.getRear());
//    // return true
//    System.out.println(circularDevalues.isFull());
//    // return true
//    System.out.println(circularDevalues.deleteLast());
//    // return true
//    System.out.println(circularDevalues.insertFront(4));
//    // return 4
//    System.out.println(circularDevalues.getFront());

//    System.out.println(circularDevalues.insertFront(7));
//    System.out.println(circularDevalues.insertLast(2));
//
//    System.out.println(circularDevalues.getFront());
//
//    System.out.println(circularDevalues.getRear());

    /**
     * ["MyCircularDevalues","insertFront","insertFront","insertLast","deleteLast",
     *  "insertLast","getRear","insertLast","getFront","deleteFront","insertLast",
     *  "insertLast"]
     * [[5],[5],[0],[5],[],[7],[],[7],[],[],[6],[1]]
     */
    System.out.println(circularDevalues.insertFront(5));
    System.out.println(circularDevalues.insertFront(1));
    System.out.println(circularDevalues.insertLast(5));
    System.out.println(circularDevalues.deleteLast());
    System.out.println(circularDevalues.insertLast(7));
    System.out.println(circularDevalues.getRear());
    System.out.println(circularDevalues.insertLast(7));
    System.out.println(circularDevalues.getFront());
    System.out.println(circularDevalues.deleteFront());
    System.out.println(circularDevalues.insertLast(6));
    System.out.println(circularDevalues.insertLast(1));

  }

}
