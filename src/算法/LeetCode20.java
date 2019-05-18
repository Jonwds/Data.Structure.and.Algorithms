package 算法;

import org.junit.Test;

import java.util.Stack;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:
    输入: "()"
    输出: true

示例 2:
    输入: "()[]{}"
    输出: true

示例 3:
    输入: "(]"
    输出: false

示例 4:
    输入: "([)]"
    输出: false

示例 5:
    输入: "{[]}"
    输出: true
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty())
                    return false;

                char c = stack.pop();
                if(s.charAt(i)==')' && c!='(')
                    return false;
                if(s.charAt(i)=='}' && c!='{')
                    return false;
                if(s.charAt(i)==']' && c!='[')
                    return false;
            }
        }
       return stack.isEmpty();
    }
    @Test
    public void test(){
        String s= new String("([])");
        System.out.println(isValid(s));
    }
}
