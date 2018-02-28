package CountToOffer.chapter3;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 
*   Module Name: 
*  Date Created: 2018-02-11
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-11     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import java.util.Arrays;

public class AdjustOrder14 {
    public int[] adjust(int[] arr){
        if(arr == null || arr.length==0){
            return arr;
        }
        int len = arr.length-1;
        int left = 0;
        int right = len;
        while(left<right){
            while(left<right && arr[left]%2!=0){
                left++;
            }
            while(left<right && arr[right]%2==0){
                right--;
            }
            if(left<right){
                exchange(arr,left,right);
            }

        }
        return arr;
    }
    public void exchange(int[] arr,int left,int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        AdjustOrder14 ajo = new AdjustOrder14();
        int[] test = {1,2,3,4,5,6,7,8,1,1,1,1};
        int[] res = ajo.adjust(test);
        System.out.println(Arrays.toString(res));
    }
}
