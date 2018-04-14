package TheArtOfProgramming.chapter1String;

import CountToOffer.chapter1.ListNode;

import java.util.Arrays;

/**
 * program:
 * description: 字符串旋转:时间复杂度O（n） 空间复杂度O（n） ；三次旋转即可完成
 * author: chenpeng
 * create: 2018/4/7:上午11:23
 **/
public class rotateString1 {
    public void rotateString(char[] arr,int index){
        if(arr==null || index<=0){
            return;
        }
        reverse(arr,0,index-1);
        reverse(arr,index,arr.length-1);
        reverse(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public void reverse(char[] arr,int start,int end){
        while(start<end){
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    /**
     * program:
     * description: 给定一个链表头节点和一个数字k，让你将这这个的1-k和k-end两段链表分别逆序
     * author: chenpeng
     * create: 2018/4/7:上午11:57
     **/
    public ListNode reverseK(ListNode head,int k){
        ListNode fHead = head,secondNode=null;
        for(int i =1;i<k;i++){
          fHead = fHead.next;
        }
        secondNode = fHead.next;
        fHead.next = null;
        ListNode returnHead = reverse(head);
        ListNode sreturnNode = reverse(secondNode);
        ListNode returnHeadC = returnHead;
        while(returnHeadC.next!=null){
          returnHeadC = returnHead.next;
        }
        returnHeadC.next = sreturnNode;
        return returnHead;
    }
    public ListNode reverse(ListNode head){
        if(head == null){
            return head;
        }
        ListNode pre = head;
        ListNode current = head.next;
        ListNode next = null;
        pre.next = null;
        while(current!=null){
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
    public static void main(String[] args) {
        rotateString1 rtts = new rotateString1();
        rtts.rotateString("abcde".toCharArray(),2);
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
        node6.next = node7;
        ListNode res = rtts.reverseK(node1,2);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
