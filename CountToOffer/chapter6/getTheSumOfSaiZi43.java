package CountToOffer.chapter6;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定n个塞子让你投掷，让你求这个n个塞子可能组成的所有的可能的数字和。
*                解题思路:
*                       1: 利用递归的思想，起初将所有塞子分成两部分第1个为第一部分，其余的为后半部分，再依次将后面的塞子按照这个思想继续划分，依次循环
*                       2：利用动态规划的思想
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

public class getTheSumOfSaiZi43 {
    private static final int g_maxValue = 6;
    public static void printProbability(int number){
        if(number<1){
            return;
        }
        int maxSum = number * g_maxValue;
        int[] pProbabilities = new int[maxSum - number+1];
        for(int i = number ;i<=maxSum;i++){
            pProbabilities[i-number] =0;
        }
        double total = Math.pow(g_maxValue,number);
        probability(number,pProbabilities);
        for(int i = number;i<=maxSum;i++){
            double ratio = pProbabilities[i-number]/total;
            System.out.println("value = " + pProbabilities[i - number] + "i: " + i + " ratio: " + ratio);
        }

    }
    public static void probability(int number , int[] pProbabilities){
        for(int i = 1;i<=g_maxValue;i++){
            probability(number, number, i, pProbabilities);
        }
    }
    public static void probability(int original,int current,int sum,int[] pProbabilities){
        if(current == 1){
            pProbabilities[sum-original]++;
        }else{
            for(int i = 1;i<=g_maxValue;i++){
                probability(original,current-1,sum+i,pProbabilities);
            }
        }
    }


    public static final int Points = 6;
    public static void oProbability(int number){
        if(number<1){
            return;
        }
        double total = Math.pow(number,6);
        int maxSum = Points *number;
        int[] pProbabilities  = new int[maxSum-number+1];
        for(int i = number;i<=maxSum;i++){
            pProbabilities [i-number] = 0;
        }
        probability(number,pProbabilities);
        for(int i = number;i<=maxSum;i++){
            double ratio = pProbabilities[i-number]/total;
            System.out.println("value="+i+" times = "+pProbabilities[i-number]+"ratio: "+ratio);
        }
    }
    public static void probability1(int number,int[] pProbabilities){
        for(int i = 1;i<=Points;i++){
            probability(number, number, i, pProbabilities);
        }
    }
    public static void probability1(int original,int current,int sum,int[] pProbabilities){
        if(current == 1){
            pProbabilities[sum-original]++;
        }else{
            for(int i = 1;i<=Points;i++){
                probability(original,current-1,sum+i,pProbabilities);
            }
        }
    }


    public static void PrintProbability_1(int number){
        if(number < 1){
            return;
        }
        int[][] pProbalitities = new int[2][Points * number +1];
        for(int i = 0;i<Points;i++){
            pProbalitities[0][i] = 0;
            pProbalitities[1][i] = 0;
        }
        int flag = 0;
        for(int i =1;i<=Points;i++){
            pProbalitities[flag][i] = 1;
        }
        for(int k = 2;k<=number;k++){
            for(int i = 0;i<k;i++){
                pProbalitities[1-flag][i] = 0;
            }
            for(int i = k;i<=Points*k;i++ ){
                pProbalitities[1-flag][i] = 0;
                for(int j = 1;j<=i && j<=Points;j++){
                    pProbalitities[1-flag][i] += pProbalitities[flag][i-j];
                }
            }
            flag = 1-flag;
        }
        double total = Math.pow(Points,number);
        for(int i = number;i<=Points * number;i++){
            double ratio = pProbalitities[flag][i]/total;
            System.out.println("value="+i+" times = "+ pProbalitities[flag][i]+"ratio: "+ratio);
        }
    }
    public static void main(String[] args) {
        //getTheSumOfSaiZi43.oProbability(2);
        getTheSumOfSaiZi43.PrintProbability_1(2);
    }
}
