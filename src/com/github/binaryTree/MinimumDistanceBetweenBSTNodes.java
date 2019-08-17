package com.github.binaryTree;

import java.util.LinkedList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes {

  Integer result;
  Integer prev;

  /**
   * O(n)
   * @param root
   * @return
   */
  public int minDiffInBST(TreeNode root) {
    result = Integer.MAX_VALUE;
    prev = null;
    inorder(root);
    return result;
  }

  public void inorder(TreeNode root) {
    if(root == null) return;
    inorder(root.left);
    if(prev !=  null){
      result = Math.min(result, root.val - prev);
    }
    prev = root.val;
    inorder(root.right);
  }


  public int minDiffInBST1(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    inorder(root, list);
    int result = 0;
    if (!list.isEmpty()) {
      int length = list.size();
      int min = list.get(length-1);
      for (int i = 0; i < list.size() && i + 1 < list.size(); i++) {
        int temp = list.get(i + 1) - list.get(i);
        if (temp < min) {
          min = temp;
        }
      }
      result = min;
      if (length -1 >=0 && length-2 >=0) {
        int minValue = list.get(length-1) - list.get(length-2);
        if (minValue < min) {
          min = minValue;
          return min;
        }
      }
    }
    return result;
  }

  public void inorder(TreeNode root, List<Integer> list) {
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


  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
  }

  public static void main(String[] args) {
    MinimumDistanceBetweenBSTNodes mdb = new MinimumDistanceBetweenBSTNodes();

    TreeNode node1 = mdb.new TreeNode(4);
    TreeNode node2 = mdb.new TreeNode(2);
    TreeNode node3 = mdb.new TreeNode(6);
    TreeNode node4 = mdb.new TreeNode(1);
    TreeNode node5 = mdb.new TreeNode(3);

    node1.left = node2;
    node2.left = node4;
    node2.right = node5;
    node1.right = node3;

    System.out.println(mdb.minDiffInBST(node1));

  }

}
