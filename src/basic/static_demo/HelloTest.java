package basic.static_demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HelloTest {
    public static String output = "";

    public static void foo(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
            output += "1";
        } catch (Exception e) {
            output += "2";
            return;
        } finally {
            output += "3";
        }
        output += "4";
    }

    public static void main(String[] args) {
        HelloA a = new HelloB();
        //a.hello();

        //final修饰的必须初始化，或者构造方法中初始化
//       String s;
//        System.out.println("s="+s);

        //三目运算符
//        int x=4;
//        System.out.println("v+"+((x>4)?99:9.9));


        foo(0);
        foo(1);
        System.out.println(output);
        List arr =new ArrayList();
    }
}
