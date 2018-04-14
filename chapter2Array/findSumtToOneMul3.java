package TheArtOfProgramming.chapter2Array;

import java.util.ArrayList;
import java.util.List;

/**
 * program:
 * description: 寻找和为给定值的多个数
 * author: chenpeng
 * create: 2018/4/11:上午8:32
 **/
public class findSumtToOneMul3 {
    public List<List<Integer>> getSum4(int[] arr,int target){
        if(arr==null){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        getAllCombination(res,new ArrayList<>(),arr,arr.length-1,target);
        return res;
    }
    public void getAllCombination(List<List<Integer>> res, List<Integer> combina,int[] arr, int end,int target){
        if(end<0 || target<0){
            return;
        }
        if(arr[end]==target){
            combina.add(arr[end]);
            res.add(new ArrayList<>(combina));
            combina.remove(combina.size()-1);
        }
        combina.add(arr[end]);
        getAllCombination(res,combina,arr,end-1,target-arr[end]);
        combina.remove(combina.size()-1);
        getAllCombination(res,combina,arr,end-1,target);


    }

    public static void main(String[] args) {
        findSumtToOneMul3 findSumtToOneMul3 = new findSumtToOneMul3();
        int[] arr = {3,7,4,6,10,20,0,1,2,3};
        List<List<Integer>>  res =  findSumtToOneMul3.getSum4(arr,10);
        for(List<Integer> tmp:res){
            for(Integer it:tmp){
                System.out.print(it+" ");
            }
            System.out.println();
        }
    }
}
