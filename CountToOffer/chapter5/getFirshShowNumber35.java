package CountToOffer.chapter5;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个字符串让你找出这个字符串中第一次出现的字符
*   Module Name: 解题思路：使用hash表的方式存储每一个字符以及其对应出现的次数。
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
import java.util.HashMap;
import java.util.Map;

public class getFirshShowNumber35 {
    public char getFirstShow1(String str) {
        if (str == null) {
            return '1';
        }
        char res = '1';
        Map<Character,Integer> map= new HashMap();
        int len = str.length();
        for(int i =0;i<len;i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i), 1);
            }
        }
        for(int i = 0;i<len;i++){
            if(map.get(str.charAt(i))==1){
                res = str.charAt(i);
                break;
            }
        }
        return res;
    }

    /**
     * 去除掉字符串中重复的元素
     * @param str
     */
    public void removeRepeatElements(String str){
        if(str == null){
            return;
        }
        boolean[] flag =  new boolean[256];
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<len;i++){
            if(!flag[str.charAt(i)]){
                flag[str.charAt(i)] = true;
                sb.append(str.charAt(i));
            }
        }
        System.out.println(Arrays.toString(flag));
        System.out.println(sb.toString());
    }

    /**
     * 从str1中去掉str2包含的元素
     * @param str1
     * @param str2
     */
    public void removeStr2FromStr1(String str1,String str2){
        if(str1==null || str2==null){
            return;
        }
        int len1 = str1.length();
        int len2 = str2.length();
        boolean[] flag = new boolean[256];
        for(int i=0;i<len2;i++){
            flag[str2.charAt(i)] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len1;i++){
            if(!flag[str1.charAt(i)]){
                sb.append(str1.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        getFirshShowNumber35 fsn = new getFirshShowNumber35();
        String str = "abcabcd";
        char res = fsn.getFirstShow1(str);
        System.out.println(res);
        String str1 = "ABCCDDefg";
        fsn.removeRepeatElements(str1);
        fsn.removeStr2FromStr1("abcdefgabc","abc");
    }
}
