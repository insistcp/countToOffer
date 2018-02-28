package CountToOffer.chapter6;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个排序数组和target数字，现在让你统计这个target数字在这个数组中出现的次数。
*       解题思路：两种方式：
*           第一种：直接计算这个利用二分查找算法找到这个数字然后分别向左向右移动最终找到所有target数字
*           第二种：依旧是利用二分查找的思想分别找到该数字在数组中第一次出现的位置和最后一次出现的位置，然后做减法+1；
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

public class getTimesOfNumber38 {
    public int getFirstIndexOfArr(int[] arr,int target){
        if(arr == null){
            return -1;
        }
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int middle = (left+right)/2;
        while(left<=right){
            if(arr[middle] == target){
                if(middle==0 || arr[middle-1] != target){
                    return middle;
                }else{
                    right = middle-1;
                }
            }else if(arr[middle]>target){
                right = middle-1;
            }else {
                left = middle+1;
            }
            middle = (left+right)/2;
        }
        return -1;
    }
    public int getLastIndexOfArr(int[] arr,int target){
        if(arr == null){
            return -1;
        }
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int middle = (left+right)/2;
        while(left<=right){
            if(arr[middle] == target){
                if(middle == (len-1) || arr[middle+1] != target){
                    return middle;
                }else{
                    left = middle+1;
                }
            }else if(arr[middle]>target){
                right = middle-1;
            }else {
                left = middle+1;
            }
            middle = (left+right)/2;
        }
        return -1;
    }

    public static void main(String[] args) {
        getTimesOfNumber38 tn = new getTimesOfNumber38();
        int[] arr = {1,1,1,2,3,3,3,3,4,4,4,4,5,5,8};
        int firstIndex = tn.getFirstIndexOfArr(arr,5);
        int lastIndex = tn.getLastIndexOfArr(arr, 5);
        int times  = 0;
        if(firstIndex!=-1){
            times = lastIndex-firstIndex+1;
        }
        System.out.println(firstIndex+"=="+lastIndex+"===="+times);
    }
}
