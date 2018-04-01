package reviewCountToOffer.Chapter2;

/**
 * Created by cp on 2018/3/27.
 */
public class fibonacciSqunece9 {
    public int getSquene(int n){
        if(n<=2){
            return 1;
        }
        return getSquene(n-1)+getSquene(n-2);
    }
    public int getSquene2(int n){
        int first = 1;
        int second = 1;
        if(n<=2){
            return 1;
        }
        for(int i = 3;i<=n;i++){
            int tmp = second;
            second = first+second;
            first = tmp;
        }
        return second;
    }
    public static void main(String[] args) {
        fibonacciSqunece9 sf = new fibonacciSqunece9();
        for(int i=1;i<=10;i++){
            System.out.println(sf.getSquene2(i));
        }

    }
}
