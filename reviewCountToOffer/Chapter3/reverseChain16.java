package reviewCountToOffer.Chapter3;

import ReviewDataStructure.ListNode;

/**
 * Created by cp on 2018/3/28.
 */
public class reverseChain16 {
    public ListNode reverse(ListNode head){
        if(head==null){
            return head;
        }
        ListNode preNode = head;
        ListNode currentNode = head.next,NextNode;
        preNode.next = null;
        while(currentNode!=null){
            NextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = NextNode;
        }
        return preNode;
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
        reverseChain16 rc = new reverseChain16();
        ListNode res = rc.reverse(node6);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
