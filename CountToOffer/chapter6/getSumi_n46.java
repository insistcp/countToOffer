package CountToOffer.chapter6;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product:问题描述：给定一个数字n让你求解从1-n所有的数字之和，要求不能够使用*\循环，if等语句
*               解题思路：利用递归的思想，从
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

public class getSumi_n46 {
    public int sum_get(int n){
        int sum = n;
        boolean b=(n==0) || (sum+=(sum_get(n-1))) >0;
        return sum;
    }

    public static void main(String[] args) {
        getSumi_n46 sum = new getSumi_n46();
        int res = sum.sum_get(10);
        System.out.println(res);
    }
}
