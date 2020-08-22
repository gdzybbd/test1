package shuzu;

import java.util.Stack;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：
 * 要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是                    [1,  1,  4,  2,  1,  1,  0,  0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution739 {
    /**
     * 暴力解法：遍历数组，
     * i-1<i 赋值1
     * i-1>i 找到比i-1大的j 赋值j-i
     * @param T
     * @return
     * 精简版
     *     public int[] dailyTemperatures(int[] T) {
     *         int length = T.length;
     *         int[] res = new int[length];
     *         for (int i = 0; i < length; i++) {
     *             for (int j = i + 1; j < length; j++) {
     *                 if (T[j] > T[i]) {
     *                     res[i] = j - i;
     *                     break;
     *                 }
     *             }
     *         }
     *         return res;
     *     }
     */
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] res = new int[length];
        for (int i = 1; i < length; i++) {
            if (T[i] > T[i - 1]) {
                res[i - 1] = 1;
            } else {
                int j = i - 1;
                while (i < length) {
                    if (T[i] > T[j]) {
                        res[j] = i - j;
                        i = j + 1;
                        break;
                    }
                    if (i == length - 1) {
                        res[j] = 0;
                        i = j + 1;
                    }
                    i++;
                }
            }
        }
        return res;
    }

    /**
     * 利用栈
     * @param T
     * @return
     */
    public int[] dailyTemperaturesStack(int[] T){
        int length = T.length;
        int[] res = new int[length];
        Stack stack=new Stack();
        for (int i = 0; i <length ; i++) {
            while (!stack.empty()&&T[i]>T[(int) stack.peek()]){
                int index= (int) stack.pop();
                res[index]=i-index;
            }
            //栈中存放下标
            stack.push(i);
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] T) {
        int[] stack = new int[T.length];
        int top = -1;
        int[] res = new int[T.length];
        for (int i = 0; i <T.length ; i++) {
            while (top>0&&T[i]>stack[top]){
               int index=stack[top--];
               res[index]=i-index;
            }
            stack[++top]=i;
        }
        return res;
    }

    public int[] dailyTemperatures3(int[] T) {
        int length = T.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            int h = T[i];
            //后值小于前值 下标入栈
            if (stack.isEmpty() || h <= T[stack.peek()]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                res[top] = i - top;
                //1.逐一和栈内下标代表的值比较，弹出小的值下表 2.当栈空把当前值入栈
                i--;
            }
        }
        return res;
    }

    public int[] dailyTemperatures4(int[] T) {
        int length = T.length;
        int[] result = new int[length];

        //从右向左遍历
        for (int i = length - 2; i >= 0; i--) {
            // j+= result[j]是利用已经有的结果进行跳跃
            //因为result[j]！=0那么比它大的数就在它的值的位置直接跳跃过去比较。
            for (int j = i + 1; j < length; j+= result[j]) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] a =new int[]{1,2,10,3,1,2,4,2};
        Solution739 s=new Solution739();
        int[] ints = s.dailyTemperatures4(a);
        for (int i :ints){
            System.out.println(i);
        }
    }
}
