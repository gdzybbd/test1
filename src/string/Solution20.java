package string;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution20 {
    private static final Map<Character,Character> map=new HashMap<Character, Character>(){
        {
            put('[',']');put('{','}');put('(',')');put('?','?');
        }
    };
    public boolean isValid(String s) {
        Stack<Character> c = new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
            if (c.empty()){
                c.push(s.charAt(i));
            }else {
                if (c.peek()=='('&&s.charAt(i)==')'){
                    c.pop();
                }else if (c.peek()=='['&&s.charAt(i)==']'){
                    c.pop();
                }else if (c.peek()=='{'&&s.charAt(i)=='}'){
                    c.pop();
                }else {
                    c.push(s.charAt(i));
                }
            }
        }
//        if (c.empty()){
//            return  true;
//        }else {
//            return false;
//        }
        return c.empty();
    }

    /**
     * 使用map来进行比较。
     * @param s
     * @return
     */
    public boolean isValid2(String s){
        LinkedList<Character> list=new LinkedList<>();
        list.addLast('?');
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)){
                list.addLast(c);
            }else if (list.get(list.removeLast())!=c){
                return false;
            }
        }
        return list.size()==1;

    }


    @Test
    public void test(){
        boolean valid = isValid("()[]{}");
        System.out.println(valid);
    }

    @Test
    public void test1(){
        int[] a ={2,1,9,5,4,6,5,1,2,8,13,9};
        Arrays.sort(a);
        List<Integer> list =new ArrayList<>();
        for (int i = 0; i <a.length ; i++) {
            if (!list.contains(a[i])){
                list.add(a[i]);
            }
        }
        Integer[] objects = list.toArray(new Integer[0]);
        for (int i = 0; i < objects.length; i++) {
            Integer object = objects[i];
            System.out.println(object);
        }
    }

}
