package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = 1; k < 4; k++) {
                    for (int l = 1; l < 4; l++) {
                        if (i + j + k + l == s.length()) {
                            int a = Integer.parseInt(s.substring(0, i));
                            int b = Integer.parseInt(s.substring(i, i + j));
                            int c = Integer.parseInt(s.substring(i + j, i + j + k));
                            int d = Integer.parseInt(s.substring(i + j + k));
                            if (a <= 255 && b <= 255 && c <= 255 && d <= 255) {
                                sb.append(a).append(".").append(b).append(".").append(c).append(".").append(d);
                                if (sb.length() == s.length() + 3) {
                                    res.add(sb.toString());
                                }
                                sb.delete(0, sb.length());
                            }
                        }
                    }
                }
            }

        }
        return res;
    }
}
