package CountToOffer.chapter5;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定两个链表，这两个链表存在公共节点，现在让你找到第一个重合的节点
*                解题思路：使用两个栈分别来存储这两个链表，（如果两个链表存在相同的元素那么从第一个相同元素开始往后的所有的元素都相同）
*   Module Name: 
*  Date Created: 2018-02-24
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-24     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import chapter1.Stack;
import leetCode.ListNode;

public class findTheFirstSameNode37 {
    /**
     * 使用两个栈分别存储两个链表的元素
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(m+n)
     * @param node1
     * @param node2
     * @return
     */
    public ListNode findfirstSameNode(ListNode node1,ListNode node2){
        if(node1 == null || node2 == null){
            return null;
        }
        Stack<ListNode> stack1  = new Stack<ListNode>();
        Stack<ListNode> stack2  = new Stack<ListNode>();
        while(node1 != null){
            stack1.push(node1);
            node1 = node1.next;
        }
        while(node2 != null){
            stack2.push(node2);
            node2 = node2.next;
        }
        ListNode listNode1 = stack1.pop();
        ListNode listNode2 = stack2.pop();
        if(listNode1 != listNode2){
            return null;
        }
        ListNode returnNode = listNode1;
        while(listNode1 == listNode2){
            returnNode = listNode1;
            listNode1 = stack1.pop();
            listNode2 = stack2.pop();
        }
        System.out.println(returnNode.val);
        return returnNode;
    }

    /**
     * 获取两个链表的长度len1,len2，对于较长的链表我们先走|len1-len2|步
     * 时间复杂度：O(n+m)
     * 空间复杂度O(1)
     * @param node1
     * @param node2
     * @return
     */
    public static ListNode getFistSameNode(ListNode node1,ListNode node2){
        if(node1 == null || node2 == null){
            return null;
        }
        int len1 = 0;
        ListNode tnode1 = node1;
        while(tnode1!=null){
            tnode1 = tnode1.next;
            len1++;
        }
        int len2 = 0;
        ListNode tnode2 = node2;
        while(tnode2!=null){
            tnode2 = tnode2.next;
            len2++;
        }
        if(len1>len2){
            for(int i=0;i<len1-len2;i++){
                node1 = node1.next;
            }
        }else{
            for(int i=0;i<len2-len1;i++){
                node2 = node2.next;
            }
        }
        while(node1!=node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        System.out.println(node1.val +"==="+node2.val);
        return node1;
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
        findTheFirstSameNode37 fTFSN = new findTheFirstSameNode37();
        ListNode node = fTFSN.getFistSameNode(headNode1, headNode2);
        System.out.println(node.val);
    }
}

