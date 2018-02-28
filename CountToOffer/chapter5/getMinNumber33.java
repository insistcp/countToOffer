package CountToOffer.chapter5;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个数组让你将这个数组进行组合使得组合后的数字值最小。
*   Module Name: 解题思路：两种方式
*                       1：将所有的可能解全部都表示出来，然后依次比较
*                       2：两个数字两两进行组合并且比较选择较小的结果保留。
*  Date Created: 2018-02-21
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-21     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class getMinNumber33 {
    List<String> list = new ArrayList<String>();
    public void get(int[] arr,int start,int end){
        if(start==arr.length){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<=arr.length-1;i++){
                sb.append(arr[i]);
            }
            list.add(sb.toString());
        }else {
            for (int i = start; i <= end; i++) {
                int tmp = arr[start];
                arr[start] = arr[i];
                arr[i] = tmp;
                get(arr, start + 1, end);
                tmp = arr[start];
                arr[start] = arr[i];
                arr[i] = tmp;
            }
        }
    }
    public void getRest(int[] arr){
        int end = arr.length-1;
        get(arr,0,end);
        String min = list.get(0);
        for(int i=1;i<list.size();i++){
            if(min.compareTo(list.get(i))>0){
                min = list.get(i);
            }
        }
        System.out.println(min);
    }


    public String PrintMinNumber(int[] numbers){
        StringBuilder string = new StringBuilder();
        List<Integer> list = new ArrayList<Integer>();
        int n = numbers.length;
        for(int i = 0;i<n;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1+""+o2;
                String s2 = o2+""+o1;
                return s1.compareTo(s2);
            }
        });
        for(int j : list){
            System.out.print(j + " ");
            string.append(j);
        }
        return string.toString();
    }
    public static void main(String[] args) {
        getMinNumber33 gmn = new getMinNumber33();
        int[] test = {3,32,321,1};
        gmn.getRest(test);
        gmn.PrintMinNumber(test);

    }
}
