package CountToOffer.chapter6;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定两个节点，让你求解这两个节点的最大公共祖先
*   Module Name: 解题思路：分情况讨论
*  Date Created: 2018-02-25
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-25     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import sun.reflect.generics.tree.Tree;

import java.util.HashSet;
import java.util.Set;

public class getTheCommonFather50 {
    /**
     * 第一种情况：当给定的树一颗二叉搜索树时，
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    public TreeNode getCommonNode(TreeNode root,TreeNode node1,TreeNode node2){
        if(root == null || node1 == null || node2==null){
            return null;
        }
        if(node1.val<root.val && node2.val<root.val){
            return getCommonNode(root.left,node1,node2);
        }else if(node1.val>root.val && node2.val>root.val){
            return getCommonNode(root.right,node1,node2);
        }else{
            return root;
        }
    }

    /**
     * 第二种情况，当我们的树结构有除了根节点外其余节点都有指向父节点的指针时，寻找连个链表的第一个公共节点
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    public TreeNode1 getCommonNode1(TreeNode1 root,TreeNode1 node1,TreeNode1 node2){
        if(root == null || node1 == null || node2==null){
            return null;
        }
        int len1 = 0,len2 = 0;
        TreeNode1 tnode1 = node1,tnode2 = node2;
        while(tnode1!=null){
            tnode1 = tnode1.parent;
            len1++;
        }
        while(tnode2!=null){
            tnode2 = tnode2.parent;
            len2++;
        }
        if(len1>len2){
            for(int i = 1;i<=len1-len2;i++){
                node1 = node1.parent;
            }
        }else{
            for(int i = 1;i<=len2-len1;i++){
                node2 = node2.parent;
            }
        }
        while(node1!=node2){
            node1 = node1.parent;
            node2 = node2.parent;
        }
        return node1;
    }

    /**
     * 第三种情况：当这个二叉树是一颗普通的二叉树时，我们需要遍历这颗二叉树，对于每一个节点不断判断这个节点的孩子是否包含这两个节点。
     * @param parent
     * @param current
     * @param node1
     * @param node2
     * @return
     */
    public TreeNode getCommonNode2(TreeNode parent,TreeNode current,TreeNode node1,TreeNode node2){
        if(current == null || node1 == null || node2 ==null){
            return null;
        }
        if(isContainNodes(current,node1,node2)){
            if(isContainNodes(current.left,node1,node2)){
                return getCommonNode2(current,current.left,node1,node2);
            }else{
                return getCommonNode2(current,current.right,node1,node2);
            }
        }else{
            return parent;
        }

    }
    boolean isContainNodes(TreeNode node,TreeNode node1,TreeNode node2){
        Set<TreeNode> set = new HashSet();
        getAllNodes(node, set);
        return set.contains(node1) && set.contains(node2);
    }
    public void getAllNodes(TreeNode root,Set<TreeNode> set){
        if(root==null){
             return;
        }
        set.add(root);
        getAllNodes(root.left, set);
        getAllNodes(root.right, set);
    }
    public static void main(String[] args) {
        getTheCommonFather50 gtcf = new getTheCommonFather50();
        /*TreeNode1 node1 = new TreeNode1(5);
        TreeNode1 node2 = new TreeNode1(3);
        TreeNode1 node3 = new TreeNode1(7);
        TreeNode1 node4 = new TreeNode1(1);
        TreeNode1 node5 = new TreeNode1(4);
        TreeNode1 node6 = new TreeNode1(6);
        TreeNode1 node7 = new TreeNode1(8);
        TreeNode1 node8 = new TreeNode1(2);
        //TreeNode node9 = new TreeNode(9);
        node1.left = node2;
        node2.parent = node1;
        node1.right = node3;
        node3.parent = node1;
        node2.left = node4;
        node4.parent = node2;
        node2.right = node5;
        node5.parent = node2;
        node3.left = node6;
        node6.parent = node3;
        node3.right = node7;
        node7.parent = node3;
        node4.left = node8;*/
        //node8.parent = node4;
        //node4.right = node9;
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left =node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        TreeNode res = gtcf.getCommonNode2(node1,node1,node2,node5);
        System.out.println(res.val);
    }
}
class TreeNode1{
    public TreeNode1 left;
    public TreeNode1 right;
    public TreeNode1 parent;
    public int val;
    public TreeNode1(int val){
        this.val = val;
    }
}
