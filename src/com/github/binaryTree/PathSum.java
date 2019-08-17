package com.github.binaryTree;


import java.util.Stack;

/**
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum {

  /**
   * recursive solution
   * time : O(n)
   * @param root
   * @param sum
   * @return
   */
  public boolean hasPathSum(TreeNode root, int sum) {
    if (null == root) {
      return false;
    }
    if (root.left == null && null == root.right) {
      return root.val == sum;
    }

    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

  }

  public boolean hasPathSum1(TreeNode root, int sum) {
    Stack<TreeNode> stack = new Stack<>();
    Stack<Integer> sums = new Stack<>();

    stack.push(root);
    sums.push(sum);
    while (!stack.isEmpty() && root != null) {
      int value = sums.pop();
      TreeNode top = stack.pop();

      if (top.left == null && top.right == null && top.val == value) {
        return true;
      }
      if (top.right != null) {
        stack.push(top.right);
        sums.push(value - top.val);
      }
      if (top.left != null) {
        stack.push(top.left);
        sums.push(value - top.val);
      }

    }
    return false;
  }



  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) { val = x; }
  }


}
