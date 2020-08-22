package string;
/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution46 {
    public int translateNum(int num) {
        String str=String.valueOf(num);
        int count=1;
        if (num<=25&&num>=10){
            return 2;
        }
        for (int i = 1; i < str.length(); i++) {
            if (Integer.parseInt(String.valueOf(str.charAt(i-1)))*10+Integer.parseInt(String.valueOf(str.charAt(i)))<=25){
                count++;
            }
        }

        return count;
    }
}
