package reviewCountToOffer.Chapter2;

import ReviewDataStructure.ListNode;

import java.util.Stack;

/**
 * Created by cp on 2018/3/27.
 */
public class printChain5 {
    public void printTailToHead(ListNode head){
        if(head==null){
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        while(head!=null){
            stack.add(head);
            head = head.next;
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop().val);
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(12);
        ListNode node3 = new ListNode(13);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printChain5 pc = new printChain5();
        pc.printTailToHead(node1);
    }
}
