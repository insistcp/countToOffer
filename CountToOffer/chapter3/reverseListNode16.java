package CountToOffer.chapter3;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目藐视：给定一个链表的头指针，返回该链表的逆序之后的头指针
*   Module Name: 解题思路：头插法
*  Date Created: 2018-02-11
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-11     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

public class reverseListNode16 {
    public ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        ListNode pre = head;
        ListNode curr = head.next;
        pre.next = null;
        while(curr!=null){
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }
    public ListNode reverse1(ListNode head){
        if(head == null){
            return null;
        }
        ListNode pre = head;
        ListNode curr = head;
        while(curr.next!=null){
            curr = curr.next;
            curr.next = pre;
        }
        return pre;
    }
    public void printNode(ListNode head){
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        reverseListNode16 rsln  = new reverseListNode16();
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
        rsln.printNode(node5);
        ListNode head = rsln.reverse(node5);
        System.out.println("=================");
        rsln.printNode(head);
    }
}
