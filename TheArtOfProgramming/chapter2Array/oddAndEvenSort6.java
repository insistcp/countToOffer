package TheArtOfProgramming.chapter2Array;

import java.util.Arrays;

/**
 * program:
 * description: 奇数和偶数排序问题
 * author: chenpeng
 * create: 2018/4/14:下午5:47
 **/
public class oddAndEvenSort6 {
    public void oddAndEvenSort(int[] arr){
        if(arr == null){
            return;
        }
        int len = arr.length;
        int left = 0,right = len-1;
        while(left<right){
            while(left<right && arr[left]%2==1){
                left++;
            }
            while(left<right && arr[right]%2==0){
                right--;
            }
            exchange(arr,left,right);
        }
    }
    public void exchange(int[] arr,int left,int right){
        int tmp  = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        oddAndEvenSort6 oaes = new oddAndEvenSort6();
        oaes.oddAndEvenSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
