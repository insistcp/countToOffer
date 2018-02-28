package CountToOffer.chapter4;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 问题描述：复制复杂链表，所谓的复杂链表指的是链表有两个指针，
*       一个指针指向下一个节点，另外一个指针指向未知节点。
*       解题思路：
*       分三步走：
*       第一步：先复制链表节点将每一个节点复制一份然后直接连接到该节点后面。
*       第二步：将链表的pSibling指针指向链表的复制复制对应的节点中，
*       第三步：切断链表之间多余的连接。
*   Module Name: 
*  Date Created: 2018-02-15
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-15     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

public class CopyComplexListTest {
    static class Node{
        int value;
        Node next;
        Node sbiling;
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("value="+value);
            sb.append(",next = "+(next==null ? "null" : next.value));
            sb.append(",sbiling = "+(sbiling == null?"null" :sbiling.value));
            return sb.toString();
        }
     }

    public static  void copyList (Node head){
        Node node = head;
        while(node != null){
            //复制节点
            Node copyNode = new Node();
            copyNode.value = node.value;
            copyNode.next = node.next;
            copyNode.sbiling = null;
            node.next = copyNode;
            //更新到下一个节点
            node = copyNode.next;
        }
    }
    public static void setSbiling(Node head){
        Node node = head;
        while(node!=null){
            Node copyNode =node.next;
            if(node.sbiling != null){
                copyNode.sbiling = node.sbiling.next;
            }
            node = copyNode.next;
        }
    }
    public static Node disConnextList(Node head){
        Node node = head;
        Node copyHead = null;
        Node copyNode = null;
        if(node != null){
            copyHead = node.next;
            copyNode = node.next;
            node.next = copyNode.next;
            node = node.next;
        }
        while(node != null){
            copyNode.next = node.next;
            copyNode = copyNode.next;
            node.next = copyNode.next;


            node = node.next;
        }
        return copyHead;
    }
    public static Node copy(Node head){
        copyList(head);
        setSbiling(head);
        return disConnextList(head);
    }
    public static void main(String[] args) {

        Node head = new Node();
        head.value = 1;

        Node node2 = new Node();
        node2.value = 2;

        Node node3 = new Node();
        node3.value = 3;

        Node node4 = new Node();
        node4.value = 4;

        Node node5 = new Node();
        node5.value = 5;

        head.next = node2;
        head.sbiling = node3;

        node2.next = node3;
        node2.sbiling = node5;

        node3.next = node4;

        node4.next = node5;
        node4.sbiling = node2;

        Node copyHead = copy(head);

        Node node = copyHead;
        while(node != null){
            System.out.println(node);
            node = node.next;
        }

    }
}
