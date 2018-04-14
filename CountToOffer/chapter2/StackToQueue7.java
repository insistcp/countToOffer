package CountToOffer.chapter2;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：使用两个栈实现一个队列。
*   Module Name: 一个栈作为添加元素的容器，另一个栈作为弹出元素的容器。
*  Date Created: 2018-02-07
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-07     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import java.util.Stack;

public class StackToQueue7 {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();
    public void add(Integer data){
        stack1.add(data);
    }
    public Integer pop(){
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        StackToQueue7 sq = new StackToQueue7();
        sq.add(1);
        sq.add(2);
        sq.add(3);
        sq.add(4);
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());
    }

}
