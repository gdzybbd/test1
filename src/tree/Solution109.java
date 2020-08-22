package tree;

import java.util.ArrayList;
import java.util.List;

public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        //相当于一根绳子 提中间的当树的根
        List<ListNode> list =new ArrayList<>();
        ListNode temp=head;
        while (temp!=null){
            list.add(temp);
            temp=temp.next;
        }
        return f(list);
    }

    private TreeNode f(List<ListNode> list) {

        if (list.isEmpty()){
            return null;
        }
        if (list.size()==1){
            return new TreeNode(list.get(0).val);
        }
        TreeNode r=new TreeNode(list.get(list.size()/2).val);
        r.left=f(list.subList(0,list.size()/2));
        r.right=f(list.subList(list.size()/2+1,list
        .size()));
        return r;
    }
    //优化版
    //将链表中的值遍历进数组中 return sortedListToBSTHelper(list, 0, list.size() - 1);
    TreeNode sortedListToBSTHelper(List<Integer> list, int left, int right){
        if (right<left){
            return null;
        }
        int mid =left+(right-left)/2;
        TreeNode r =new TreeNode(list.get(mid));
        r.left=sortedListToBSTHelper(list,left,mid-1);
        r.right=sortedListToBSTHelper(list,mid+1,right);
        return r;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
