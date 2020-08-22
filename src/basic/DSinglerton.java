package basic;

public class DSinglerton {
    //volatile 防止指令重排序。对象的创建过程 会初始化0值，如果在此发生并发，可能会导致未初始化值则使用
    private volatile static DSinglerton ds;

    private DSinglerton(){

    }

    public static DSinglerton getInstance(){
        if (ds==null){
            synchronized (DSinglerton.class){
                if (ds==null){
                    ds=new DSinglerton();
                }
            }
        }
        return ds;
    }
}
