package com.github.binaryTree;

import com.github.binaryTree.BinaryTreeInorderTraversal.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * 层次遍历
 */
public class BinaryTreeLevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> list = new LinkedList<>();
    dfs(root, list, 0);
    return list;
  }

  private void dfs(TreeNode root, List<List<Integer>> list, int level) {
    if (null == root) {
      return;
    }
    if (list.size() <= level) {
      list.add(new LinkedList<>());
    }
    list.get(level).add(root.val);
    dfs(root.left, list, level + 1);
    dfs(root.right, list, level + 1);
  }

}
