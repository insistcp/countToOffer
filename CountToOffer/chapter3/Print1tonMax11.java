package CountToOffer.chapter3;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 
*   Module Name: 
*  Date Created: 2018-02-08
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-08     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

import java.util.Arrays;

public class Print1tonMax11 {
    public void printToMax(int n){
        if(n<0){
            return;
        }
        char[] number = new char[n];
        Arrays.fill(number,'0');
        while(!increment(number)){
            printNumber(number);
        }
        return;
    }
    public void printNumber(char[] num){
        int size = num.length;
        int i = 0;
        while(i < size && num[i] == '0') //i < size在前，否则越界
            i++;
        //char[] printNum = new char[size - i];
        //System.arraycopy(num, i, printNum, 0, size - i);//复制数组
        if(i == size)//不打印全0
            return;
        char[] printNum = Arrays.copyOfRange(num, i, size);//复制数组
        System.out.println(printNum);
    }
    public boolean increment(char[] number){
        boolean isOverflow = false;
        int size = number.length;
        int carry  = 0;
        for(int i= size;i>=0;i--){
            int tmp = number[i] - '0'+carry;
            if(i == size-1){
                tmp++;
            }
            if(tmp>=10){
                if(i==0){
                    isOverflow = true;
                }else{
                    tmp-=10;
                    carry = 1;
                    number[i] = (char)('0'+tmp);
                }
            }else{
                number[i] = (char)('0'+tmp);
                break;

            }
        }
        return isOverflow;
    }

    public static void main(String[] args) {
        Print1tonMax11 ptm = new Print1tonMax11();
        ptm.printToMax(5);
    }
}
