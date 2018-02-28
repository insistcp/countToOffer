package CountToOffer.chapter3;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定两个有序链表现在让你合并这两个有序链表
*   Module Name: 集体思路：先去丁头结点，然后一个接单一个节点的对比每次选择较小的节点合入。
*  Date Created: 2018-02-11
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-11     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

public class MergeChain17 {
    public ListNode mergerNode(ListNode head1,ListNode head2){
        if(head1==null){
            return head2;
        }else if(head2 == null){
            return head1;
        }
        ListNode returnHead  = null;
        if(head1.val<head2.val){
            returnHead = head1;
            returnHead.next = mergerChain(head1.next,head2);
        }else{
            returnHead = head2;
            returnHead.next = mergerChain(head1,head2.next);
        }
        return returnHead;
    }
    public ListNode mergerChain(ListNode node1,ListNode node2){
        if(node1 ==null && node2==null){
            return node1;
        }
        if(node1==null){
            return node2;
        }
        if(node2==null){
            return node1;
        }
        ListNode finalNode;
        if(node1.val<node2.val){
            finalNode = node1;
            node1 = node1.next;
            finalNode.next =null;
        }else{
            finalNode = node2;
            node2 = node2.next;
            finalNode.next =null;
        }
        ListNode returnNode = finalNode;
        while(node1!=null && node2!=null){
            if(node1.val<node2.val){
                finalNode.next = node1;
                finalNode = finalNode.next;
                node1 = node1.next;
            }else{
                finalNode.next = node2;
                finalNode = finalNode.next;
                node2 = node2.next;
            }
        }
        if(node1!=null){
            finalNode.next = node1;
        }
        if(node2!=null){
            finalNode.next = node2;
        }
        return returnNode;
    }
    public void printNode(ListNode node){
        while(node!=null){
            System.out.println(node.val);
            node= node.next;
        }
    }
    public static void main(String[] args) {
        MergeChain17 mc = new MergeChain17();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node5.next = node6;
        node6.next= node7;
        node7.next = node8;
        ListNode res = mc.mergerNode(node1, node5);
        mc.printNode(res);
    }
}
