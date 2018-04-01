package reviewCountToOffer.Chapter2;

/**
 * Created by cp on 2018/3/27.
 */
public class getTheBinaryNumberOne10 {
    public int getNumberOne(int n){
        int count = 0;
        while(n!=0){
            n = n &(n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(10));
        System.out.println(new getTheBinaryNumberOne10().getNumberOne(10));
    }

}
