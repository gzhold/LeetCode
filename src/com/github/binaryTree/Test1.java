package com.github.binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.junit.Assert;

public class Test1 {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
  }


  public static List<Integer> inorder (TreeNode root) {
    List<Integer> list = new LinkedList<>();

    inorderBST(root, list);
    return list;
  }

  private static void inorderBST(TreeNode root, List<Integer> list) {
    if(null == root) {
      return;
    }
    Stack<TreeNode> stack = new Stack();
    while (null != root || !stack.isEmpty()) {
      while (null != root) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if(null != root) {
        list.add(root.val);
        root = root.right;
      }
    }
  }


  public static List<Integer> preorder(TreeNode root) {
    List<Integer> list = new LinkedList<>();

    preorderBST(root, list);
    return list;
  }


  private static void preorderBST(TreeNode root, List<Integer> list) {
    if (null == root) {
      return;
    }
    Stack<TreeNode> stack = new Stack();
    while (null != root) {
      list.add(root.val);
      if(null != root.right) {
        stack.push(root.right);
      }
      root = root.left;
      if(null == root && !stack.isEmpty()) {
        root = stack.pop();
      }
    }
  }


  public static List<Integer> postorder(TreeNode root) {
    LinkedList<Integer> list = new LinkedList<>();

    postorderBST(root, list);
    return list;
  }

  private static void postorderBST(TreeNode root, LinkedList<Integer> list) {
    if (null == root) {
      return;
    }
    Stack<TreeNode> stack = new Stack();
    stack.push(root);
    while (!stack.isEmpty()) {
      root = stack.pop();
      list.addFirst(root.val);
      if (root.left != null) {
        stack.push(root.left);
      }
      if (root.right != null) {
        stack.push(root.right);
      }
    }
  }



  public static void main(String[] args) {
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);

    node1.right = node3;
    node1.left = node2;

    node2.left = node4;
    node2.right = node5;

    node3.left = node6;
    node3.right = node7;

    List<Integer> list = postorder(node1);

    print(list);
  }


  public static void print(List<Integer> list) {
    Assert.assertNotEquals(null, list);

    for(int i : list) {
      System.out.print(i + "  ");
    }
  }

}
