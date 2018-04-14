package chapter5;

import java.util.HashMap;
import java.util.Map;

public class findAccurenceOnceFirst35 {
    public char getOccurenceOncefirst(String str){
        char[] arr = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(char t:arr){
            map.put(t,map.getOrDefault(t,0)+1);
        }
        char retrunC = ' ' ;
        for(char t:arr){
           if( map.get(t)==1){
               retrunC = t;
               break;
           }
        }
        return retrunC;
    }

    public static void main(String[] args) {
       String str = "abcavbc";
       findAccurenceOnceFirst35 faof = new findAccurenceOnceFirst35();
       char st = faof.getOccurenceOncefirst(str);
        System.out.println(st);
    }
}
