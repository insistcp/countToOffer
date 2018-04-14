package chapter5;

public class findNumberMoreThanHalf29 {
    public int findTheNumberMoreThanHalf(int[] arr){
        if(arr == null){
            return Integer.MIN_VALUE;
        }
        int left = 0,right = arr.length-1;
        int k = (left+right)/2;
        int returnIndex = -1;
        while(left<right){
            int index = Partition(arr,left,right);
            if(index>k){
                right = index-1;
            }else if(index<k){
                left = index+1;
            }else{
                returnIndex = index;
                break;
            }
        }
        return arr[returnIndex];

    }
    public int Partition(int[] arr,int left,int right){
        int comp = arr[left];
        while (left<right){
            while(left<right && arr[right]>=comp){
                right--;
            }
            arr[left] = arr[right];
            while(left<right && arr[left]<=comp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = comp;
        return left;
    }

    public static void main(String[] args) {
        findNumberMoreThanHalf29 fnmt = new findNumberMoreThanHalf29();
        int res = fnmt.findTheNumberMoreThanHalf(new int[]{1,1,1,1,2,2,2,2,1,2,2});
        System.out.println(res);
    }
}
