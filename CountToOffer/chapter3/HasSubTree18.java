package CountToOffer.chapter3;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product:题目描述：给定两个颗二叉树，让你判断其中一颗二叉树是否是另外一颗二叉树的子树。
*   Module Name: 解题思路：采用递归的方式。
*  Date Created: 2018-02-12
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-12     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/


public class HasSubTree18 {
    /**
     * 寻找第一个值相同的节点
     * @param root1
     * @param root2
     * @return
     */
    public boolean hasSubtree(TreeNode root1,TreeNode root2){
        boolean result = false;
        if(root1!=null && root2!=null){
            if(root1.val==root2.val){
                result = doseTree1hasTree2(root1,root2);
            }
            if(!result){
                result = hasSubtree(root1.left,root2);
            }
            if(!result){
                result = hasSubtree(root1.right,root2);
            }

        }
        return result;

    }

    /**
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean doseTree1hasTree2(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return doseTree1hasTree2(root1.left,root2.left) && doseTree1hasTree2(root1.right,root2.right);
    }

    public static void main(String[] args) {
        HasSubTree18 hsb = new HasSubTree18();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(3);
        node6.left = node7;
        node6.right= node8;
        boolean flag = hsb.hasSubtree(node1,node6);
        System.out.println(flag);
    }
}
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val =val;
    }
}