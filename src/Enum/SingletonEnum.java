package Enum;

public enum SingletonEnum {
    /**
     * 枚举实现的单例模式，可以避免序列化和反射问题
     *
     * 枚举序列化是由jvm保证的，每一个枚举类型和定义的枚举变量在JVM中都是唯一的，
     * 在枚举类型的序列化和反序列化上，Java做了特殊的规定：
     * 在序列化时Java仅仅是将枚举对象的name属性输出到结果中，
     * 反序列化的时候则是通过java.lang.Enum的valueOf方法来根据名字查找枚举对象。
     * 同时，编译器是不允许任何对这种序列化机制的定制的并禁用了
     * writeObject、readObject、readObjectNoData、writeReplace和readResolve等方法，
     * 从而保证了枚举实例的唯一性
     */
    INSTANCE;
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}
