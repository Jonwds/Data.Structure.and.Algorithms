package 算法;

import org.junit.Test;

import java.util.Stack;

/*  逆波兰表达式求值
根据逆波兰表示法，求表达式的值。

有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

说明：

整数除法只保留整数部分。
给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
示例 1：
    输入: ["2", "1", "+", "3", "*"]
    输出: 9
    解释: ((2 + 1) * 3) = 9

示例 2：
    输入: ["4", "13", "5", "/", "+"]
    输出: 6
    解释: (4 + (13 / 5)) = 6
 */
public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                int a = stack.pop();int b = stack.pop();
                Integer result = Integer.valueOf(a)+Integer.valueOf(b);
                stack.push( result );
            }else if(tokens[i].equals("-")){
                int a = stack.pop();int b = stack.pop();
                Integer result = b-a;
                stack.push( result );
            }else if(tokens[i].equals("*")){
                int a = stack.pop();int b = stack.pop();
                Integer result =b * a;
                stack.push( result );
            }else if(tokens[i].equals("/")){
                int a = stack.pop();int b = stack.pop();
                Integer result = b / a;
                stack.push( result );
            }else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
    @Test
    public void test(){
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }


}
