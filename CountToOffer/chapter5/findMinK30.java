package CountToOffer.chapter5;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个数组，让你寻找这个数组的最小的k个元素
*   Module Name: 解题思路：两种办法
*                        1：使用大顶堆的方式解决
*                           关键点：A：sink函数，B：由于下标从0开始我们的k值需要减去1
*                        2：使用快速排序算法的思想:每次返回index下标时我们就和k-1进行比较，如果大于k-1就把end设置为end-1;否则设置为start设置为index+1
*
*  Date Created: 2018-02-20
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-20     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import java.util.Arrays;

public class findMinK30 {
    public int partition(int[] arr,int left,int right){
        int res  = arr[left];
        if(left>right){
            return -1;
        }
        while(left < right){
            while(left < right && arr[right]>=res){
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left]<=res){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = res;
        return left;
    }
    public int[] getLeastNumbers(int[] input,int k){
        if(input.length == 0 || k<=0){
            return null;
        }
        int[] output = new int[k];
        int start = 0;
        int end = input.length-1;
        int index = partition(input,start,end);
        while(index != k-1){
            if(index>k-1){
                end = index-1;
                index = partition(input,start,end);
            }else{
                start = index+1;
                index = partition(input,start,end);
            }
        }
        for(int i=0;i<k;i++){
            output[i] = input[i];
        }
        return output;
    }




    public void formKTree(int[] arr,int k){
        if(arr.length<k){
            return;
        }
        k = k-1;
        for(int i = 0;i<k/2;i++){
            sink(arr,i,k);
        }
        for(int i = k+1;i<arr.length;i++){
            if(arr[i]<arr[0]){
                exchange(arr,i,0);
                sink(arr,0,k);
            }
        }
    }
    public void sink(int[] test,int k,int N){
        while(2*k<=N){
            int j = 2*k;
            if(j<N && (test[j]<test[j+1])){
                j++;
            }
            if(test[j]<=test[k]){
                break;
            }
            exchange(test,j,k);
            k = j;
        }

    }
    public void exchange(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        findMinK30 fdM = new findMinK30();
        int[] test = {9,1,2,3,4,5,6,7};
        int[] res = fdM.getLeastNumbers(test,3);
        System.out.println(Arrays.toString(res));
    }
}
