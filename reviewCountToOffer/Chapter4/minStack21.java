package reviewCountToOffer.Chapter4;

import java.util.Stack;

/**
 * 维护一个包含min函数的栈；通过min函数获取当前栈中的最小的元素；我们利用一个辅助的栈来完成此操作；
 * Created by cp on 2018/3/29.
 */
public class minStack21 {
    private Stack<Integer> mainStack = new Stack<Integer>();
    private Stack<Integer> AuxiliaryStack = new Stack<Integer>();
    public int min = Integer.MAX_VALUE;
    public void push(Integer e){
        if(e<min){
           min = e;
        }
        mainStack.push(e);
        AuxiliaryStack.push(min);
    }
    public int pop(){
        AuxiliaryStack.pop();
        return mainStack.pop();
    }
    public int min(){
        return AuxiliaryStack.peek();
    }

    public static void main(String[] args) {
        minStack21 ms = new minStack21();
        for(int i=0;i<10;i++){
            ms.push(i);
        }
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.min());
    }
}
