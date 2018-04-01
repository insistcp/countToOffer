package reviewCountToOffer.Chapter2;

import java.util.Stack;

/**
 * Created by cp on 2018/3/27.
 */
public class twoStackImpQueue7 {
    private Stack<Integer> stackI = new Stack();
    private Stack<Integer> stackO = new Stack();
    public void push(int number){
        stackI.push(number);
    }
    public Integer pop(){
        if(stackO.isEmpty()){
            while(!stackI.isEmpty()){
                stackO.push(stackI.pop());
            }
        }
        if(stackO.isEmpty()){
            new Throwable("已经没有元素了");
        }
        return stackO.pop();
    }

    public static void main(String[] args) {
        twoStackImpQueue7 tsq = new twoStackImpQueue7();
        tsq.push(1);
        tsq.push(2);
        tsq.push(3);
        tsq.push(4);
        tsq.push(5);
        System.out.println(tsq.pop());
        System.out.println(tsq.pop());
        System.out.println(tsq.pop());
        System.out.println(tsq.pop());
        System.out.println(tsq.pop());
        System.out.println(tsq.pop());
    }
}
