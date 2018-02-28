package CountToOffer.chapter6;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定两个数字，让你不使用四運算法則計算這兩個數字的和
*                解题思路：利用二进制运算法则计算两个数相加1和0 0和1得1,1和1 0和0得0； 1和1还需要进位。
*                我们可以先对两个数做异或运算，然后然后再对连个树做与运算，并不断的将异或的结果赋值给number1
*                将&的结果赋值给number2;知道number2的值为0时终止。
*
*   Module Name: 
*  Date Created: 2018-02-25
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-25     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

public class getSumNoSize47 {
    public int twoNumberSum(int number1,int number2){
        int sum , carry ;
        do{
            System.out.println("number1= "+number1+"--"+Integer.toBinaryString(number1));
            System.out.println("number2= "+number2+"--"+Integer.toBinaryString(number2));
            sum = number1 ^ number2;
            carry = (number1 & number2) << 1;
            number1 = sum;
            number2 = carry;
        }while (number2 !=0);
        return number1;
    }

    public static void main(String[] args) {
        getSumNoSize47 gsns = new getSumNoSize47();
        int res = gsns.twoNumberSum(10,12);
        System.out.println(res);
        int t = 8 ^7;
        System.out.println(Integer.toBinaryString(8));


        System.out.println(Integer.toBinaryString(7));


        System.out.println(Integer.toBinaryString(t));
        int t1 = 8 & 7;

        System.out.println(Integer.toBinaryString(t1));
        System.out.println(t);
        System.out.println(t1);
    }
}
