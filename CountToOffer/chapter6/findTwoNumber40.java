package CountToOffer.chapter6;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个数组，这个数组中包含的所有数字除了两个数字之外其他的数字全都是成对出现的。
   *            解题思路：将原数组分成两个数组，将两个数字分别分到这两个数组中。
   *            然后利用在数组中寻找只出现一次元素的原理寻找到这个数字。
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findTwoNumber40 {
    public int findOnce(int[] test){
        if(test == null){
            return Integer.MAX_VALUE;
        }
        int len = test.length-1;
        int res = 0;
        for(int i = 0;i<=len;i++){
            res^=test[i];
        }
        return res;
    }
    public int[] getAnd(int[] test){
        int[] res = new int[2];
        int resT = findOnce(test);
        String digit = Integer.toBinaryString(resT);
        int len  = digit.length()-1;
        for(int i = 0;i<test.length;i++){
            int t = test[i] >> len;
            if(test[i] >> len>0){
                res[0] ^= test[i];
            }else{
                res[1] ^= test[i];
            }
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
    public static void main(String[] args) {
        findTwoNumber40 ftn = new findTwoNumber40();
        int[] test = {1,1,100,12};
        int[] res = ftn.getAnd(test);
    }
}
