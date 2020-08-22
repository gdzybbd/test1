package string;

import org.junit.Test;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        StringBuilder ans =new StringBuilder();
        int num=0;
        for (int i = a.length()-1,j=b.length()-1; i >=0||j>=0 ; i--,j--) {
            int sum=num;
            sum+=(i>=0?a.charAt(i)-'0':0);
            sum+=(j>=0?b.charAt(j)-'0':0);
            num=sum/2;
            ans.append(sum%2);
        }
        if (num==1){
            ans.append(1);
        }
        return ans.reverse().toString();
    }

    @Test
    public void ti() {
        //System.out.println(1/10); --> 0
        String s = addBinary("1111", "1111");
        System.out.println(s);
    }
}
