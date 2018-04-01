package reviewCountToOffer.Chapter4;

import reviewCountToOffer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by cp on 2018/3/30.
 */
public class printTreeFromTop23 {
    public void printTree(TreeNode head){
        if(head == null){
            return;
        }
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(head);
        while(!stack.isEmpty()){
            TreeNode node = stack.poll();
            System.out.print(node.val+"  ");
            if(node.left!=null){
                stack.add(node.left);
            }
            if(node.right!=null) {
                stack.add(node.right);
            }
        }
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
        printTreeFromTop23 ptft =new printTreeFromTop23();
        ptft.printTree(node1);
    }

}
