package chapter5;

import java.util.Arrays;

/**
 * 求TopK的元素，两种解题方法：
 * 1：使用快速排序的思想
 * 2：利用堆排序的思想
 */
public class findTheTopKNumber30 {
    public int[] findTopK(int[] arr,int k){
        if(arr == null){
            return null;
        }
        int left = 0,right = arr.length-1;
        //注意这里的下标！
        int p = right+1-k;
        while(left<right){
            int index = partition(arr,left,right);
            if(index==p){
                break;
            }else if(index<p){
                left  = index+1;
            }else{
                right = index-1;
            }
        }
        int[] res = new int[k];
        System.out.println(Arrays.toString(arr));
        for(int i = p;i<arr.length;i++){
            res[i-p] = arr[i];
        }
        return res;

    }
    public int partition(int[] arr,int left,int right){
        int comp = arr[left];
        while(left < right){
            while(left<right && arr[right]>=comp){
                right--;
            }
            arr[left]= arr[right];
            while(left<right && arr[left]<=comp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = comp;
        return left;
    }

    public int[] getTopK(int[] arr,int k){
        int[] res = new int[k];
        for(int i= 0;i<k;i++){
            res[i] = arr[i];
        }
        for(int i = k/2;i>=0;i--){
            sink(res,i,k);
        }
        for(int i = k;i<arr.length;i++){
            if(arr[i]>res[0]){
                exchange(arr,0,i);
                sink(res,0,k);
            }

        }
        return res;

    }
    public int[] getTopK2(int[] arr,int k ){

        if(arr == null){
            return arr;
        }
        int len = arr.length-1;
        for(int i = k/2;i>=0;i--){
            sink(arr,i,k);
        }
        for(int i = k;i<=len;i++){
            if(arr[i]>arr[0]){
                exchange(arr,0,i);
                sink(arr,0,k);
            }

        }
        return Arrays.copyOfRange(arr,0,k);
    }
    public void sink(int[] arr,int index,int N){
        while(2*index<N){
            int left = index*2;
            if((left+1<N) && arr[left]>arr[left+1]){
                left++;
            }
            if(arr[index]<=arr[left]){
                break;
            }
            exchange(arr,left,index);
            index = left;
        }
    }
    public void exchange(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        findTheTopKNumber30 fttn = new findTheTopKNumber30();
        int[] res = fttn.getTopK2(new int[]{8,7,6,5,4,3,2,1,2,2,2,1,1,2,3},3);
        System.out.println(Arrays.toString(res));
    }
}
