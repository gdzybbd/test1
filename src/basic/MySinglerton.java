package basic;

public class MySinglerton {
    //饿汉
    //私有无参构造方法避免使用构造方法创建对象
    private MySinglerton() {
    }
    //非静态内部类会保留一个对外围类的引用，依赖于外部类的创建
    //静态内部类的创建不会依赖于外围类，MySinglerton加载时Singleton没有加入内存
    //当调用getMySingleton时才会创建内部类实现单例（静态内部类只执行一次）
    private static class Singleton{
        private static final MySinglerton INSTANCE = new MySinglerton();
    }

    public static MySinglerton getMySingleton(){
        return Singleton.INSTANCE;
    }


}
