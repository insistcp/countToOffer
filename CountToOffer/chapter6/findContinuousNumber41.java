package CountToOffer.chapter6;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个排序数组和一个target数字，让你找到一个连续的子数组使其和为target数字。
*                解题思路：设置两个指针small和big,由于连续数组的最低要求是两个数字，所以我们需要将small初始化为0，big初始化为1，
*                然后不断的移动两个坐标的位置，如果从small到big的和为target就将其打印出来。
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

public class findContinuousNumber41 {
    public void getContinuousNumber(int[] arr,int target){
        if(arr == null){
            return;
        }
        int small  = 0;
        int big = 1;
        int tres  = 0;
        while(small<=big && big<arr.length){
            tres = getResult(arr,small,big);
            if(tres == target){
                printResult(arr,small,big);
                big++;
            }else if(tres>target){
                small++;
            }else {
                big++;
            }
        }
    }
    public int getResult(int[] arr,int start , int end){
        int res = 0;
        for(int i = start;i<=end;i++){
            res+=arr[i];
        }
        return res;
    }
    public void printResult(int[] arr,int start , int end){
        for(int i = start;i<=end;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        findContinuousNumber41 fcn = new findContinuousNumber41();
        int[] test = {1,2,3,3,4,5,6,7,8,15};
        fcn.getContinuousNumber(test,3);
    }
}
