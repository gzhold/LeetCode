package com.github.binaryTree;

import java.util.LinkedList;
import java.util.List;

public class CountCompleteTreeNodes {

  public int countNodes(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    inorder(root, list);
    return list.size();
  }

  public void inorder(TreeNode root, List<Integer> list) {
    if (null == root) {
      return;
    }
    inorder(root.left, list);
    list.add(root.val);
    inorder(root.right, list);
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
  }

  /**
   * Basically my solution contains 2 steps.
   * (1) Firstly, we need to find the height of the binary tree and count the nodes above the last level.
   * (2) Then we should find a way to count the nodes on the last level.
   *
   * Here I used a kind of binary search. We define the "midNode" of the last level as a node following the path "root->left->right->right->...->last level".
   *
   * If midNode is null, then it means we should count the nodes on the last level in the left subtree.
   *
   * If midNode is not null, then we add half of the last level nodes to our result and then count the nodes on the last level in the right subtree.
   *
   * Of course I used some stop condition to make the code more efficient, e.g. when a tree has height 1, it means it only has 3 cases: 1. has right son; 2. only has left son; 3. has no son.
   *
   * time: O((logN)^2)
   * The number of nodes in the last level vary from [1,2^d-1], binary search costs log(2^d-1)=d.
   * The traverse to find midNode costs O(d) time.
   * The whole time complexity is O(log(2^d-1)*d)=O(d^2)=O((logN)^2)
   * @param root
   * @return
   */
  public int countNodes1(TreeNode root) {
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
    return nodesSum + countLastLevel(root, height);
  }

  private int countLastLevel(TreeNode root, int height) {
    if (height == 1) {
      if (root.right != null) {
        return 2;
      } else if (root.left != null) {
        return 1;
      } else {
        return 0;
      }
    }

    TreeNode midNode = root.left;
    int currHeight = 1;
    while (currHeight < height) {
      currHeight++;
      midNode = midNode.right;
    }
    if (midNode == null) {
      return countLastLevel(root.left, height - 1);
    } else {
      return (1 << (height - 1)) + countLastLevel(root.right, height - 1);
    }
  }


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
    long head = System.nanoTime();
    System.out.println(cctn.countNodes(node1));
    long tail = System.nanoTime();
    System.out.println("time = " + (tail-head));

    System.out.println("------------------------");

    head = System.nanoTime();
    System.out.println(cctn.countNodes1(node1));
    tail = System.nanoTime();
    System.out.println("time = " + (tail-head));

  }


}
