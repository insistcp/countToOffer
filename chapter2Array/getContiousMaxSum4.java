package TheArtOfProgramming.chapter2Array;

import java.util.Arrays;
import java.util.Stack;

/**
 * program:
 * description: 求连续最大的字段和
 * author: chenpeng
 * create: 2018/4/11:上午9:20
 **/
public class getContiousMaxSum4 {
    /**
     * program:
     * description: 连续最大字段和
     * author: chenpeng
     * create: 2018/4/11:上午9:26
     **/
    public int getContiousMax(int[] arr){
        if(arr == null){
            return Integer.MIN_VALUE;
        }
        int len = arr.length;
        int current = arr[0],max = arr[0];
        for(int i =1;i<len;i++){
            if(current<0){
                current = arr[i];
            }else{
                current+=arr[i];
            }
            if(current>max){
                max = current;
            }
        }
        return max;
    }

    /**
     * program:
     * description: 连续最大子乘和，使用两个数组记录以当前数字结尾时的最大子乘和和最小子乘和
     * author: chenpeng
     * create: 2018/4/13:上午9:33
     **/
    public int getContiousMaxMul(int[] arr){
        if(arr == null){
            return Integer.MIN_VALUE;
        }
        int len = arr.length;
        int[] minValues = new int[len];
        int[] maxValues = new int[len];
        int returnMax = arr[0];
        minValues[0] = arr[0];
        maxValues[0] = arr[0];
        for(int i = 1;i<len;i++){
            int tMin = minValues[i-1]*arr[i];
            int tMax = maxValues[i-1]*arr[i];
            minValues[i] = Integer.min(arr[i],Integer.min(tMax,tMin));
            maxValues[i] = Integer.max(arr[i],Integer.max(tMax,tMin));
            if(maxValues[i]>returnMax){
                returnMax = maxValues[i];
            }
        }
        System.out.println(Arrays.toString(maxValues));
        System.out.println(Arrays.toString(minValues));
        return returnMax;
    }

    /**
     * program:
     * description: nlog(n)的做法
     * author: chenpeng
     * create: 2018/4/13:下午2:25
     **/
    public int getMaxSqure(int[] arr){
        if(arr == null){
            return 0;
        }
        int len = arr.length;
        Arrays.sort(arr);
        int max = 0;
        for(int i =0;i<len;i++){
            if((len-i-1)*arr[i]>max){
                max = (len-i-1)*arr[i];
            }
        }
        return max;
    }

    /**
     * program:
     * description:
     * author: chenpeng
     * create: 2018/4/13:下午2:26
     **/
    public int getMaxSqureS(int[] arr){
        if(arr == null){
            return -1;
        }
        int len = arr.length;
        int height = 0,Squre = 0;
        int left = 0,right = 0;
        Stack<Integer> stack = new Stack();
        for(int i = 0;i<len;i++){
            int currentSqure = 0;
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                int top = stack.peek();
                while(!stack.isEmpty()&arr[top]>arr[i]){
                   top = stack.pop();
                   height = arr[top];

                   right = i-1;
                    if(stack.isEmpty()){
                        right = 0;
                    }
                   left = top;
                    currentSqure = (right-left+1)*height;
                    if(currentSqure>Squre){
                        Squre = currentSqure;
                    }
                }
                stack.push(i);

            }
        }
        return Squre;
    }

    public static void main(String[] args) {
        getContiousMaxSum4 gcss = new getContiousMaxSum4();
        //int res = gcss.getContiousMaxMul(new int[]{1,2,3,4,5,10,-10,1201});
        //int res = gcss.getMaxSqure(new int[]{1,2,3,4,5,6,7,8,9});
        int res = gcss.getMaxSqureS(new int[]{3,2,5,6,1,4,4});
        System.out.println(res);
    }
}
