package shuzu;

import org.junit.Test;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 凡是和“变位词”、“字母顺序打乱”相关的题目，都考虑统计字母出现的次数。这种方法我叫做 “counter 方法”
 * 将标准词制作成表，然后与目标词对比
 */
public class Solution_1160 {
    public int countCharacters(String[] words, String chars) {
        int count=0;
        int[] a=count(chars);

        for (String str:words){
            int[] b = count(str);
            if (contian(a,b)){
                count+=str.length();
            }
        }
        return count;
    }

    public int[] count(String chars){
        int[] tag=new int[26];
        for (int i = 0; i <chars.length() ; i++) {
            tag[chars.charAt(i)-'a']++;
        }
        return tag;
    }

    public boolean contian(int[]a,int[]b){
        for (int i = 0; i <a.length ; i++) {
            if (a[i]<b[i]){
                return false;
            }
        }
        return true;
    }


    @Test
    public void test(){
        String[] a={"cat","bt","hat","tree"};
        String chars = "atach";
        int i = countCharacters(a, chars);
        System.out.println(i);
    }
}
