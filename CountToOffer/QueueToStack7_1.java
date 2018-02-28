package CountToOffer;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：队列实现一个栈。
*   Module Name: 不断将一个队列中的元素弹出插入另一个队列中，直到队列中剩余一个元素。
*  Date Created: 2018-02-07
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-07     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack7_1<T> {
    private Queue<T> queue1 = new LinkedList<T>();
    private Queue<T> queue2 = new LinkedList<T>();
    public void add(T data){
        queue1.add(data);
    }
    public T pop(){
        if(queue1.size()==1){
            return queue1.poll();
        }else if(queue1.size()>1){
            while((queue1.size()!=1)){
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }else{
            if(!queue2.isEmpty()){
                while((queue2.size()!=1)){
                    queue1.add(queue2.poll());
                }
                return queue2.poll();
            }else{
                return null;
            }

        }
    }

    public static void main(String[] args) {
        QueueToStack7_1 qts =new QueueToStack7_1();
        qts.add(1);
        qts.add(2);
        qts.add(3);
        qts.add(4);
        System.out.println(qts.pop());

        System.out.println(qts.pop());

        System.out.println(qts.pop());

        System.out.println(qts.pop());

        System.out.println(qts.pop());
    }
}
