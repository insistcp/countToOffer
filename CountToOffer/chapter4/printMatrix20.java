package CountToOffer.chapter4;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 
*   Module Name: 
*  Date Created: 2018-02-12
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-12     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

public class printMatrix20 {
    public void PrintMatrixClockwisely(int[][] numbers,int columns,int rows){
        if(numbers == null || columns<=0 || rows<=0){
            return;
        }
        int start = 0;
        while(columns>start*2 && rows>start*2){
            PrintMatrixInCircle(numbers,columns,rows,start);
            ++start;
        }
    }
    public void PrintMatrixInCircle(int[][] nums,int columns,int row,int start){
        int endX = columns - 1 - start;
        int endY = row - 1 - start;
        for(int i = start;i<=endX;++i){
            int number = nums[start][i];
            System.out.print(number);
        }
        if(start<endY){
            for(int i = start+1;i<=endY;i++){
                int number = nums[i][endX];
                System.out.print(number);
            }
        }
        if(start<endX && start<endY){
            for(int i = endX-1;i>=start;--i){
                int number = nums[endY][i];
                System.out.print(number);
            }
        }
        if(start<endX && start<endY-1){
            for(int i = endY-1;i>=start+1;--i){
                int number = nums[i][start];
                System.out.print(number);
            }
        }

    }

    public static void main(String[] args) {
        printMatrix20 pm = new printMatrix20();
        int[][] test = {
                {1,2,3,4,4},
                {5,6,7,8,4},
                {9,10,11,12,4},
                {13,14,15,16,4}};

        pm.PrintMatrixClockwisely(test,5,4);
    }
}
