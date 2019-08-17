package com.github.binaryTree;

import com.github.binaryTree.CountCompleteTreeNodes.TreeNode;

public class Test {

  public static void main(String[] args) {
    CountCompleteTreeNodes cctn = new CountCompleteTreeNodes();

    TreeNode node1 = cctn.new TreeNode(1);
    TreeNode node2 = cctn.new TreeNode(2);
    TreeNode node3 = cctn.new TreeNode(3);
    TreeNode node4 = cctn.new TreeNode(4);
    TreeNode node5 = cctn.new TreeNode(5);
    TreeNode node6 = cctn.new TreeNode(6);

    node1.left = node2;
    node1.right = node3;

    node2.left = node4;
    node2.right = node5;

    node3.left = node6;

    System.out.println(getHeight(node1));
  }


  public static int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null) {
      return 1;
    }
    int height = 0;
    int nodesSum = 0;
    TreeNode curr = root;
    while (curr.left != null) {
      nodesSum += (1 << height);
      height++;
      curr = curr.left;
    }
//    System.out.println(nodesSum);
    return height;
  }


}
