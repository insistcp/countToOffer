package CountToOffer.chapter6;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个数组，让你判断这个数组所有的元素是否能够构成一个顺子
*   Module Name: 解题思路：先将数组进行排序，拍完序之后统计间隔次数和统计0出现的次数
*  Date Created: 2018-02-25
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-25     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import java.util.Arrays;

public class isShunzi44 {
    public boolean is_shunzi(int[] arr){
        Arrays.sort(arr);
        int len = arr.length;
        int countZero  = 0;
        int countDis = 0;
        for(int i = 0;i<len;i++){
            if(arr[i] == 0){
                countZero++;
            }else if(i>0){
                if(arr[i]-arr[i-1]==0){
                    return false;
                }else if(arr[i]-arr[i-1]>1){
                    countDis += (arr[i]-arr[i-1]-1);
                }
            }
        }
        if(countDis>countZero){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        isShunzi44 sz = new isShunzi44();
        int[] test = {0,0,1,2,3,4,5,6,7,8,10,12,14,0};
        boolean flag = sz.is_shunzi(test);
        System.out.println(flag);
    }
}
