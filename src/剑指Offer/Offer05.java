package 剑指Offer;

import java.util.Stack;

/*
    用两个栈来实现一个队列，完成队列尾部插入节点的Push  和  在队列头部删除节点的Pop操作。队列中的元素为int类型。
 */
public class Offer05 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        else {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            if (stack2.isEmpty())
                return -1;
            return stack2.pop();
        }
    }
}
