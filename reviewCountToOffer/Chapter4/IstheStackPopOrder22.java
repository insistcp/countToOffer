package reviewCountToOffer.Chapter4;

import java.util.Stack;

/**
 * Created by cp on 2018/3/30.
 */
public class IstheStackPopOrder22 {
    public boolean isPopOrder(int[] inOrder,int[] outOrder){
        if(inOrder==null || outOrder==null){
            return false;
        }
        int len = inOrder.length-1;
        int i = 0,j=0;
        Stack<Integer> stack = new Stack<>();
        while(i<=len&&j<=len){
            if(inOrder[i]!=outOrder[j]){
                stack.push(inOrder[i++]);
            }else{
                j++;
                i++;
                while(!stack.isEmpty() && stack.peek()==outOrder[j]){
                    stack.pop();
                    j++;
                }
            }
        }
        if(stack.isEmpty()){
           return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int[] intest = {1,2,3,4,2,3,1};
        int[] outtest = {1,2,3,4,1,2,3};
        IstheStackPopOrder22 ispo = new IstheStackPopOrder22();
        boolean flag = ispo.isPopOrder(intest,outtest);
        System.out.println(flag);
    }
}
