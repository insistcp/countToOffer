package reviewCountToOffer;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;

/**
 * Created by cp on 2018/3/29.
 */
public class MergeSort {
    public void mergeSort(int[] arr,int left,int right){
        if(arr==null){
            return;
        }
        if(left<right){
            int middle = (left+right)/2;
            mergeSort(arr,left,middle);
            mergeSort(arr,middle+1,right);
            merge(arr,left,middle,right);
        }
    }
    private int[] tmp;
    public void merge(int[] arr,int left,int middle,int right){
        for(int i = left;i<=right;i++){
            tmp[i] = arr[i];
        }
        int index = left;
        int i = left,j = middle+1;
        while(i<=middle && j<=right){
            if(tmp[i]>tmp[j]){
                arr[index++] = tmp[j++];
            }else{
                arr[index++] = tmp[i++];
            }
        }
        while(i<=middle){
            arr[index++] =tmp[i++];
        }

        while(right>=j){
            arr[index++] =tmp[j++];
        }
    }
    public void mergeSort2(int[] arr){
        if(arr==null){
            return;
        }
        int len = arr.length-1;
        for(int dis =1;dis<=len;dis+=dis){
            for(int j =0;j<=len-dis;j+=dis+dis){
                merge(arr,j,j+dis-1,Math.min(j+dis+dis-1,len));
            }
        }
    }
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] arr = {1,10,2,4,6,3,11,23};
        ms.tmp = new int[arr.length];
        //ms.mergeSort(arr,0,arr.length-1);
        ms.mergeSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
