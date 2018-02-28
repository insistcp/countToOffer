package CountToOffer.chapter6;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：将一个字符串转换成数字，如果是非数字字符串就提示错误。
*                解题思路：设置一个num表示最终的结果，依次遍历每一个字符，对每一个字符进行判断，如果位于0-9之间,则将源number向后移动一位。即乘于10；而后再加上该字符。
*   Module Name: 
*  Date Created: 2018-02-25
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-25     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import sun.rmi.runtime.Log;

public class StringToInteger49 {
    public int atoi(String str) {
        if (str == null) {
            return -1;
        }
        int i = 0;
        boolean minus = false;
        if (str.charAt(0) == '-') {
            i++;
            minus = true;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        long num = 0;
        long MIN_VALUE = Integer.MIN_VALUE;
        long MAX_VALUE = Integer.MAX_VALUE;
        for (; i < str.length(); i++) {
            char t = str.charAt(i);
            if (t >= '0' && t <= '9') {
                num *= 10;
                num += t - '0';
            } else {
                num = 0;
                break;
            }
            if (minus && 0 - num < MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (!minus && num > MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return minus?new Long(0-num).intValue() : new Long(num).intValue();
    }

    public static void main(String[] args) {
        StringToInteger49 stt = new StringToInteger49();
        int res  = stt.atoi("1234");
        System.out.println(res);
    }
}