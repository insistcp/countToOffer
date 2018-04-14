package TheArtOfProgramming.chapter1String;

import java.util.ArrayList;
import java.util.List;

/**
 * program:
 * description: 给定两个字符串str1和str2并且我们已知str1长度大于str2长度，现在让你判断字符串str2中的字符是否全部包含于str1；
 * author: chenpeng
 * create: 2018/4/7:下午12:14
 **/
public class String1IsContainString22 {
    public boolean isContainStr(String str1,String str2){
        if(str1==null || str2==null){
            return false;
        }
        int len1 = str1.length();
        int[] arr = new int[26];
        for(int i = 0;i<len1;i++){
            arr[str1.charAt(i)-'A']++;
        }
        int len2 = str2.length();
        for(int i = 0;i<len2;i++){
            if(arr[str2.charAt(i)-'A']<=0){
                return false;
            }else{
                arr[str2.charAt(i)-'A']--;
            }
        }
        return true;
    }
    public List<String> getAllBrotherString(List<String> all,String tar){
        if(all==null || all.size()==0){
            return null;
        }
        List<String> res = new ArrayList<>();
        for(String str:all){
            if(str.length() == tar.length()){
                if(isContainStr(str,tar)){
                    res.add(str);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String1IsContainString22 sics = new String1IsContainString22();
        boolean res = sics.isContainStr("ABCDEA","ACDEE");
        List<String> list = new ArrayList<>();
        list.add("ABC");
        list.add("CBAA");
        list.add("AACD");
        list.add("AACDE");
        list.add("AADC");
        List<String> res1 = sics.getAllBrotherString(list,"CDAA");
        for(String str:res1){
            System.out.println(str);
        }
        System.out.println(res);
    }
}
