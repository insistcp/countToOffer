package reviewCountToOffer.Chapter2;

/**
 * Created by cp on 2018/3/26.
 */
public class ReplaceSpace4 {
    public String replace(String str){
        if(str == null){
            return str;
        }
        return str.replace(" ","%20");
    }

    public static void main(String[] args) {
        ReplaceSpace4 rps = new ReplaceSpace4();
        String res = rps.replace("we are happy");
        System.out.println(res);
    }
}
