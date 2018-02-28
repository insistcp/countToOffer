package CountToOffer.chapter4;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个序列，让你判断这个序列是否是一颗二叉搜索树的后序遍历结果
*   Module Name: 解题思路：杜宇一棵树而言它的后序遍历结果种最后一个数字就是这颗二叉树的根节点。
*   从第一个节点开始所有比根节点小的节点都是根节点的左子树，第一个比根节点大的节点起都是根节点的右孩子节点。
*  Date Created: 2018-02-14
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-14     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

public class verifySquenceisBST {
    public boolean VerifySquenceOfBST(int[] squence,int start,int end){
        if(squence == null || end<=0){
            return false;
        }
        int root = squence[end-1];
        int i = 0;
        for(;i<end-1;++i){
            if(squence[i]>root){
                break;
            }
        }
        int j = i;
        for(;j<end-1;j++){
            if(squence[j]<root){
                return false;
            }
        }
        boolean left = true;
        if(i>0){
            left = VerifySquenceOfBST(squence,0,i);
        }
        boolean right = true;
        if(i<end-1){
            right = VerifySquenceOfBST(squence,i,end-i-1);
        }
        return left && right;
    }

    public static void main(String[] args) {
        verifySquenceisBST vsbst = new verifySquenceisBST();
        int[] test = {5,7,6,9,11,10,8,111};
        int[] test1 = {7,4,6,5};
        boolean res = vsbst.VerifySquenceOfBST(test1,0,4);
        System.out.println(res);
    }
}
