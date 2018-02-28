package CountToOffer.chapter5;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个数组其中有一个数字的出现次数大于数组长度的一半，让你找出这个数字
*   Module Name: 解题思路：
*                   1：将整个数组进行排序，位于数组中间位置的元素就是待求数字
*                   2：由于这个数字的出现频率为数组长度的一半，其他所有数字出现之和小于这个数字出现的频率。
*                   我们可以设置一个count值和一个result值分别记录当前数字出现的频率和当前数字是什么。
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

public class findTheNumberMoreThanhalf29 {
    public void sort(int start,int end,int[] a){
        if(start>=end){
            return;
        }
        int point = Portion(start,end,a);
        sort(start,point-1,a);
        sort(point + 1, end, a);
    }
    /**
     * 根据分界点对元素进行分类，左边的元素统一小于分界点，右边的元素都大于分界点。
     * PS：一般我们将分界点定位第一元素。
     * @param low
     * @param heigh
     * @param a
     * @return
     */
    public int Portion(int low,int heigh,int[] a){
        int i=low,j=heigh+1;
        int p = a[low];
        while(true){
            while(a[++i]<p){
                if(i==heigh){
                    break;
                }
            }
            while(p<a[--j]){
                if(j==low){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            exchange(a,i,j);
        }
        exchange(a,low,j);
        return j;
    }
    public int getMaxHalf(int[] arr){
        int count = 1;
        int res = arr[0];
        int len = arr.length-1;
        for(int i =1;i<=len;i++){
            if(arr[i]==res){
                count++;
            }else if(count==0){
                res = arr[i];
                count = 1;
            }else{
                count--;
            }
        }
        return res;
    }

    public void exchange(int[] arr,int start,int end){
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }





    public void FastSort(int[] arr,int len,int start,int end){
        if(start >= end){
            return;
        }
        int index = Partion1(arr,len,start,end);
        if(index>start){
            FastSort(arr,len,start,index-1);
        }
        if(index<end){
            FastSort(arr,len,index+1,end);
        }
    }
    public int Partion1(int[] arr,int len,int start,int end){
        int i= start,j = end+1;
        int p = arr[start];
        while(true){
            while(arr[++i]<p){
                if(i == end){
                    break;
                }
            }
            while(arr[--j]>p){
                if(j ==start ){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            exchange(arr,i,j);
        }
        exchange(arr,start,j);
        return j;
    }
    public static void main(String[] args) {
        findTheNumberMoreThanhalf29 ftnmt = new findTheNumberMoreThanhalf29();
        int[] test = {1,2,2,2,2,2,2,2,1,2,3};
        //ftnmt.sort(0, test.length - 1, test);
        ftnmt.FastSort(test, test.length, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
        System.out.println(ftnmt.getMaxHalf(test));
    }
}
