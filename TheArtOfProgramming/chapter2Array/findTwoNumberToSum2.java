package TheArtOfProgramming.chapter2Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * program:
 * description: 在一个数组中寻找两个数使其和为给定的数组
 * author: chenpeng
 * create: 2018/4/9:下午12:10
 **/
public class findTwoNumberToSum2 {
    public List<Pair> getTwoNumber(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        Arrays.sort(arr);
        List<Pair> list = new ArrayList();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == target) {
                list.add(new Pair(left, right));

                left++;
                right--;
            } else if (arr[left] + arr[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return list;
    }

    public List<Integer[]> find3SumTozero(int[] arr) {
        if (arr == null || arr.length < 3) {
            return null;
        }
        int len = arr.length;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        List<Integer[]> res = new ArrayList<>();
        for (int i = 0; i < len-2; i++) {
            int right = len - 1;
            int left = i + 1, sum = 0 - arr[i];
            while (left < right) {
                if (arr[left] + arr[right] == sum) {
                    Integer[] tmp = new Integer[3];
                    tmp[0] = i;
                    tmp[1] = left;
                    tmp[2] = right;
                    res.add(tmp);
                    left++;
                    right--;
                } else if (arr[left] + arr[right] > sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
    public List<Integer[]> get4Sum(int[] arr){
        if(arr == null || arr.length<4){
            return null;
        }
        int len = arr.length;
        Arrays.sort(arr);
        List<Integer[]> res = new ArrayList<>();
        for(int i =0;i<len-4;i++){
            for(int j = i+1;j<len-3;j++){
                int right = len - 1;
                int left = j + 1, sum = 0 - arr[i] -arr[j];
                while (left < right) {
                    if (arr[left] + arr[right] == sum) {
                        Integer[] tmp = new Integer[4];
                        tmp[0] = i;
                        tmp[1] = j;
                        tmp[2] = left;
                        tmp[3] = right;
                        res.add(tmp);
                        left++;
                        right--;
                    } else if (arr[left] + arr[right] > sum) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        findTwoNumberToSum2 ftts = new findTwoNumberToSum2();
        int[] arr = {1,-2,3,-4,5,6,7,8,9,-10};
//        List<Pair> res = ftts.getTwoNumber(arr,10);
//        for(Pair pair:res){
//            System.out.println(pair);
//        }
        List<Integer[]> res = ftts.get4Sum(arr);
        for(Integer[] tmp:res){
            for(int i : tmp){
                System.out.print(i+"=="+arr[i]+"   ");
            }
            System.out.println();
        }
    }
}
class Pair{
    public int left;
    public int right;
    public Pair(){

    }
    public Pair(int left,int right){
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return this.left+" "+this.right;
    }
}
