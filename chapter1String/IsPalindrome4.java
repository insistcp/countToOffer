package TheArtOfProgramming.chapter1String;

/**
 * program:
 * description:
 * author: chenpeng
 * create: 2018/4/7:下午1:11
 **/
public class IsPalindrome4 {
    public boolean isPalindrome(String str){
        if(str == null){
            return false;
        }
        int right= str.length()-1;
        int left = 0;
        while(left<right){
            if(str.charAt(left)==str.charAt(right)){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome4 isp = new IsPalindrome4();
        boolean flag = isp.isPalindrome("ABCCBA");
        System.out.println(flag);
    }
}
