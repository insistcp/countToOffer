package reviewCountToOffer.Chapter4;

import reviewCountToOffer.TreeNode;

/**
 * 将树转化为双向链表：采用中序遍历的原则；在左右两个节点的中间做操作；
 * 分别使用两个指针来标记当前遍历的最后一个指针和当前的指针；
 * Created by cp on 2018/3/31.
 */
public class convertTreeToChain27 {
    public TreeNode convert(TreeNode head){
        if(head == null){
            return head;
        }
        TreeNode tailNode = null;
        convertT(head,tailNode);
        while(tailNode!=null && tailNode.left!=null){
            tailNode = tailNode.left;
        }
        return tailNode;
    }
    public void convertT(TreeNode head,TreeNode tailNode){
        if(head ==null){
            return ;
        }
        TreeNode currentNode = head;
        if(currentNode.left!=null){
            convertT(currentNode.left,tailNode);
        }
        currentNode.left = tailNode;
        if(tailNode!=null){
            tailNode.right = currentNode;
        }
        tailNode = currentNode;
        if(currentNode.right!=null){
            convertT(currentNode.right,tailNode);
        }
    }
}
