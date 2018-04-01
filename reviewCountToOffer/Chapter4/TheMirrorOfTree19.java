package reviewCountToOffer.Chapter4;

import reviewCountToOffer.TreeNode;

/**
 * Created by cp on 2018/3/29.
 */
public class TheMirrorOfTree19 {
    public void getMirror(TreeNode head){
        if(head==null || (head.left==null && head.right!=null)){
            return ;
        }
        TreeNode tmp = head.left;
        head.left = head.right;
        head.right = tmp;
        if(head.left!=null){
            getMirror(head.left);
        }
        if (head.right!=null) {
            getMirror(head.right);
        }
    }

    public void travelTree(TreeNode head){
        if(head == null){
            return;
        }
        System.out.print(head.val+"  ");
        travelTree(head.left);
        travelTree(head.right);
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
        node3.left = node6;
        TheMirrorOfTree19 tmot= new TheMirrorOfTree19();
        tmot.travelTree(node1);
        tmot.getMirror(node1);
        System.out.println();
        tmot.travelTree(node1);
    }
}
