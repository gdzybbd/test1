package string;

import org.junit.Test;

/**
 *给定两个以字符串形式表示的非负整数 num1 和 num2，
 * 返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution43 {
    /**     index 0 1 2
     *            1 2 3
     *              3 4

     *          0 0 0 0
     * index    0 1 2 3
     * 乘机结果为 0y 或者 xy
     * 低位在i+j  高位在i+j+1
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int[] temp=new int[num1.length()+num2.length()];
        for (int i = num2.length()-1; i >=0 ; i--) {
            int n2=num2.charAt(i)-'0';
            for (int j = num1.length()-1; j >=0 ; j--) {
                int n1=num1.charAt(j)-'0';
                int sum=(temp[i+j+1]+n1*n2);
                temp[i+j+1]=sum%10;
                temp[i+j]+=sum/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <temp.length ; i++) {
            if (i==0&&temp[i]==0){
                continue;
            }
            sb.append(temp[i]);
        }
        return sb.toString();
    }

    @Test
    public void test(){
        String multiply = multiply("123", "10");
        System.out.println(multiply);
    }
}
