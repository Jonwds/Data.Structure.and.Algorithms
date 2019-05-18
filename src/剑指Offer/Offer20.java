package 剑指Offer;

import java.util.ArrayList;
import java.util.Stack;

/*  包含min函数的栈
    定义栈的数据结构，
    请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Offer20 {
    Stack<Integer> stack1=new Stack<>();Stack<Integer> stack2=new Stack<>();
    //利用辅助栈，每次入栈将最小元素压入辅助栈的栈顶保存
    //每次出栈,弹出数据栈顶元素，同时将辅助栈的栈顶元素弹出
    //数据栈:3、4、2、4
    //辅助栈:3、3、2、2
    public void push(int node) {

       if(stack2.size()==0 || node<stack2.peek())
           stack2.push(node);
       else
           stack2.push(stack1.peek());

        stack1.push(node);
    }
    public void pop() {
        if(stack1.size()<=0 || stack2.size()<=0)
            return;
        stack1.pop();stack2.pop();
    }
    public int top() {
        return stack1.peek();
    }

    public int min() {
        if (stack2.size()<=0)
            return -1;
        return stack2.peek();
    }
}
