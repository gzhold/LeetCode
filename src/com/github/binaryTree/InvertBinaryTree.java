package com.github.binaryTree;


import java.util.Stack;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class InvertBinaryTree {

    /**
     * invert binary tree
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }


    /**
     * Maximum Depth of Binary Tree
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left  = maxDepth(root.left);
        int right  = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }




    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        InvertBinaryTree bt = new InvertBinaryTree();
        TreeNode treeNode4 = bt.new TreeNode(4);

        TreeNode treeNode2 = bt.new TreeNode(2);
        TreeNode treeNode7 = bt.new TreeNode(7);
        TreeNode treeNode1 = bt.new TreeNode(1);
        TreeNode treeNode3 = bt.new TreeNode(3);
        TreeNode treeNode6 = bt.new TreeNode(6);
        TreeNode treeNode9 = bt.new TreeNode(9);

        treeNode4.left = treeNode2;
        treeNode4.right = treeNode7;

        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;

        treeNode7.left = treeNode6;
        treeNode7.right = treeNode9;

        TreeNode root = bt.invertTree(treeNode4);
        print(root);

        TreeNode temp = bt.new TreeNode(0);
        System.out.println(bt.maxDepth(temp));
    }


    public static void print(TreeNode root){

        if (root == null) {
            System.out.println("该树为null");
            return;
        }
        int level = 1;//从根节点第一层遍历
        Stack<TreeNode> stackOne = new Stack<>();//用来记录当前遍历的层结点
        stackOne.push(root);
        printTree(level,stackOne);
    }

    /**
     * 递归遍历整个树
     * @param level 当前树的层次
     * @param from 当前层的所有结点信息
     */
    public static void printTree(int level,Stack<TreeNode> from){
        if (from == null || from.empty()) {
            return;
        }

        //用来存储下一层所有结点的信息
        Stack<TreeNode> to = new Stack<>();

        System.out.print(level+" : ");
        //当前层次为奇数，从左向右遍历
        if (level %2 != 0) {
            while(!from.empty()){
                TreeNode node = from.pop();
                if (node != null) {
                    System.out.print(node.val+"\t");
                    if (node.left != null) {
                        to.push(node.left);
                    }
                    if (node.right != null) {
                        to.push(node.right);
                    }
                }
            }
        }else{

            //当前为偶数层，需要从右向左遍历
            while(!from.empty()){
                TreeNode node = from.pop();
                //当前节点不为null，或者不是叶子结点
                if (node != null) {
                    System.out.print(node.val+"\t");
                    if (node.right != null) {
                        to.push(node.right);
                    }
                    if (node.left != null) {
                        to.push(node.left);
                    }
                }
            }

        }

        System.out.println();
        //递归
        printTree(++level,to);
    }



}
