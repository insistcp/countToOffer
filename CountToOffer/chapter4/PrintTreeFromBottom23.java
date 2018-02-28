package CountToOffer.chapter4;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 
*   Module Name: 
*  Date Created: 2018-02-14
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-14     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import chapter1.Stack;
import chapter2.InsertionSort;
import leetCode.Feb6th.PalindromeLinkedList234;
import leetCode.Jan24th.PrintBinaryTree655;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeFromBottom23 {
    public void PrintTree(TreeNode tree){
        if(tree == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<Integer> stack = new Stack<Integer>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            stack.push(node.val);
            if(node.right!=null){
                queue.add(node.right);
            }
            if(node.left!=null){
                queue.add(node.left);
            }
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        PrintTreeFromBottom23 ptb = new PrintTreeFromBottom23();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
       // node3.right = node7;
        ptb.PrintTree(node1);
    }
}
