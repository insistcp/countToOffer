package reviewCountToOffer.Chapter3;

import ReviewDataStructure.ListNode;

/**
 * 在O（1）时间复杂度内删除某一个元素
 * Created by cp on 2018/3/28.
 */
public class deleteNodeformChain13 {
    public ListNode delete(ListNode head,ListNode node){
        if(head==null){
            return null;
        }
        if(node.next==null && head!=node){
            ListNode tmp = head;
            while(tmp.next!=node){
                tmp = tmp.next;
            }
            tmp.next = null;

        }else if(head.next ==null && head == node){
            head = null;
            node = null;

        }else {
            ListNode pre = node.next;
            node.val = pre.val;
            node.next = pre.next;

        }
        return head;
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
        deleteNodeformChain13 dnc = new deleteNodeformChain13();
        ListNode node = dnc.delete(node1,node6);
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
