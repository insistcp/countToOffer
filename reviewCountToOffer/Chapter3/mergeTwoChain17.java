package reviewCountToOffer.Chapter3;

import ReviewDataStructure.ListNode;

/**
 * Created by cp on 2018/3/29.
 */
public class mergeTwoChain17 {
    public ListNode mergeList(ListNode node1,ListNode node2){
        if(node1==null){
            return node2;
        }
        if(node2==null){
            return node1;
        }
        ListNode returnNode;
        if(node1.val>node2.val){
            returnNode = new ListNode(node2.val);
            node2 = node2.next;
        }else{
            returnNode = new ListNode(node1.val);
            node1 = node1.next;
        }
        ListNode tmpnode = returnNode;
        while(node1!=null && node2!=null){
            if(node1.val>node2.val){
                tmpnode.next = new ListNode(node2.val);
                node2 = node2.next;
            }else{
                tmpnode.next = new ListNode(node1.val);
                node1 = node1.next;
            }
            tmpnode = tmpnode.next;
        }
        if(node1!=null){
            tmpnode.next = node1;
        }
        if(node2!=null){
            tmpnode.next = node2;
        }
        return returnNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(10);
        ListNode node3 = new ListNode(13);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(22);
        ListNode node6 = new ListNode(63);

        node1.next = node2;
        node2.next = node3;
        //node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        mergeTwoChain17 mtc = new mergeTwoChain17();
        ListNode res = mtc.mergeList(node1,node4);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
