package CountToOffer.chapter5;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：先给出丑数的定义：只能够被2,3,5整除的数我们称之为丑数。现在让你求第n个丑数
*   Module Name: 解题思路：
*                   1:设置一个数从1开始一直不断加，知道找到第index个丑数，先给出判断一个数字是否为丑数的条件
*                   2：采用递推的方式，有已知的丑数推算出下一个丑数。
*  Date Created: 2018-02-21
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-21     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import java.util.ArrayList;
import java.util.List;

public class getUglyNumber34 {
    public int getUglyNumber(int n){
        int i = 0;
        int number = 0;
        while(i<n){
            number++;
            if(isUglyNumber(number)){
                i++;
                System.out.println(number);
            }
        }
        return number;
    }
    public boolean isUglyNumber(int number){
        while(number%2==0){
            number/=2;
        }
        while(number%3==0){
            number/=3;
        }
        while(number%5==0){
            number/=5;
        }
        return number==1 ? true:false;
    }
    public int getUglyNumber1(int index){
        if(index<=0){
            return 0;
        }
        int i2= 0,i3=0,i5 =0;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        while(list.size()<index){
            int num2 = list.get(i2)*2;
            int num3 = list.get(i3)*3;
            int num5 = list.get(i5)*5;
            int min = Math.min(num2,Math.min(num3,num5));
            list.add(min);
            if(min==num2){
                i2++;
            }
            if(min==num3){
                i3++;
            }
            if(min==num5){
                i5++;
            }
        }
        return list.get(list.size()-1);
    }
    public static void main(String[] args) {
        getUglyNumber34 gun = new getUglyNumber34();
        int res = gun.getUglyNumber(10);
        System.out.println(res);
    }
}
