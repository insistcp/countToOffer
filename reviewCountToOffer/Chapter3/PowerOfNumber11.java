package reviewCountToOffer.Chapter3;

/**
 *
 * 求一个数的n次方，注意细节；
 * Created by cp on 2018/3/28.
 */
public class PowerOfNumber11 {
    public double getPowerOfNumber(int base,int n){
        if(base == 0 && n<0){
            throw new IllegalArgumentException("出书不能够为0");
        }
        Boolean flag = false;
        if(n<0){
            flag = true;
            n = -n;
        }
        double res = power(base,n);
        if(flag){
            res = 1/res;
        }
        return res;
    }
    public double power(int base,int n){
        if(base==1 || n==0||base == 0){
            return 1;
        }
        if(n==1){
            return base;
        }
        double res = power(base,n>>1);
        res = res*res;
        if(n%2==1){
            res = res*base;
        }
        return res;
    }

    public static void main(String[] args) {
        PowerOfNumber11 pon = new PowerOfNumber11();
        double res = pon.getPowerOfNumber(-10,-3);
        System.out.println(res);
    }
}
