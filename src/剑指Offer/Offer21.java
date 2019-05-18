package 剑指Offer;

import java.util.ArrayList;
import java.util.Stack;

/*
    输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
    假设压入栈的所有数字均不相等。
    例如序列1,2,3,4,5是某栈的压入顺序，
    序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
    但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Offer21 {
    public static void main(String[] args) {
        int[] push ={1,2,3,4,5};
        int[] pop={4,3,5,1,2};
        System.out.println(IsPopOrder2(push,pop));
    }
    //自己写的
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length==0 || popA.length==0)
            return false;
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack=new Stack<>() ;
        int j=0;
        for(int i=0;i<popA.length;i++){
            if (stack.size()==0)
                stack.push(pushA[j++]);
            while(stack.peek() != popA[i]){
                if(j >= popA.length)
                    break;
                stack.push(pushA[j++]);
            }
            arrayList.add(stack.pop());
        }
        for (int i=0;i<popA.length;i++){
            if (popA[i]!=arrayList.get(i))
                return false;
        }
        return true;
    }
    //自己的优化了一下
    public boolean IsPopOrderMine(int [] pushA,int [] popA) {
        if (pushA.length==0 || popA.length==0)
            return false;
        Stack<Integer> stack=new Stack<>() ;
        int j=0;
        for(int i=0;i<popA.length;i++){
            if (stack.size()==0)
                stack.push(pushA[j++]);
            while(stack.peek() != popA[i]){
                if(j >= popA.length)
                    return false;;
                stack.push(pushA[j++]);
            }
            stack.pop();
        }
        return stack.isEmpty();
    }


    //别人的
    public static boolean IsPopOrder2(int [] pushA,int [] popA) {
        if (pushA.length==0 || popA.length==0)
            return false;
        Stack<Integer> stack =new Stack<>();
        int index = 0;
        for (int i=0;i<pushA.length;++i){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek()==popA[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

}
