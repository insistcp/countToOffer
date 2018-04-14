package chapter5;

import java.util.ArrayList;
import java.util.List;

public class isUglyNumber34 {
    public boolean isUglyNumber(int number){
        while(number%2==0){
            number= number/2;
        }
        while(number%3==0){
            number= number/3;
        }
        while(number%5==0){
            number= number/5;
        }
        return number==1;
    }
    public int getUglyNumber(int n){
        int count = 0,num= 1;
        while(true){
            if(isUglyNumber(num)){
                count++;
                if(count==n){
                    break;
                }
            }
            num++;
        }
        return num;
    }

    public int getNUglyNumber(int n){
        int count = 1;
        int twoT = 0;
        int threeT = 0;
        int fiveT = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        while(list.size()<n){
            int num2 = list.get(twoT)*2;
            int num3 = list.get(threeT)*3;
            int num5 = list.get(fiveT)*5;
            int min = Math.min(Math.min(num2,num3),num5);
            list.add(min);
            if(min == num2){
                twoT++;
            }
            if(min == num3){
                threeT++;
            }
            if(min == num5){
                fiveT++;
            }
        }
        return list.get(list.size()-1);
    }
    public static void main(String[] args) {
        isUglyNumber34 iun = new isUglyNumber34();
        for(int i = 1;i<=10;i++){
            int flag = iun.getNUglyNumber(7);
            System.out.println(flag);
        }
    }
}
