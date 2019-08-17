package com.github.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.junit.Assert;

public class BinaryTreeInorderTraversal {

  /**
   * 中序遍历
   * Time complexity : O(n). The time complexity is O(n)
   * because the recursive function is T(n)=2⋅T(n/2)+1.
   *
   * Space complexity : The worst case space required is O(n),
   * and in the average case it's O(logn) where n is number of nodes.
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    inorder(root, list);
    return list;
  }

  private void inorder (TreeNode root, List<Integer> list) {
    if (null != root) {
      if (null != root.left) {
        inorder(root.left, list);
      }
      list.add(root.val);
      if (null != root.right) {
        inorder(root.right, list);
      }
    }
  }


  /**
   * Time complexity : O(n).
   *
   * Space complexity : O(n).
   * @param root
   * @return
   */
  public List < Integer > inorderTraversal1(TreeNode root) {
    List < Integer > res = new ArrayList< >();
    Stack< TreeNode > stack = new Stack < > ();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      res.add(curr.val);
      curr = curr.right;
    }
    return res;
  }


  public static void main(String[] args) {
    BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();

    TreeNode node1 = btit.new TreeNode(1);
    TreeNode node2 = btit.new TreeNode(2);
    TreeNode node3 = btit.new TreeNode(3);

    node1.right = node2;
    node2.left = node3;

    List<Integer> list = btit.inorderTraversal1(node1);

    btit.print(list);

  }

  public void print (List<Integer> list) {
    Assert.assertNotEquals(null, list);

    for (int i : list) {
      System.out.println(i + "  ");
    }
  }


  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
  }

}
