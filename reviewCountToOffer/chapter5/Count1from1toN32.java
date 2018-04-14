package chapter5;

/**
 * 给定一个数n 让你统计1-n中所有的数字中含有的1的个数
 */
public class Count1from1toN32 {
    public int countOne(int n){
        int count =0 ;
        for(int i = 1;i<=n;i++){
            count += getOne(i);
        }
        return count;
    }
    public int getOne(int n){
        int count = 0;
        while(n>0){
            if(n%10==1){
                count++;
            }
            n  = n/10;
        }
        return count;
    }
    public int count1(int n){
        int count = 0;
        int current = 0;
        int base = 1;
        int remain = 0;
        while(n>0){
            current = n%10;
            n = n/10;
            if(current>1){
                count+=(n+1)*base;
            }else if(current==1){
                count+=(n*base)+(remain+1);
            }else{
                count+=n*base;
            }
            remain = remain+base*current;
            base= base*10;
        }
        return count;
    }

    public static void main(String[] args) {
        Count1from1toN32 cfn = new Count1from1toN32();
        int res  = cfn.count1(212);
        System.out.println(res);
        int res2 = cfn.countOne(212);
        System.out.println(res2);
    }
}
