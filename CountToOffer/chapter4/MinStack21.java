package CountToOffer.chapter4;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：实现一个堆，利用这个堆可以通过getMin函数获取到堆中的最小中
*   Module Name: 解题思路：两个栈实现，一个占用来存数据，一个栈用来记录当前栈堆里面的最小值
*  Date Created: 2018-02-13
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-13     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import chapter1.Stack;
import leetCode.ListNode;

public class MinStack21 {
    public Stack<ListNode> dataStack = new Stack();
    public Stack<ListNode> helpStack = new Stack<ListNode>();
    public ListNode pop(){
        if(dataStack.size()>0){
            helpStack.pop();
            return dataStack.pop();
        }
        return null;
    }
    public void push(ListNode node){
        dataStack.push(node);
        if(helpStack.size() == 0){
            helpStack.push(node);
            return;
        }
        ListNode tnode = helpStack.pop();
        if(tnode.val>node.val){
            helpStack.push(tnode);
            helpStack.push(node);
        }else{
            helpStack.push(tnode);
            helpStack.push(tnode);
        }
    }
    public ListNode getMin(){
        if(dataStack.size()>0){
            return helpStack.pop();
        }
        return null;
    }
}
