package offer;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：
 * 0 <= 链表长度 <= 10000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution06 {
    public int[] reversePrint(ListNode head) {
        if (head==null){
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        ListNode temp=head.next; //temp=head
        stack.push(head.val);
        int count=1;
        while (temp!=null){
            stack.push(temp.val);
            temp=temp.next;
            count++;
        }
        int[] res =new int[count]; //stack.size()
        for (int i = 0; i <res.length ; i++) {
            res[i]=stack.pop();
        }
        return res;
    }
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 链表反转后按顺序加入数组即可
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        ListNode pre =null;
        while (head!=null){
            ListNode next=head;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempList = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tempList;

    }

    /**
     * 逆序打印链表
     * @param head
     */
    public void reversePrint2(ListNode head) {
        if (head==null){
            return;
        }
        reversePrint2(head.next);
        System.out.println(head.val);
    }

    /**
     * 根据逆序打印的思路，使用递归得到数组
     * @param head
     * @return
     */
    public int[] reversePrint3(ListNode head){
        int count=count(head);
        int[] res=new int[count];
        reversePrintHelper(head, res, count - 1);
        return res;
    }

    private void reversePrintHelper(ListNode head, int[] res, int i) {
        if (head==null){
            return;
        }
        reversePrintHelper(head.next,res,i-1);
        res[i]=head.val;
    }

    private int count(ListNode head) {
        int res=0;
        ListNode temp =head;
        while (temp!=null){
            temp=temp.next;
            res++;
        }
        return res;
    }
}



