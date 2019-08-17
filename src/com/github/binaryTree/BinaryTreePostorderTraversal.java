package com.github.binaryTree;

import com.github.binaryTree.BinaryTreeInorderTraversal.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

  /**
   * 后序遍历
   * @param root
   * @return
   */
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    postorder(root, list);
    return list;
  }

  public void postorder(TreeNode root, List<Integer> list) {
    if(null != root) {
      if (null != root.left) {
        postorder(root.left, list);
      }
      if (null != root.right) {
        postorder(root.right, list);
      }
      list.add(root.val);
    }
  }


  /**
   * time : O(n)
   * space: O(n)
   * @param root
   * @return
   */
  public List<Integer> lastorder(TreeNode root) {
    LinkedList<Integer> list = new LinkedList<>();
    if (null == root) {
      return list;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      list.addFirst(cur.val);
      if (cur.left != null) {
        stack.push(cur.left);
      }
      if (cur.right != null) {
        stack.push(cur.right);
      }
    }
    return list;
  }

}
