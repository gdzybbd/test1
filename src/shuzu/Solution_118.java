package shuzu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class Solution_118 {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> list=new ArrayList<>();
        if (numRows==0){
            return list;
        }
        list.add(new ArrayList<>());
        list.get(0).add(1);

        for (int i = 1; i <numRows ; i++) {
            List<Integer> list1=new ArrayList<>();
            List<Integer> preList=list.get(i-1);

            list1.add(1);
            for (int j = 1; j <i ; j++) {
                list1.add(preList.get(j-1)+preList.get(j));
            }

            list1.add(1);
            list.add(list1);
        }
        return list;
    }

    /**
     * 杨辉三角输入指定数输出对应的行
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow119(int rowIndex) {
        if (rowIndex==0){
            return null;
        }
        List<List<Integer>> lists=new ArrayList<>();
        lists.add(new ArrayList<>(1));
        if (rowIndex==1){
            return lists.get(0);
        }
        for (int i = 1; i <rowIndex ; i++) {
            List<Integer> list=new ArrayList<>();
            List<Integer> prelist=lists.get(i-1);

            list.add(1);

            for (int j = 1; j <i ; j++) {
                list.add(prelist.get(j-1)+prelist.get(j));
            }


            list.add(1);

            lists.add(list);
        }
        return  lists.get(rowIndex);
    }

    /**
     * 递归方法
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow119_2(int rowIndex){
        List<Integer> list=new ArrayList<>();
        //递归出口
        if (rowIndex<0){
            return list;
        }
        if (rowIndex==0){
            list.add(1);
            return list;
        }
        //递归
        List<Integer> per=getRow119_2(rowIndex-1);
        //头
        list.add(1);

        for (int i = 1; i <rowIndex ; i++) {
            list.add(per.get(i-1)+per.get(i));
        }
        //尾
        list.add(1);
        return list;
    }

    /**
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow119_3(int rowIndex){
        List<Integer> pre =new ArrayList<>();
        List<Integer> cur =new ArrayList<>();

        for (int i = 0; i <rowIndex ; i++) {
            cur=new ArrayList<>();
            for (int j = 0; j <i ; j++) {
                if (i==0||j==i){
                    cur.add(1);
                }else {
                    cur.add(pre.get(j-1)+pre.get(j));
                }
            }
            pre=cur;
        }
        return cur;
    }
    //https://leetcode-cn.com/problems/pascals-triangle-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--28/
//    public List<Integer> getRow119_4(int rowIndex){
//
//
//    }
    /**
     * 打沙漏
     */

    @Test
    public void test(){
        for (int i = 0; i <=10 ; i++) {
            if (i<5){
                for (int j = 0; j <i ; j++) {
                    System.out.print(" ");
                }
                for (int j = 10-i*2; j >0 ; j--) {
                    System.out.print("*");
                }
            }else {
                for (int j = 0; j <10-i ; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j <2*(i-5) ; j++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    @Test
    public void test2() {
        int weigh =11;
        for (int i = 0; i < weigh; i++) {
            if (i < weigh / 2) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= weigh - 2 * i; j++) {
                    System.out.print("*");
                }
            } else {
                for (int j = 1; j <= weigh - i - 1; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= 2 * (i - weigh / 2) + 1; j++) {
                    System.out.print("*");
                }
            }
            System.out.println();

        }
    }
}
