package CountToOffer;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个字符串，让你替换掉字符串中的空格，
*   Module Name: 考虑使用从后向前对比每一个其中一个字符串，以达到减少移动字符的目的
*   拓展：如果合并两个数组，从前向后需要多次移动字符时，我们就可以转换思路，从后向前移动字符以达到减少移动次数的目的。
*  Date Created: 2018-02-05
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-05     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

public class replaceSpace3 {
    public String replaceSpace(String str){
        if(str == null){
            return str;
        }
        return str.replaceAll(" ","%20");
    }

    public static void main(String[] args) {
        replaceSpace3 rs = new replaceSpace3();
        String res = rs.replaceSpace("we are happy");
        System.out.println(res);
    }
}
