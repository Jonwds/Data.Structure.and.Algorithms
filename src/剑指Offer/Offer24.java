package 剑指Offer;

import java.util.ArrayList;
import java.util.Stack;

/*
    输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
    路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Offer24 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left=new TreeNode(5);root.right=new TreeNode(12);
        root.left.left=new TreeNode(4);root.left.right=new TreeNode(7);
        ArrayList<ArrayList<Integer>> lists = new Offer24().FindPath(root, 22);
        for (ArrayList<Integer> arrayList:lists ){
            System.out.println(arrayList);
        }
    }
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) { this.val = val; }
     }

    private  ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private  ArrayList<Integer> list=new ArrayList<>();
    private int sum=0;
    public  ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            if (root==null)
                return result;
            sum+=root.val;
            list.add(root.val);
            //如果是叶子节点,并且路径上节点值的和等于输入的值,则打印出这条路径
            boolean isLeaf= root.left==null && root.right==null;
            if(target==sum && isLeaf){
                result.add(new ArrayList<>(list));
            }
            //如果不是叶子节点,遍历它的子节点
            if(root.left!=null)
                FindPath(root.left,target);
            if(root.right!=null)
                FindPath(root.right,target);
            //返回父节点,即删除当前节点
            sum-=root.val;
            list.remove(list.size()-1);
            return result;
        }

        //别人的版本
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> templist = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root,int target) {
        if(root == null) return listAll;
        templist.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(templist));
        FindPath2(root.left, target);
        FindPath2(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }
}
