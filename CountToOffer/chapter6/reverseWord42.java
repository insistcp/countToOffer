package CountToOffer.chapter6;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个字符串，让你将其以单词为单位将其逆序输出。
*               解题思路：将单词劈开再组合在一起即可
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

public class reverseWord42 {
    public String reverseSentence(String str){
        if(str == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String[] tt = str.split(" ");
        int len  = tt.length;
        for(int i = len-1;i>=0;i--){
            sb.append(tt[i]+" ");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    public String rotateString(String str,int size){
        if(str == null){
            return null;
        }
        if(size>=str.length()){
            return str;
        }
        String str1 = str.substring(0,size);
        String str2 = str.substring(size);
        System.out.println();
        return str2+str1;
    }
    public static void main(String[] args) {
        reverseWord42 rw = new reverseWord42();
        String str = "I";
        rw.reverseSentence(str);
        String str2 = "I am a student;";
        String res = rw.rotateString(str2,100);
        System.out.println(res);
    }
}
