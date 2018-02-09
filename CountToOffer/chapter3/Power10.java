package CountToOffer.chapter3;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：求解一个数的n次方，需要注意的是在判断两个浮点数是否相等时我们常常采用方式时对这两个数做差，
*       如果差值小于某一指定范围则表示两个数相等。
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

public class Power10 {
    public double getPower(double base,int exponent) throws Exception {
        double res = 1;
        if(equal(base,0) && exponent>=0){
            return res;
        }else if(equal(base,0)){
            throw new Exception("输入非法，0不能做除数");
        }else if(exponent>0){
            for(int i=1;i<=exponent;i++){
                res = res*base;
            }
        }else if(exponent<0){
            exponent =-exponent;
            for(int i=1;i<=exponent;i++){
                res = res*base;
            }
            res = 1/res;
        }
        return res;
    }
    public boolean equal(double num1,double num2){
        if((num1-num2)<0.000001){
            return true;
        }
        return false;
    }

    /**
     * 高效解题方法：利用位运算和递归
     * @param base
     * @param exponent
     * @return
     */
    public double PowerWithUnsignedExponent(double base,int exponent){
        boolean flag = false;
        if(exponent<0){
            flag = true;
            exponent = -exponent;
        }
        if(exponent==0){
            return 0;
        }
        if(exponent==1){
            return base;
        }
        double res = PowerWithUnsignedExponent(base,exponent>>1);
        res = res*res;
        if((exponent & 0x1) == 1){
            res =res*base;
        }
        if(flag){
            res = 1/res;
        }
        return  res;
    }
    public static void main(String[] args) {
        Power10 ps = new Power10();
        try {
            double res = ps.getPower(-1,0);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        double res = ps.PowerWithUnsignedExponent(10,-2);
        System.out.println(0x1);
        System.out.println(res);
    }
};
