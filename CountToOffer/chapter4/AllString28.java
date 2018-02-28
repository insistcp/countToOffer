package CountToOffer.chapter4;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个字符串，让你输出这个字符串的所有排列
*   Module Name: 解题思路：将待排序的字符串分成两部分，第一个字符和后面的字符。使用后面的字符依次和第一个字符串交换，
*   交换之后固定第一个字符串，将后面的字符串按照前面的思想和第一个字符串交换顺序。依次循环
*  Date Created: 2018-02-20
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-20     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllString28 {
    public List<String> getAllString(String str){
        if(str == null){
          return null;
        }
        List<String> list = new ArrayList<String>();
        permutation(list,str.toCharArray(),0);
        return list;
    }
    public static void permutation(List<String> list,char[] str,int begin){
        if(begin == str.length){
            list.add(new String(str));
        }else{
            for(int i=begin;i<str.length;i++){
                char temp = str[begin];
                str[begin] = str[i];
                str[i] = temp;
                permutation(list,str,begin+1);
                temp = str[begin];
                str[begin] = str[i];
                str[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        AllString28 as = new AllString28();
        List<String> res = as.getAllString(str);
        for(String tt: res){
            System.out.println(tt);
        }


    }
}
