package lianbiao;

import org.junit.Test;

import java.util.*;

/**
 *
 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 示例1:
 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
 示例2:
 输入：[1, 1, 1, 1, 2]
 输出：[1, 2]
 提示：
 链表长度在[0, 20000]范围内。
 链表元素在[0, 20000]范围内。
 */
public class Solution02_1 {
    //去重首先想到hashset
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null){
            return null;
        }
        List<Integer> list =new ArrayList<>();
        ListNode pre=head;
        //pre.next=head;
        ListNode cur=head.next;
        list.add(head.val);
        while (cur!=null){
            int i=cur.val;
            if (!list.contains(i)) {
                list.add(i);
//                head.next=cur;
//                cur=head;
//                cur=cur.next;
                pre=cur;
                cur=cur.next;
            }else {
                pre.next=cur.next;//1
                cur=cur.next;

            }
        }
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode removeDuplicateNodes1(ListNode head){
        if (head == null) {
            return head;
        }
        Set<Integer> set= new HashSet<Integer>();
        set.add(head.val);
        //此处并没有新建一个节点，只是个head节点新创建一个别名，两个是一个对象
        //head只是保存了这个对象的最初地址
        //而pre相当于一个指针进行移动
        ListNode pre= head;
        while (pre.next!=null){
            ListNode cur=pre.next;
            if (set.add(cur.val)){
                pre=pre.next;
            }else {
                pre.next=pre.next.next;
            }
        }
        pre.next=null;
        return head;
    }



    @Test
    public void test1(){
        ListNode head= new ListNode(1);
        ListNode pre= head;
        pre.val=2;
        System.out.println(head.val);
        System.out.println(head);
        System.out.println(pre);

        User a= new User(1);
        User b =a;
        b.i=2;
        System.out.println(a.i);
        System.out.println(a);
        System.out.println(b);
    }

    class User{
        int i ;

        public User(int i) {
            this.i = i;
        }
    }
}
