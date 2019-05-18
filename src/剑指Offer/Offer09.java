package 剑指Offer;
/*
    一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
    求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Offer09 {

    //因为n级台阶，第一步有n种跳法：跳1级、跳2级....跳n级
    //跳1级，剩下n-1级，则剩下跳法是f(n-1)
    //跳2级，剩下n-2级，则剩下跳法是f(n-2)
    //....
    //跳n级,剩下n-n级,则不剩下跳法,取1
    //所以f(n)=f(n-1)+f(n-2)+...+f(1)+ 1
    //因为f(n-1)=f(n-2)+f(n-3)+...+f(1)+1
    //所以f(n)=2*f(n-1)

    //
    //f(n) =       1       ,(n=1)
    //
    //             2*f(n-1),(n>=2)

    public static int JumpFloorII(int target) {
        if(target==1)
            return 1;
        int f3=2; //n=2时,共有2种跳法
        int f2=f3;
        for (int i=3;i<=target;i++){
            f3=2*f2;
            f2=f3;
        }
        return f3;
    }

    public static int JumpFloor2(int target) { //递归
        if(target<=0)
            return -1;
        else if (target==1)
            return 1;
        else
            return 2*JumpFloor2(target-1);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor2(4));
    }

}
