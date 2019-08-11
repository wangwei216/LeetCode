package com.demo.leetcode.LeetCode226_invertTree;

public class TreeNode {

    int val;
    TreeNode left;
     TreeNode right;

     TreeNode(int x) {
         val = x;
     }


    /*
    * 翻转一棵二叉树
    * 这里使用的是先序遍历，先序遍历主要是：
    *   中--->左--->右遍历
    * */
    public TreeNode invertTree(TreeNode root) {
        if(root != null){
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            return root;
        }else{
            return null;
        }
    }

    /*
    *   这里采用的是中序遍历的方式：
    *    左--->中--->右遍历
    *
    * */
    public TreeNode invertTree2(TreeNode root) {
        if(root != null){
            invertTree(root.left);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            //由于先进行交换了，所以这个root.left就是之前的right
            invertTree(root.left);

            return root;
        }else{
            return null;
        }
    }

}
