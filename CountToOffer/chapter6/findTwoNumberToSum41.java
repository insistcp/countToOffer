package CountToOffer.chapter6;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 題目描述：給定一个排序数组和一个target数字让你找到两个数字和为target
*                解题思路：设置两个指针分别指向数组的头部和尾部，判断这两个数字的和如果小于target则移动左边指针
*   Module Name: 
*  Date Created: 2018-02-24
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-24     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import java.util.Arrays;

public class findTwoNumberToSum41 {
    public int[] getTwoNum(int[] arr,int target){
        if(arr == null){
            return null;
        }
        int[] res = new int[2];
        int left = 0;
        int right = arr.length-1;
        int sum = 0 ;
        boolean flag = false;
        while(left<right){
            sum  = arr[left]+arr[right];
            if(sum==target){
                flag = true;
                res[0] = arr[left];
                res[1] = arr[right];
                break;
            }else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        if(!flag){
            System.out.println("不存在呀");
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {1,2,2,3,4,5,6};
        findTwoNumberToSum41 ftn = new findTwoNumberToSum41();
        int[] res = ftn.getTwoNum(test,100);
        System.out.println(Arrays.toString(res));
    }

}
