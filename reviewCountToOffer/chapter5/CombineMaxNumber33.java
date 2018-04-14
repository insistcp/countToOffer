package chapter5;

import java.util.*;

public class CombineMaxNumber33 {
    public int getCombineMaxNumber(int[] arr){
        if(arr == null){
            return Integer.MIN_VALUE;
        }
        List<Integer> list = new ArrayList<>();
        Permatution(arr,0,arr.length-1,list);
        int returnMax = Integer.MIN_VALUE;
        for(int tmp:list){
            if(tmp>returnMax){
                returnMax = tmp;
            }
        }
        return returnMax;
    }
    public void Permatution(int[] arr,int form,int to,List<Integer> list){
        if(form==to){
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<arr.length;i++){
                sb.append(arr[i]);
            }
            list.add(Integer.valueOf(sb.toString()));
            return;
        }
        for(int i = form;i<=to;i++){
            exchange(arr,i,form);
            Permatution(arr,form+1,to,list);
            exchange(arr,i,form);
        }
    }
    public void exchange(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public int getMinNumber(int[] arr){
        if(arr == null){
            return Integer.MIN_VALUE;
        }
        List<Integer> list = new ArrayList<Integer>();
        int len  = arr.length;
        for(int i = 0;i<len;i++){
            list.add(arr[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int tmp1 =  Integer.valueOf(o1+""+o2);
                int tmp2 =  Integer.valueOf(o2+""+o1);
                return tmp1-tmp2;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<len;i++){
            sb.append(list.get(i));
        }
        return Integer.valueOf(sb.toString());

    }
    public static void main(String[] args) {
        CombineMaxNumber33 cmn = new CombineMaxNumber33();
        int res = cmn.getMinNumber(new int[]{300,22,3});
        System.out.println(res);
    }
}
