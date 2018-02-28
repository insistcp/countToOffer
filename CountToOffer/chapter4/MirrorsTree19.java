package CountToOffer.chapter4;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 
*   Module Name: 
*  Date Created: 2018-02-12
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-12     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import CountToOffer.QueueToStack7_1;
import chapter1.Stack;
import chapter4.Search;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorsTree19 {
    public void getMirrors(TreeNode head){
        if(head==null){
            return;
        }
        TreeNode tmp = head.left;
        head.left = head.right;
        head.right = tmp;
        if(head.left!=null){
            getMirrors(head.left);
        }
        if(head.right!=null) {
            getMirrors(head.right);
        }
    }
    public void TraveralTree(TreeNode head){
        if(head==null){
            return;
        }
        Queue<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(head);
        while(!stack.isEmpty()){
            TreeNode node = stack.poll();
            System.out.println(node.val);
            if(node.left!=null){
                stack.add(node.left);
            }
            if(node.right!=null){
                stack.add(node.right);
            }
        }
    }
    public static void main(String[] args) {
        MirrorsTree19 mt = new MirrorsTree19();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        //node1.right = node3;
/*        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;*/
        mt.TraveralTree(node1);
        mt.getMirrors(node1);
        mt.TraveralTree(node1);
    }
}
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
