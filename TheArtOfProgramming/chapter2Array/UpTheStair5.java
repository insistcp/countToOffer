package TheArtOfProgramming.chapter2Array;

import java.util.Arrays;

/**
 * program:
 * description: 上台阶问题 递推原理
 * author: chenpeng
 * create: 2018/4/14:下午4:52
 **/
public class UpTheStair5 {
    /**
     * program:
     * description: 对于每一次可以跳一阶台阶或者两节台阶而言
     * author: chenpeng
     * create: 2018/4/14:下午5:00
     **/
    public int upTheStair(int n){
        if(n==1){
            return 1;
        }else if(n == 2){
            return 2;
        }
        int last = 2,lastLast =1,current=0;
        for(int i =3;i<=n;i++){
            current = last+lastLast;
            lastLast = last;
            last = current;
           //System.out.println(current);
        }
        return current;
    }

    /**
     * program:
     * description: 对于一次可以跳1，2，3阶台阶而言
     *  假设当前的台阶数量大于3，那么我们跳台阶的选择有，第一次跳一阶 f(n) = f(n-1)+f(n-2)+f(n-3)
     * author: chenpeng
     * create: 2018/4/14:下午5:01
     **/
    public int upTheStair2(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else if(n==3){
            return 4;
        }
        int preprepre = 1,prepre = 2,pre =4,curr = 0;
        for(int i =4;i<=n;i++){
            curr = preprepre+prepre+pre;
            preprepre = prepre;
            prepre= pre;
            pre = curr;
            System.out.println(curr);
        }
        return curr;
    }

    /**
     * program:
     * description: 生兔子问题，假设现在🈶️一对兔子，这对兔子每一个月会剩下一对兔子，并且生下的小兔子在第三个月又开始生兔子，现在问你n个月之后有多少只兔子；
     * author: chenpeng
     * create: 2018/4/14:下午5:25
     **/
    public int getRabbit(int n){
        if(n == 1){
            return 2;
        }else if(n==2){
            return 4;
        }
        int prepre =1,pre =2,curr = 0;
        for(int i =3;i<=n;i++){
            curr = prepre+pre;
            prepre = pre;
            pre = curr;
        }
        return curr*2;
    }
    public int exchangeMoney(int[] money,int count){
        if(count<=0){
            return 0;
        }
        int arr[] = new int[count+1];
        arr[0] = 1;
        //Arrays.fill(arr,1);
        for (int i = 0; i <money.length; i++)   //i从0 ~ 3     因为每个arr[j]都要有一次是假设兑换了dimes[i]，所以我们要遍历一次
        {
            for (int j = money[i]; j <= count; j++)
                //求，arr[j]的时候，可以看出arr[j] = arr[j] + arr[j-dimes[i]]，
                //对应着上面的递归方式：arr[j]就是coinExchangeRecursion(n, m-1)，
                //arr[j-dimes[i]]就是coinExchangeRecursion(n-dimes[m-1], m)
                arr[j] += arr[j-money[i]];
            System.out.println(Arrays.toString(arr));

        }
        return arr[count];
    }
    public static void main(String[] args) {
        UpTheStair5 upTheStair5 = new UpTheStair5();
        //int res  = upTheStair5.upTheStair2(10);
        //System.out.println(res);
        int res = upTheStair5.exchangeMoney(new int[]{1,2,5,10},5);
        System.out.println(res);
    }
}
