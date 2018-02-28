package CountToOffer.chapter6;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一颗二叉树，让你判断这颗二叉树是否是一颗平衡二叉树
*               解决方式：
*               1：直接获取根节点的左右子树的深度然后判断左右子树深度相差是否超过1
*               2：利用二叉树的后序遍历，一边获取二叉树深度的同时一边判断这颗二叉树是否是一颗平衡二叉树。
*   Module Name: 
*  Date Created: 2018-02-24
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-24     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import sun.reflect.generics.tree.Tree;

public class isBalanceTree39_1 {
    public boolean isBalanceTree(TreeNode node){
        if(node == null){
           return true;
        }
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        int diff = left-right;
        if(Math.abs(diff)>1){
            return false;
        }
        return true;
    }
    public int getDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        return Math.max(left,right)+1;
    }


    boolean isBalance = true;
    public boolean isBalance_solution(TreeNode node){
        TreeDepth(node);
        return isBalance;
    }
    public int TreeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if(Math.abs(left-right)>1){
            isBalance = false;
            return -1;
        }
        return Math.max(left,right)+1;
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        isBalanceTree39_1 isBT  = new isBalanceTree39_1();
        boolean isflag = isBT.isBalanceTree(node1);
        System.out.println(isflag);
        boolean isflag1 = isBT.isBalance_solution(node1);
        System.out.println(isflag1);


    }
}
