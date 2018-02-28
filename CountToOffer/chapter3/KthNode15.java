package CountToOffer.chapter3;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：查找链表的倒数第k个元素
*   Module Name: 解题思路：设置两个指针，第一个指针比第二个指针先走k步
*  Date Created: 2018-02-11
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-11     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

public class KthNode15 {
    public ListNode getKthNode(ListNode head,int k){
        if(head==null|| k == 0){
            return null;
        }
        ListNode first = head,second = head;
        for(int i = 0;i<k-1;i++){
            if(first.next!=null){
                first = first.next;
            }else{
                return null;
            }
        }
        while(first.next!=null){
            first= first.next;
            second = second.next;
        }
        System.out.println(second.val);
        return second;
    }
    public void printNode(ListNode head){
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static void main(String[] args) {
        KthNode15 kn = new KthNode15();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next =  node7;
        kn.getKthNode(node1,5);
    }

}
