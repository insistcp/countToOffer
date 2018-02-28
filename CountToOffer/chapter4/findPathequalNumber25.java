package CountToOffer.chapter4;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一颗二叉树以及一个数字target，让你判断树种是否存在一条路径path
*       使得这条路径之和等于target.
*       解题思路：分三种情况，当前节点的值大于target,则移除
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

import java.util.ArrayList;
import java.util.List;

public class findPathequalNumber25 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> getPaths(TreeNode head,int target){

        if(head == null){
            return res;
        }

        if(head.val>target) {
            return res;

        }
        List<Integer> list =new ArrayList<Integer>();
        getPath(head,target,list);
        return res;

    }
    public void getPath(TreeNode node,int target,List<Integer> list){
        if(node == null){
            return;
        }
        if(node.val == target){
            list.add(node.val);
            List<Integer> tmp = new ArrayList<Integer>(list);
            res.add(tmp);
            list.remove(list.size()-1);
            return;
        }else if(node.val<= target) {
            list.add(node.val);
            getPath(node.left, target - node.val, list);
            getPath(node.right, target - node.val, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        findPathequalNumber25 fpn = new findPathequalNumber25();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        List<List<Integer>> res = fpn.getPaths(node1,2);
        for(List<Integer> list : res){
            for(Integer t:list){
                System.out.print(t);
            }
            System.out.println();
        }
    }
}
