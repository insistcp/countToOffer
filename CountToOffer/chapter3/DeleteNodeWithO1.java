package CountToOffer.chapter3;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product:  题目描述：给定一个链表的头结点，以及一个节点X让你在O(1)时间复杂度内将节点X删除
*       解题思路：转换角度，由于要在O(1)时间复杂度内将制定元素删除，使用遍历的方式肯定是不行的。
*       我们分为3种情况
*       1：要删除的节点在链表内部，我们只需要将删除节点的下一个节点复制给删除酒店就OK
*       2：要删除的节点时尾巴节点，此時我們呢需要將链表遍历一遍
*       3：要删除的链表只有一个节点同时要删除的节点就是该节点。
*       我们需要设置一个私有属性head,将这个head的值置为null即可。
*   Module Name: 
*  Date Created: 2018-02-11
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-11     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import java.util.List;

public class DeleteNodeWithO1 {
    private  ListNode head;
    public void deleteNode(ListNode head,ListNode node){
        if(head==null){
            return;
        }
        if(node.next!=null){
            ListNode tmp = node.next;
            node.next = tmp.next;
            node.val = tmp.val;
        }else if(head==node){
            this.head = null;
        }else {
            ListNode tNode = head;
            while(tNode!=null){
                if(tNode.next==node){
                    tNode.next = null;
                }
                tNode = tNode.next;
            }
        }
    }
    public void printListNode(ListNode head){
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        DeleteNodeWithO1 dnw = new DeleteNodeWithO1();
        dnw.head = node1;
        dnw.printListNode(dnw.head);
        dnw.deleteNode(dnw.head,node1);
        dnw.printListNode(dnw.head);
    }
}
class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
