package com.github.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementinaBST {

  /**
   * 中序遍历，time：O(n)
   * @param root
   * @param k
   * @return
   */
  public int kthSmallest(TreeNode root, int k) {
    List<Integer> list = new ArrayList<>();
    inorder(root, list);
    if (!list.isEmpty() && (k - 1) >= 0 && (k - 1) < list.size()) {
      return list.get(k -1);
    }
    return -1;
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

  /**
   * Time complexity : O(H+k), where HH is a tree height. This complexity is defined by the stack, which contains at least H+k elements,
   *  since before heading to pop out one has to go down to a leaf. This results in O(logN+k) for the balanced tree and O(N+k) for completely unbalanced tree with all the nodes in the left subtree.
   * Space complexity : O(H+k), the same as for time complexity, O(N+k) in the worst case, and O(logN+k) in the average case.
   * @param root
   * @param k
   * @return
   */
  public int kthSmallest1(TreeNode root, int k) {
    Stack< TreeNode > stack = new Stack < > ();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      if (--k == 0) {
        return curr.val;
      }
      curr = curr.right;
    }
    return -1;
  }


  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
  }

  public static void main(String[] args) {
    KthSmallestElementinaBST kse = new KthSmallestElementinaBST();

    TreeNode node1 = kse.new TreeNode(3);
    TreeNode node2 = kse.new TreeNode(1);
    TreeNode node3 = kse.new TreeNode(4);
    TreeNode node4 = kse.new TreeNode(2);

    node1.left = node2;
    node1.right = node3;

    node2.right = node4;

    System.out.println(kse.kthSmallest(node1, 1));
    System.out.println(kse.kthSmallest1(node1, 1));
  }

}
