package reviewCountToOffer.Chapter3;

import ReviewDataStructure.ListNode;

/**
 * Created by cp on 2018/3/28.
 */
public class GetKthOftheChain15 {
    public ListNode getNode(ListNode head,int k){
        if(head == null){
            return null;
        }
        ListNode slow = head,fast = head;
        for(int i = 1;i<=k;i++){
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
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
        GetKthOftheChain15 gko = new GetKthOftheChain15();
        ListNode node = gko.getNode(node1,2);
        System.out.println(node.val);
    }
}
