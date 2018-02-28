package CountToOffer.chapter6;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个二叉树让你求解该二叉树的深度
*   Module Name: 解题思路：使用递归的思路，不断获取左右子树的深度；最终获取到二叉树的总深度
*  Date Created: 2018-02-24
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-24     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/


public class getTreeDepth39 {
    public int getDepth(TreeNode head){
        if(head == null){
            return 0;
        }
        int left  = getDepth(head.left);
        int right = getDepth(head.right);
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
        node2.right = node3;
        node3.left = node4;
        node4.right = node5;
        node5.left = node6;
        getTreeDepth39 td = new getTreeDepth39();
        int depth = td.getDepth(node1);
        System.out.println(depth);
    }
}
class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    public TreeNode(int val){
        this.val = val;
    }
}

