package 剑指Offer;

import org.junit.Test;

import java.util.Stack;

/*  二叉搜索树与双向链表
    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Offer26 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) { this.val = val; }
    }
    @Test
    public void test(){
        TreeNode root =new TreeNode(10);
        root.left=new TreeNode(6); root.right=new TreeNode(14);
        root.left.left=new TreeNode(4); root.left.right=new TreeNode(8);
        root.right.left=new TreeNode(12); root.right.right=new TreeNode(16);
        TreeNode list = Convert2(root);
        while(list != null){
            System.out.print(list.val+"<->");
            list=list.right;
        }
    }
    
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode last = ConvertNode(pRootOfTree, null);
        TreeNode head = last;
        while(head!=null && head.left!=null)
            head=head.left;
        return head;
    }
    public TreeNode ConvertNode(TreeNode root,TreeNode last){
        if(root==null)
            return null;

        if (root.left!=null)
            last=ConvertNode(root.left,last);

        root.left=last;
        if (last!=null)
            last.right=root;
        last=root;

        if (root.right!=null)
            last=ConvertNode(root.right,last);

        return last;
    }
    
    //别人的版本
    public  TreeNode Convert2(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        TreeNode node=pRootOfTree;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        Connection(node,stack);

        node=stack.get(0);
        return node;
    }

    public  void Connection(TreeNode root,Stack<TreeNode> stack){
        if(root==null)
            return;
        
        Connection(root.left,stack);

        if(stack.isEmpty()) {
            stack.push(root);
        }else{
            stack.peek().right=root;
            root.left=stack.peek();
            stack.push(root);
        }
        
        Connection(root.right,stack);
    }

    //终极版递归
    public TreeNode Convert3(TreeNode pRootOfTree) {
        TreeNode root = pRootOfTree;
        if(root==null)
            return null;
        if(root.left==null&&root.right==null)
            return root;
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert3(root.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while(p!=null&&p.right!=null){
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            p.right = root;
            root.left = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert3(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;
    }

}
