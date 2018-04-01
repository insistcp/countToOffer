package reviewCountToOffer.Chapter3;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by cp on 2018/3/28.
 */
public class AdjustArry14 {
    public void Adjust(int[] arr){
      if(arr == null){
          return;
      }
      int len  = arr.length-1;
      int left = 0,right = len;
      while(left<right){
          while(left<right && arr[left]%2!=0){
                left++;
          }
          while(left< right && arr[right]%2!=1){
                right--;
          }
          if(left<right){
              exchange(arr,left,right);
          }

      }
      System.out.println(Arrays.toString(arr));
    }
    public void exchange(int[] arr,int i,int j){
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,13,4,3,2,6};
        AdjustArry14 aa = new AdjustArry14();
        aa.Adjust(arr);
    }
}
