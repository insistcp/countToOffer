package CountToOffer.chapter2;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：链表逆序
*   Module Name: 两种方式实现：
*           1：不改变链表的结构，头插法；需要两个记录点，currentNode,preNode;记住一点，首先我们需要先将头结点的下面一个节点获取到，然后将头结点的next置空。
*           依次遍历
*           2：不改变链表的结构，采用栈的数据结构。
*  Date Created: 2018-02-06
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-06     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import java.util.Stack;

public class printChainFromTail4 {
    public ListNode print(ListNode head){
        if(head == null){
            return head;
        }
        ListNode preNode = head;
        ListNode currentNode = head.next;
        head.next = null;
        while(currentNode!=null){
            ListNode tmp = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = tmp;
        }
        return preNode;
    }

    /**
     * 不改变原链表数据结构的方式
     */
    private Stack<ListNode> stack = new Stack<ListNode>();
    public void print1(ListNode head){
        if(head == null){
            return;
        }
        while(head!=null){
            stack.add(head);
            head = head.next;
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop().val);
        }
    }
    public void traversal(ListNode head){
        while(head != null){
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
            ListNode node7 = new ListNode(7);
            ListNode node8 = new ListNode(8);
            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node5;
            node5.next = node6;
            node6.next = node7;
            node7.next = node8;
            printChainFromTail4 pcf = new printChainFromTail4();
            //ListNode node = pcf.print(node8);
            pcf.print1(node1);
            //pcf.traversal(node);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}