package CountToOffer.chapter2;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个二叉树的中序遍历和现需遍历结构让你将这颗二叉树还原
*       解题思路:我们知道对于一颗二叉树而言，它的先序遍历结果第一个节点就是我们的根节点，而对中序遍历结果而言，凡是在根节点左边的都是根节点的左子树，根节点右边的都是根节点的右子树
*       遵从这个思路不断的循环。终止条件提前约定好。
*  Module Name:
*  Date Created: 2018-02-06
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-06     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

public class ReFormBanaryTree6 {
    public treeNode mainT(int[] headtraveral,int[] middleTravel){
        if(headtraveral==null || middleTravel == null){
            return null;
        }
        int len = headtraveral.length;
        treeNode res = form(headtraveral,middleTravel,0,headtraveral.length-1,0,middleTravel.length-1);
        return res;
    }
    public treeNode form(int[] headtraveral,int[] middleTravel,int hstart,int hend, int mstart,int mend){
        treeNode tree = new treeNode(headtraveral[hstart]);
        if(hstart == hend || mstart == mend){
            return tree;
        }
        tree.left = null;
        tree.right = null;
        int root = 0;
        for(root = mstart;root<mend;root++){
            if(middleTravel[root] == headtraveral[hstart]){
                break;
            }
        }
        int leftlen = root-mstart;
        int rightlen = mend-root;
        if(leftlen>0){
            tree.left = form(headtraveral,middleTravel,hstart+1,hstart+leftlen,mstart,root-1);
        }
        if(rightlen>0){
            tree.right = form(headtraveral,middleTravel,hstart+1+leftlen,hend,root+1,mend);
        }
        return tree;
    }
    public void inTraverseBinTree(treeNode head){
        if(head==null){
            return;
        }
        inTraverseBinTree(head.left);
        System.out.println(head.val);
        inTraverseBinTree(head.right);
    }
    public void postTraverseBinTree(treeNode head){
        if(head==null){
            return;
        }
        postTraverseBinTree(head.left);
        System.out.println(head.val);
        postTraverseBinTree(head.right);
    }

    public static void main(String[] args) {
        ReFormBanaryTree6 rf = new ReFormBanaryTree6();
    }
}
class treeNode{
    public int val;
    public treeNode left;
    public treeNode right;
    treeNode(int val){
        this.val = val;
    }
}
