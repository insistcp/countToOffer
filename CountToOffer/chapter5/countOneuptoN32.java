package CountToOffer.chapter5;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 
*   Module Name: 
*  Date Created: 2018-02-21
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-21     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

public class countOneuptoN32 {
    public int countOne(int n){
        int count = 0;
        for(int i=1;i<=n;i++){
             count += getOne(i);
        }
        return count;
    }
    public int getOne(int number){
        int count = 0;
        while(number>0){
            if(number%10==1){
                count++;
            }
            number=number/10;
        }
        return count;
    }

    /**
     * 思路：分别计算每一个位置上1出现的频率将各个位数上1出现的频率叠加起来
     * @param n
     * @return
     */
    public int countNumOf1(int n){
        if(n<=0){
            return 0;
        }
        int count = 0;
        int factor = 1;
        while(n/factor != 0){
            int lowerNum = n-n/factor*factor;
            int currentNum = (n/factor)%10;
            int highNum = n/(factor*10);
            if(currentNum == 0){
                count += highNum * factor;
            }else if(currentNum == 1){
                count += highNum*factor + lowerNum + 1;
            }else{
                count += (highNum+1)*factor;
            }
            factor *= 10;
        }
        return count;
    }
    public static void main(String[] args) {
        countOneuptoN32 con = new countOneuptoN32();
        int res = con.countOne(10);
        System.out.println(res);
    }
}
