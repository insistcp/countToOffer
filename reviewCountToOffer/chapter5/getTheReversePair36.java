package chapter5;

import java.util.Arrays;

public class getTheReversePair36 {
    public int getReversePairs(int[] test){
        if(test == null){
            return -1;
        }
        int len = test.length;
        int count = 0;
        for(int i = 0;i<len;i++){
            for(int j = i+1;j<len;j++){
                if(test[i]>test[j]){
                    count++;
                }
            }
        }
        return count;
    }
    private int[] tmp ;

    private int count = 0;
    public void merge(int[] arr,int start,int middle ,int end){
        for(int i= start;i<=end;i++){
            tmp[i] = arr[i];
        }
        int i = start, j = middle+1;

        while(i<=middle && j<=end){
            if(tmp[i]>tmp[j]){
                count = count+middle-i+1;
                arr[start++] = tmp[j++];
            }else{
                arr[start++] = tmp[i++];
            }
        }
        while(i<=middle){
            arr[start++] = tmp[i++];
        }
        while(j<=end){
            arr[start++] = tmp[j++];
        }
    }
    public void divide(int[] arr){
        int len  = arr.length;
        for(int dis = 1;dis<len;dis=dis+dis){
            for(int i = 0;i<len-dis;i+=dis+dis){
                merge(arr,i,i+dis-1,Math.min(len-1,i+dis+dis-1));
            }
        }
    }
    public static void main(String[] args) {
        getTheReversePair36 gtrp = new getTheReversePair36();
        int res =  gtrp.getReversePairs(new int[]{6,4,1,2,1,3,4,5,6});
        System.out.println(res);
        int[] tm = new int[]{6,4,1,2,1,3,4,5,6};
        gtrp.tmp = new int[tm.length];
        gtrp.divide(tm);
        System.out.println(Arrays.toString(tm));
        System.out.println(gtrp.count);
    }
}
