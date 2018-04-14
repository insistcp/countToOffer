package CountToOffer.chapter2;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 
*   Module Name: 
*  Date Created: 2018-02-05
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-05     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

/**
 * 单例模式的简单实现
 */
public class SingleInstance1 {
    private SingleInstance1(){

    }
    private static SingleInstance1 instance1;
    public static SingleInstance1 getInstance(){
        if(instance1==null){
            instance1  = new SingleInstance1();
        }
        return instance1;
    }
}

/**
 * 单例模式的优秀实现：在类加载时我们便会创建一个类的实例。
 */
class SingleInstance2{
    private SingleInstance2(){

    }
    private static SingleInstance2 instance2= new SingleInstance2();
    public SingleInstance2 getInstance2(){
        return  instance2;
    }
}