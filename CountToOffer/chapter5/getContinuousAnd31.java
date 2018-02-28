package CountToOffer.chapter5;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 
*   Module Name: 
*  Date Created: 2018-02-20
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-20     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

public class getContinuousAnd31 {
    public int getSum(int[] arr) {
        if (arr == null) {
            return -1;
        }
        int sub = arr[0];
        int len = arr.length;
        int max = 0;
        for(int i=1;i<len;i++){
            if(sub>0){
                sub = sub+arr[i];
            }else{
                sub = arr[i];
            }
            if(max<sub){
                max = sub;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        getContinuousAnd31 gca  = new getContinuousAnd31();
        int[] test = {1,-2,3,10,-4,7,2,-5};
        int res = gca.getSum(test);
        System.out.println(res);
    }
}
