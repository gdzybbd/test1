package basic;

import org.junit.Test;

import java.util.Stack;

public class StackToQueen {
    private Stack stackA =new Stack();
    private Stack stackB =new Stack();


    public Object add(Object i){
        //存之前如果取过那个A一定是空的
//        if (!stackA.empty()){
//            transfer();
//        }
       return stackA.push(i);
    }

    private void transfer() {
        while (!stackA.empty()){
            stackB.push(stackA.pop());
        }
    }

    public Object get(){
        if (stackB.empty()){
            if (stackA.empty()){
               return null;
            }else {
                transfer();
            }
        }

        return stackB.pop();
    }
    @Test
    public void test(){
        StackToQueen sq=new StackToQueen();
        sq.add(1);
        sq.add(2);
        sq.get();
        sq.add(3);
        sq.get();
        System.out.println(sq.get());
    }
}
