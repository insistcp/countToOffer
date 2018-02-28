package CountToOffer.chapter5;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个数组，计算这个数组中有多少个逆序数组对
*   Module Name: 解题思路：使用归并排序的思想先将数组进行分割，直至每一个数组只剩下一个元素为止。然后开始合并数组。
*   使用一个全局变量来记录当前的所有可能的数组对。
*  Date Created: 2018-02-21
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-21     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import java.util.Arrays;

public class theNumberOfReverse36 {
    public static int count = 0;
    public static void mergeArray(int[] arr,int first,int mid,int last,int[] temp){
        int i = first ,j = mid+1;
        int m = mid,n=last;
        int k =0;
        while(i<=m &&j<=n){
            if(arr[i]>arr[j]){
                temp[k++] = arr[j++];
                count+=mid-i+1;
            }else{
                temp[k++] = arr[i++];
            }
        }
        while(i<=m){
            temp[k++] = arr[i++];
        }
        while(j<=n){
            temp[k++] = arr[j++];
        }
        for(i = 0 ;i<k;i++){
            arr[first+i] = temp[i];
        }
    }
    public static void mergeSort(int[] arr,int first,int last,int[] temp){
        if(first<last){
            int mid = (first+last)/2;
            mergeSort(arr,first,mid,temp);
            mergeSort(arr,mid+1,last,temp);
            mergeArray(arr,first,mid,last,temp);
        }
    }
    public static void mergeSort(int[] arr){
        int[] p = new int[arr.length];
        mergeSort(arr,0,arr.length-1,p);
    }

    public static void mergeA(int[] test){
        int len  = test.length;
        int[] temp = new int[len];
        mergeDivided(0,len-1,test,temp);
    }
    public static void mergeDivided(int first,int last,int[] source,int[] tmp){
        if(first>=last){
            return;
        }
        int mid = (first+last)/2;
        mergeDivided(first, mid, source, tmp);
        mergeDivided(mid+1,last,source,tmp);
        merge(first,mid,last,source,tmp);
    }
    public static void merge(int first,int mid,int last,int[] source,int[] tmp){
        int i = first,j = mid+1;
        int m = mid,n = last;
        int k = 0;
        while(i<=m && j<=n){
            if(source[i]>source[j]){
                tmp[k++] = source[j++];
                count += mid-i+1;
            }else{
                tmp[k++] = source[i++];
            }
        }
        while(i<=m){
            tmp[k++] = source[i++];
        }
        while(j<=n){
            tmp[k++] = source[j++];
        }
        for(i = 0;i<k;i++){
            source[first+i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        theNumberOfReverse36 tNOR = new theNumberOfReverse36();
        int[] test = {7,5,6,4};
        tNOR.mergeA(test);
        System.out.println(Arrays.toString(test));
        System.out.println(theNumberOfReverse36.count);
    }
}
