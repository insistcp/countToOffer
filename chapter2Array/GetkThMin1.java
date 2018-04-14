package TheArtOfProgramming.chapter2Array;

import java.util.Arrays;

/**
 * program:
 * description: 给定一个数组让你找到这个数组中最小的k个值；
 * 两种解题方式，一种使用大顶堆，二使用快速排序的思想。
 * author: chenpeng
 * create: 2018/4/8:上午10:00
 **/
public class GetkThMin1 {
    public int[] getKthMin(int[] arr,int k){
        if(arr == null){
            return null;
        }
        if(k>=arr.length){
            return arr;
        }
        int[] tmp = new int[k];
        for(int i = 0;i<k;i++){
            tmp[i] = arr[i];
        }
        for(int m=k/2;m>=0;m--){
            sink(tmp,k,m);
        }
        for(int i = k;i<arr.length;i++){
            if(arr[i]<tmp[0]){
                tmp[0] = arr[i];
                sink(tmp,k,0);
            }
        }
        System.out.println(Arrays.toString(tmp));
        return tmp;
    }
    public void sink(int[] arr,int n,int k){
        while(2*k<n){
            int j = 2*k;
            if(j+1<n && arr[j+1]>arr[j]){
                j++;
            }
            if(arr[j]<=arr[k]){
                return;
            }
            exchange(arr,k,j);
            k = j;
        }

    }
    public void exchange(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        GetkThMin1 gtm = new GetkThMin1();
        int[] arr = {1,2,3,4,5,6,7,1,2,3};
        gtm.getKthMin(arr,6);
    }
}
