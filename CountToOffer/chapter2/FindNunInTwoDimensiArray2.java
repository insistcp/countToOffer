package CountToOffer.chapter2;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product:题目描述：给定一个二维有序数组（行和列均有序）再给你一个target数字，让你判断这个数字在数组中是否存在。
*   Module Name: 集体思路：每次从右上角或者左下角开始查找，不断移动查找位置。
*  Date Created: 2018-02-05
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-05     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import leetCode.FindSmallestLetterGreaterThanTarget745;

public class FindNunInTwoDimensiArray2 {
    public boolean find(int[][] test,int target){
        if(test==null || test[0].length==0){
            return false;
        }
        int wlen  = test.length-1;
        int nlen = test[0].length-1;
        int i = wlen;
        int j = 0;
        while(i>=0 && j<=nlen){
            if(test[i][j]==target){
                return true;
            }else if(test[i][j]<target){
                j++;
            }else{
                i--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] test = {{1,2,3},{5,6,7},{8,9,10}};
        FindNunInTwoDimensiArray2 fta = new FindNunInTwoDimensiArray2();
        boolean flag = fta.find(test,2);
        System.out.println(flag);
    }
}

