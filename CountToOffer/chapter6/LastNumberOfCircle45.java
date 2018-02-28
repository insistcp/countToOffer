package CountToOffer.chapter6;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个数组组成一个circle(也可以将其看做为一个链表)和一个指定的下标，
*       现在让你每次从这个circle中移除一个元素（指定下标）让你计算最终剩下的元素是哪一个。
*       解题思路：利用链表的特有的性质来求解此题目。将所有的元素放到链表里面，然后用一个index来记录当前走的位置；使用循环（循环index步）的方式来求解此题目。
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

import java.util.LinkedList;
import java.util.List;

public class LastNumberOfCircle45 {
    public int getLastNumber(int[] arr,int tar){
        if(arr == null){
            return -1;
        }
        int len = arr.length;
        List<Integer> list = new LinkedList<Integer>();
        for(int i = 0;i<len;i++){
            list.add(arr[i]);
        }
        int index = 0;
        while(list.size()>1){
            for(int i = 1;i<tar;i++){
                if (index >= (list.size() - 1)) {
                    index = 0;
                } else {
                    index++;
                }
            }
            list.remove(index);
            for(Integer t:list){
                System.out.print(t + " ");
            }
            System.out.println();
        }
        return list.get(0);
    }


    public int getLastNumber(int n ,int m){
        if(n<1 || m < 1){
            return -1;
        }
        int last = 0;
        for(int i =2;i<=n;++i){
            last = (last+m)%i;
        }
        return last;
    }


    public static void main(String[] args) {
        LastNumberOfCircle45 lno = new LastNumberOfCircle45();
        int[] test = {1,2,3,4,5,6,7,8,9};
        int res = lno.getLastNumber(test,2);
        System.out.println(res);
    }

}
