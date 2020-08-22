package Enum;

import Enum.interFace.food;

public class EnumDemo {
    public static void main(String[] args) {
        //可以直接引用
        Day day=Day.MONDAY;

        System.out.println(day.getStr());

        Day[] values = Day.values();

        //用枚举实现策略模式

        String str=Day2.First.getInfo();
        String str2=Day2.Second.getInfo();
        System.out.println(str);
        System.out.println(str2);

        //由于java单继承，枚举类继承了抽象的ENUM，但是可以实现接口
        Day3.FOOD.eat();
        Day3.SPORT.run();

        //通过实现接口来管理枚举的实例
        food[] valuse = Meal.COFFEE.getValuse();
        food.Coffee.BLACK_COFFEE.eat();
//        for (food f:valuse){
//            System.out.println(f);
//            f.eat();
//
        //switch
        switch (day){
            case MONDAY:
                System.out.println("星期一");
                break;
            case FRIDAY:
                System.out.println("星期二");
                break;
                default:
                    System.out.println("其他");
        }

        //枚举类实现单例模式
        SingletonEnum.INSTANCE.setName("a");
        SingletonEnum.INSTANCE.setName("a");
        String name = SingletonEnum.INSTANCE.getName();
        System.out.println(name);

    }
}
