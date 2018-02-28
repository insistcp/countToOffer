package CountToOffer.chapter4;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定两个序列，其中第一个序列表示栈的入栈序列，让你判断 第二个序列是否是第一个序列的出栈序列。
*   Module Name: 解题思路：使用一个栈用来模拟两个序列的入栈和出栈顺序，外层循环用来循环出栈序列，向站里面按照入栈顺序放入元素，
*   直到遇到当前出栈元素，从栈中将改元素弹出，依次进行如此循环。知道当前入栈下标超过出栈序列的长度，或者栈中弹出的元素和当前出栈元素不相等为止。
*  Date Created: 2018-02-14
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-14     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import chapter2.InsertionSort;
import leetCode.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsStacOutOrder22 {
    public boolean isPopOrder(int[] inStack,int[] outStack){
        if(inStack==null || outStack==null){
            return false;
        }
        int ilen = inStack.length;
        int olen = outStack.length;
        if(ilen==0 || olen==0){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int start = 0;
        for(int i=0;i<ilen;i++){
            while (stack.isEmpty() || stack.peek() != outStack[i]){
                if(start>=olen){
                    return false;
                }
                stack.push(inStack[start++]);
            }
            if(stack.peek() != outStack[i]){
                return false;
            }
            stack.pop();
        }


        return true;
    }

    public static void main(String[] args) {
        IsStacOutOrder22  isoo = new IsStacOutOrder22();
        int[] inOrder = {1,2,3,4,5};
        int[] outOrder = {5,4,3,2,1};
        isoo.isPopOrder(inOrder,outOrder);
    }
}
