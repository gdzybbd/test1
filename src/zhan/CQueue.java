package zhan;

import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CQueue {
    /*
    使用java的同学请注意，如果你使用Stack的方式来做这道题，会造成速度较慢；
    原因的话是Stack继承了Vector接口，而Vector底层是一个Object[]数组，那么就要考虑空间扩容和移位的问题了。
     可以使用LinkedList来做Stack的容器，因为LinkedList实现了Deque接口，
     所以Stack能做的事LinkedList都能做，其本身结构是个双向链表，扩容消耗少。
     但是我的意思不是像100%代码那样直接使用一个LinkedList当做队列，那确实是快，但是不符题意。
     */
    LinkedList<Integer> it1;
    LinkedList<Integer> it2;
    public CQueue() {
        it1=new LinkedList<>();
        it2=new LinkedList<>();
    }

    public void appendTail(int value) {
        it1.add(value);
    }

    public int deleteHead() {
        if (it2.isEmpty()){
            if (!it1.isEmpty()){
                while (!it1.isEmpty()){
                    it2.add(it1.pop());
                }
             return it2.pop();
            }else {
                return -1;
            }
        }else {
           return it2.poll();
        }
    }
}
