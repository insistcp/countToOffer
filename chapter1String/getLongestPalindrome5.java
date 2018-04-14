package TheArtOfProgramming.chapter1String;

/**
 * program:
 * description: 获取最长的回文字符串
 * author: chenpeng
 * create: 2018/4/7:下午2:17
 **/
public class getLongestPalindrome5 {
    public String getLongest(String str){
        if(str == null){
            return null;
        }
        int len = str.length();
        String tmp  = "";
        String returnStr = str.substring(0,1);
        for(int i = 0;i<len-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                tmp = getLong(str,i,i+1);
                if(returnStr.length()<tmp.length()){
                    returnStr = tmp;
                }
            }
            tmp = getLong(str,i,i);
            if(returnStr.length()<tmp.length()){
                returnStr = tmp;
            }
        }
        return returnStr;
    }
    public String getLong(String str,int left,int right){
        while(left>=0 && right<str.length()){
            if(str.charAt(left)==str.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }
        }
        return str.substring(left+1,right);
    }

    public static void main(String[] args) {
        getLongestPalindrome5 lpd = new getLongestPalindrome5();
        String res = lpd.getLongest("AAACAAACD");
        System.out.println(res);
    }
}
