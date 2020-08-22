package string;

/**
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0,step=2*k; i <s.length() ; i+=step) {
            int right =Math.min(chars.length-1,i+k-1);
            swap(chars,i,right);
        }
        return new String(chars);
    }

    private void swap(char[] chars, int i, int right) {
        while (i<right){
            char temp = chars[i];
            chars[i++]=chars[right];
            chars[right--]=temp;
        }
    }
}
