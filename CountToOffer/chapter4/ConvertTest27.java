package CountToOffer.chapter4;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个搜索二叉树，让你将其转换为一个双向链表
*   Module Name: 解题思路：
*               1：我们知道对于一个二叉搜索树而言它的中序遍历结果就是有序的
*               2：按照二叉树中序遍历的结果，我们采用递归的方式每一次向链表中加入一个节点记作lastNodeInList
*               3：不断更新currentNode和LastNodeInList两个节点的信息。
*  Date Created: 2018-02-17
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-17     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

public class ConvertTest27 {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int v){
            this.value = v;
        }
    }
    public static TreeNode convert(TreeNode root) {
        TreeNode lastNodeInList = null;
        convertNode(root, lastNodeInList);
        if (lastNodeInList == null) {
            System.out.println("lastNodeInList == null");
        }
        TreeNode listHead = lastNodeInList;
        while (listHead != null && listHead.left != null) {
            listHead = listHead.left;
        }
        return listHead;
    }
    private static void convertNode(TreeNode node, TreeNode lastNodeInList) {
        if(node == null){
            return;
        }
        TreeNode currentNode = node;
        if(currentNode.left != null) {
            convertNode(currentNode.left, lastNodeInList);
        }
        currentNode.left = lastNodeInList;
        if(lastNodeInList != null){
            lastNodeInList.right = currentNode;
        }
        lastNodeInList = currentNode;
        if(lastNodeInList != null){
            System.out.println("Set last = " + lastNodeInList.value);
        }else{
            System.out.println("Set last = null");
        }
        if(currentNode.right != null){
            convertNode(currentNode.right, lastNodeInList);
        }
    }
    public static TreeNode convert1(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode lastNodeInlist = null;
        convertNode1(root,lastNodeInlist);
        if (lastNodeInlist == null) {
            System.out.println("lastNodeInList == null");
        }
        TreeNode listHead = lastNodeInlist;
        while(listHead!=null && listHead.left!=null){
            listHead = listHead.left;
        }
        return  listHead;
    }
    public static void  convertNode1(TreeNode root,TreeNode lastNodeInList){
        if(root == null){
            return;
        }
        TreeNode currentNode = root;
        if(currentNode.left!=null){
            convertNode1(root.left, lastNodeInList);
        }
        if(lastNodeInList != null){
            lastNodeInList.right = currentNode;
        }
        lastNodeInList = currentNode;
        if(lastNodeInList !=null){
            System.out.println("Set Last = "+lastNodeInList.value);
        }else{
            System.out.println("Set last = null");
        }
        if(currentNode.right != null){
            convertNode1(root.right,lastNodeInList);
        }

    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        TreeNode node6 = new TreeNode(6);
        TreeNode node14 = new TreeNode(14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node12 = new TreeNode(12);
        TreeNode node16 = new TreeNode(16);

        root.left = node6;
        root.right = node14;

        node6.left = node4;
        node6.right = node8;

        node14.left = node12;
        node14.right = node16;

        TreeNode head = convert1(root);
        if(head == null){
            System.out.println("head == null");
        }
        TreeNode node = head;
        while(node != null){
            System.out.println(node.value);
            node = node.right;
        }

    }
}
