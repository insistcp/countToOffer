package CountToOffer.chapter2;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：统计一个数字统计这个数字转换成二进制之后的1的个数
*       考虑到负数：我们设置一个标记flag =1 让其不断的移动（每次向做移动一位）并和待统计的数字进行比较。
*   Module Name: 
*  Date Created: 2018-02-07
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-07     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

public class CountOneNum10 {
    public int getOne(int n){
        System.out.println(Integer.toBinaryString(n));
        int res = 0;
        boolean flag = false;
        if(n<0){
            n =-n;
            flag = true;
        }
        while(n!=0){
            if((n & 1) == 1){
                res++;
            }
            n = n >> 1;
        }
        if(flag){
            res = 32-res;
        }
        return res;
    }
    public int getOne1(int n){
        System.out.println(Integer.toBinaryString(n));
        int res = 0;
        int flag =1;
        while(flag!=0){
            if((n & flag)!=0){
                res++;
            }
            flag = flag << 1;
            System.out.println(Integer.toBinaryString(flag));
        }

        return res;
    }

    /**
     *  对n每一次减去1，其从右边起第一个1变为0，该位后面的值不变，所以我们每次减一之后和n本身做&操作，就相当于消除了一个1；
     * @param n
     * @return
     */
    public int getOne2(int n){
        int count = 0;
        while(n!=0){
            count++;
            n = n &(n-1);
        }
        return count;
    }
    public static void main(String[] args) {
        CountOneNum10 con = new CountOneNum10();
        int res = con.getOne2(-100);
        System.out.println(res);
    }
}
