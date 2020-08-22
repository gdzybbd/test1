package shuzu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， 
 * words[i] + words[j] ，可拼接成回文串。
 * 示例 1:
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]]
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 示例 2:
 * 输入: ["bat","tab","cat"]
 * 输出: [[0,1],[1,0]]
 * 解释: 可拼接成的回文串为 ["battab","tabbat"]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i <words.length ; i++) {
            for (int j = 0; j <words.length ; j++) {
                if (j!=i){
                   if (flag(words[i],words[j])){
                       ArrayList<Integer> objects = new ArrayList<>();
                        objects.add(i);
                        objects.add(j);
                        res.add(objects);
                   }
                }
            }
        }
        return res;
    }

    public boolean flag(String s1,String s2){
        String s=s1+s2;
        int l=0,r=s.length()-1;
        while (l<r){
            if (s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    @Test
    public void test(){
     String[] temp={"abcd","dcba","lls","s","sssll"};
     String[] temp2={"bat","tab","cat"};

     String[] temp3={};
        List<List<Integer>> lists = palindromePairs(temp3);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }

}
