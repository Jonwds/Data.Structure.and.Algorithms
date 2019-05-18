package 剑指Offer;
/*  二叉搜索树的后序遍历序列
    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
    如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Offer23 {
    // 5,7,6,9,11,10,8
    public static void main(String[] args) {
        int[] aaa={7,9,8,11,13,12,10};
        System.out.println(VerifySquenceOfBST(aaa));
    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0 || sequence==null)
            return false;
        return squenceOfBST(sequence,0,sequence.length);
    }

    public static boolean squenceOfBST(int [] sequence,int left,int right) {
        int length=right-left;
        int root=sequence[right-1];//根节点
        int i=0;
        for (;i<right-1;i++){
            if (sequence[i]>root)
                break;
        }
        int j=i;
        for (;j<right-1;j++){
            if (sequence[j]<root)
                return false;
        }
        boolean leftTree=true;
        if(i>0)
            leftTree = squenceOfBST(sequence,0,i);

        boolean rightTree=true;
        if (i<length-1)
            rightTree=squenceOfBST(sequence,i,length-i-1);

        return leftTree&&rightTree;
    }
    

    public static boolean VerifySquenceOfBST2(int [] sequence) {
        if(sequence.length == 0)
            return false;
        if(sequence.length == 1)
            return true;
        return judge(sequence,0,sequence.length-1);
    }

    public static boolean judge(int[] a,int left,int right){
        if(left >= right)
            return true;
        int i = left;
        while(a[i] < a[right]) //找到右子树开始的位置
            ++i;
        for(int j=i;j<right;j++){ //判断右子树
            if(a[j] < a[right])
                return false;
        }
        return judge(a,left,i-1) && judge(a,i,right-1);
    }
}
