package reviewCountToOffer.Chapter2;

/**
 * ����ģʽ
 * Created by cp on 2018/3/26.
 */
public class SingleTon2 {
    private SingleTon2(){

    }
    private static SingleTon2 instance=null;
    public static SingleTon2 getInstance(){
        if(instance == null){
            instance = new SingleTon2();
        }
        return instance;
    }

    /**
     * ��������������Ҫ�Ĵ�������̬�ڲ��ࡣ
     * @return
     */
    public static SingleTon2 getInstance2(){
        return nested.instance;
    }
    static  class nested{
        public nested(){
        }
        static  SingleTon2 instance = new SingleTon2();
    }

    public static void main(String[] args) {
        System.out.println(SingleTon2.getInstance2());
        System.out.println(SingleTon2.getInstance2());
        System.out.println(SingleTon2.getInstance2());
    }
}

/**
 * ����ģʽ
 * �̰߳�ȫ��д��
 */
class SingleTon3{
    private SingleTon3(){}
    private static SingleTon3 instance = null;
    public static synchronized SingleTon3 getInstance(){
        if(instance == null){
            instance = new SingleTon3();
        }
        return instance;
    }
}
/**
 * ����ģʽ
 * ͨ����̬����
 */
class SingleTon4{
    private SingleTon4(){}
    private static SingleTon4 instance = new SingleTon4();
    public static synchronized SingleTon4 getInstance(){
        return instance;
    }
}
