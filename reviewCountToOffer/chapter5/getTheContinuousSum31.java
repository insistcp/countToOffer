package chapter5;

import java.util.Arrays;

public class getTheContinuousSum31 {
    public int getSumContinous(int[] arr){
        if(arr == null){
            return Integer.MIN_VALUE;
        }
        int returnMax = arr[0];
        int currentMax = arr[0];
        int len  = arr.length;
        for(int i =1;i<len;i++){
            if(currentMax>0){
                currentMax+=arr[i];
            }else{
                currentMax = arr[i];
            }
            if(currentMax>returnMax){
                returnMax = currentMax;
            }
        }
        return returnMax;
    }
    public int getMaxMultiContinous(int[] arr){
        if(arr == null){
            return Integer.MIN_VALUE;
        }
        int len = arr.length;
        int currentMin = arr[0],currentMax = arr[0],returnMax = arr[0];
        for(int i =1;i<len;i++){
            int a = currentMin*arr[i];
            int b = currentMax*arr[i];
            currentMax = Math.max(arr[i],Math.max(a,b));
            currentMin = Math.min(arr[i],Math.min(a,b));
            if(currentMax>returnMax){
                returnMax = currentMax;
            }
            returnMax = Math.max(returnMax, returnMax);
        }
        return returnMax;
    }

    public int getMaxMultiContinous1(int[] arr){
        if(arr == null){
            return Integer.MIN_VALUE;
        }
        int len = arr.length;
        int[] minValue = new int[len];
        int[] maxValue = new int[len];
        minValue[0] = arr[0];
        maxValue[0] = arr[0];
        for(int i =1;i<len;i++){
            maxValue[i] = Math.max(Math.max(maxValue[i-1]*arr[i],minValue[i-1]*arr[i]),arr[i]);
            minValue[i] = Math.min(Math.min(maxValue[i-1]*arr[i],minValue[i-1]*arr[i]),arr[i]);

        }
        System.out.println(Arrays.toString(maxValue));
        int returnMax = arr[0];
        for(int i = 0;i<len;i++){
            if(returnMax<maxValue[i]){
                returnMax = maxValue[i];
            }
        }
        return returnMax;
    }
    public static void main(String[] args) {
        getTheContinuousSum31 tcs = new getTheContinuousSum31();
        int res = tcs.getMaxMultiContinous1(new int[]{1,2,3,4,-12,11});
        System.out.println(res);
    }
}
