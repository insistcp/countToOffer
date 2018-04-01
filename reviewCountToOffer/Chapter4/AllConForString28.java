package reviewCountToOffer.Chapter4;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by cp on 2018/3/31.
 */
public class AllConForString28 {
    public Set<String> getAllString(String str){
        if(str == null){
            return null;
        }
        Set<String> list = new HashSet<>();
        permutation(list,str.toCharArray(),0);
        return list;
    }
    public static void permutation(Set<String> list,char[] str,int begin){
        if(begin == str.length){
            list.add(new String(str));
        }else{
            for(int i=begin;i<str.length;i++){
                char temp = str[begin];
                str[begin] = str[i];
                str[i] = temp;
                permutation(list,str,begin+1);
                temp = str[begin];
                str[begin] = str[i];
                str[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String str = "ccbc";
        AllConForString28 as = new AllConForString28();
        Set<String> res = as.getAllString(str);
        for(String tt: res){
            System.out.println(tt);
        }


    }
}
