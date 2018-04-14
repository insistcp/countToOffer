package TheArtOfProgramming.chapter1String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * program:
 * description: 获取一个字符串的全排列
 * author: chenpeng
 * create: 2018/4/7:下午3:03
 **/
public class AllTheString6 {
    private Set<String> list = new HashSet<>();
    public void getAllString(String str){
        if(str == null){
            return;
        }
        char[] test = str.toCharArray();
        getAllStr(test,0,str.length()-1);

    }
    public void getAllStr(char[] arr,int start,int end){
        if(start==end){
            list.add(new String(arr));
        }else {
            for(int i = start;i<=end;i++){
                exchange(arr,i,start);
                getAllStr(arr,start+1,end);
                exchange(arr,i,start);
            }
        }
    }
    public void exchange(char[] arr,int i,int j){
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * program:
     * description: 求字符串的全排列的非递归做法，不断寻找下一个更大一点的排列；
     * author: chenpeng
     * create: 2018/4/7:下午3:47
     **/
    public void getAllString2(String str){
        if(str == null){
            return;
        }
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        getAllStr2(arr);
    }
    public void getAllStr2(char[] arr){
        if(arr.length<2){
            return;
        }
        boolean flag = false;
        while(true){
            int i ,j;
            list.add(new String(arr));
            //System.out.println(Arrays.toString(arr));
            for(i=arr.length-2;i>=0;i--){
                if(arr[i]<arr[i+1]){
                    break;
                }else if(i==0){
                    return;
                }
            }
            for(j=arr.length-1;j>i;j--){
                if(arr[j]>arr[i]){
                    break;
                }
            }
            exchange(arr,i,j);
            reverse(arr,i+1,arr.length-1);
        }
    }
    public void reverse(char[] arr,int start,int end){
        while(start<end){
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
    public void getAll(char[] res,char[] sour,int posi,int size){
        if(posi==size){
            list.add(new String(res));
        }else{
            for(int i = 0;i<size;i++){
                res[posi] = sour[i];
                getAll(res,sour,posi+1,size);
            }
        }
    }

    public static void main(String[] args) {
        AllTheString6 ats = new AllTheString6();
        //ats.getAllString2("babb");
        String str = "ac";
        char[] sour = str.toCharArray();
        char[] res = new char[sour.length];
        ats.getAll(res,sour,0,sour.length);
        for(String st:ats.list){
            System.out.println(st);
        }

    }
}
