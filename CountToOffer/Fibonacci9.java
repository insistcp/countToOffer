package CountToOffer;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：斐波那契数列的递归以及非递归实现
*   Module Name: 递归：递归函数自己调用自己。
*                 一般的递归：最后返回不会单纯是自己调用自己还添加了其他参数。
*                 尾递归中的最后返回的递归调用只能含有函数本身。
*  Date Created: 2018-02-07
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-07     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

public class Fibonacci9 {
    public int getFibo(int n){
        if(n<=0){
            return 0;
        }else if(n==1){
            return 1;
        }else {
            return getFibo(n-1) + getFibo(n-2);
        }
    }
    public long getFibo1(int n){
        if(n<=0){
            return 0;
        }
        return  getFibo12(n,1,1);
    }
    public long getFibo12(int n,long first,long second){
        if(n<=2){
            return second;
        }
        return getFibo12(n-1,second,first+second);
    }


    public int frogJump(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else{
            return frogJump(n-1)+frogJump(n-2);
        }
    }

    /**
     * 青蛙跳台阶，一次只可以跳1阶台阶或者2阶台阶。给定n阶台阶，问你有几种跳法
     * 思路：对于只有一阶只有一种跳法，两阶台阶就有2种跳法。对于n阶台阶，如果我们第一次跳一阶，剩下的台阶有f(n-1)种跳法，如果第一次跳2阶剩下的有f(n-2)种跳法。
     * 即：f(n) = f(n-1)+f(n-2)
     * @param n
     * @return
     */
    public int frogJumpTail(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else{
            return frogJumpTail(n, 1, 2);
        }

    }
    public int frogJumpTail(int n,int first,int second){
        if(n<=3){
            return first+second;
        }else{
            return frogJumpTail(n - 1, second, first + second);
        }
    }
    public static void main(String[] args) {
        Fibonacci9 fb = new Fibonacci9();
        for(int i=1;i<20;i++){
            long res = fb.frogJumpTail(i);
            System.out.println(res);
        }

    }
}
