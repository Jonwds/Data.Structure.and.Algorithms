package 剑指Offer;

import java.util.ArrayList;
import java.util.Stack;

/*  按之字形打印二叉树
    请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
    第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class offerP176 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) { this.val = val; }
    }
/*
测试用例:
{8,6,10,5,7,9,11}

对应输出应该为:

[[8],[10,6],[5,7,9,11]]

你的输出为:

[[8],[6,10],[11,9,7,5]]
 */
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);root.right=new TreeNode(3);
        root.left.left=new TreeNode(4); root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);root.right.right=new TreeNode(7);
        ArrayList<ArrayList<Integer>> lists = Print(root);
        for (ArrayList<Integer> list:lists)
            System.out.println(list);
    }
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Stack<TreeNode>> stack = new ArrayList<>(2);
        int current=0,next=1;
        stack.add(new Stack<TreeNode>());stack.add(new Stack<TreeNode>());
        if (pRoot==null)
            return result;

        stack.get(current).push(pRoot);
        while(stack.get(current).size()>0 || stack.get(next).size()>0){
            TreeNode node = stack.get(current).pop();
            list.add(node.val);
            if(current==0) { //奇数层,先保存下一层的左子节点,再保存右子节点
                if (node.left!=null)
                    stack.get(next).push(node.left);
                if (node.right!=null)
                    stack.get(next).push(node.right);
            }else { // 偶数层,先保存下一层的右子节点,再保存左子节点
                if (node.right != null)
                    stack.get(next).push(node.right);
                if (node.left != null)
                    stack.get(next).push(node.left);
            }
            if (stack.get(current).isEmpty()) { //当前层打印完毕
                result.add(list);
                list=new ArrayList<>();
                current=1-current;
                next=1-next;
            }
        }
        return result;
    }


}
