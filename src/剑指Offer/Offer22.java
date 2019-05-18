package 剑指Offer;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;

/*  从上往下打印二叉树
    从上往下打印出二叉树的每个节点，同层节点从左至右打印。(层序遍历)
 */
public class Offer22 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.left.left=new TreeNode(3);
        root.left.left.left=new TreeNode(2);
        ArrayList<ArrayList<Integer>> lists = Print(root);
        for (ArrayList<Integer> list:lists)
            System.out.println(list);
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)
            return null;
        queue.offer(root);
        while(queue.size()>0){
            TreeNode node = queue.peek();
            queue.poll();
            arrayList.add(node.val);
            if(node.left!=null)
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);
        }
        return arrayList;
    }

    //优化版
    public static ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        ArrayList<Integer> list =new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root==null)
            return list;
        queue.add(root);
        while(queue.size()>0){
            TreeNode node = queue.remove(0);
            list.add(node.val);
            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null)
                queue.add(node.right);
        }
        return list;
    }


    //从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue=new ArrayList<>();
        if (pRoot==null)
            return result;
        int level=0;
        int toBePrinted=1;
        queue.add(pRoot);
        while (queue.size()>0){
            TreeNode node = queue.remove(0);
            if(node.left!=null){
                queue.add(node.left);
                level++;
            }
            if(node.right!=null){
                queue.add(node.right);
                level++;
            }
            list.add(node.val);
            toBePrinted--;
            if (toBePrinted==0){
                result.add(list);
                list=new ArrayList<>();
                toBePrinted=level;
                level=0;
            }
        }
        return result;
    }



}
