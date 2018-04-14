package chapter5;

import CountToOffer.chapter1.ListNode;

public class findTheFirstCommonNode37 {
    public ListNode getTheFirstCommonNode(ListNode head1,ListNode head2){
        if(head1 == null || head2 == null){
            return null;
        }
        int len1 = getLen(head1);
        int len2 = getLen(head2);
        ListNode headT1 = head1,headT2 = head2,firstMoveNode = null;
        if(len1>len2){
            firstMoveNode = headT1;
        }else{
            firstMoveNode = headT2;
        }
        for(int i =1;i<=Math.abs(len1-len2);i++){
            firstMoveNode = firstMoveNode.next;
        }
        if(len1>len2){
            while(headT2!=firstMoveNode){
                headT2 = headT2.next;
                firstMoveNode = firstMoveNode.next;
            }
        }else{
            while(headT1!=firstMoveNode){
                headT1 = headT1.next;
                firstMoveNode = firstMoveNode.next;
            }
        }
        return firstMoveNode;
    }
    public int getLen(ListNode head){
        int count =1;
        while(head!=null){
            head = head.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode headNode1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        headNode1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode headNode2 = new ListNode(10);
        ListNode node6 = new ListNode(11);
        ListNode node7 = new ListNode(12);
        ListNode node8 = new ListNode(13);
        headNode2.next = node6;
        node6.next =node7;
        node7.next = node3;
        findTheFirstCommonNode37 ftfcn = new findTheFirstCommonNode37();
        ListNode node = ftfcn.getTheFirstCommonNode(headNode1,headNode2);
        System.out.println(node.val);
    }

}
