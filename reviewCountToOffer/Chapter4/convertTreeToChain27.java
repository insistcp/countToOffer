package reviewCountToOffer.Chapter4;

import reviewCountToOffer.TreeNode;

/**
 * ����ת��Ϊ˫�������������������ԭ�������������ڵ���м���������
 * �ֱ�ʹ������ָ������ǵ�ǰ���������һ��ָ��͵�ǰ��ָ�룻
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
