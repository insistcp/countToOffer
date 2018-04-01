package reviewCountToOffer.Chapter2;

/**
 * Created by cp on 2018/3/27.
 */
public class findTheMinRotate8 {
    public int findMin(int[] arr){
        if(arr == null){
            return Integer.MAX_VALUE;
        }
        int len = arr.length;
        int left = 0,right = len-1;
        if(arr[left]<arr[right]){
            return arr[left];
        }
        int middle;
        while(left<right){
            middle = (left+right)/2;
            if(arr[middle]>arr[left]){
                left = middle;
            }else if(arr[middle]<arr[right]){
                right = middle;
            }else{
                break;
            }
        }
        return arr[right];
    }

    public static void main(String[] args) {
        findTheMinRotate8 ftm = new findTheMinRotate8();
        int res = ftm.findMin(new int[]{3,4,0,1,1,3});
        System.out.println(res);
    }
}
