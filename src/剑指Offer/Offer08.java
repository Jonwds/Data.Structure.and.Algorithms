package 剑指Offer;

import java.util.ArrayList;
import java.util.List;

/*
    一只青蛙一次可以跳上1级台阶，也可以跳上2级。
    求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Offer08 {
    //当n=1时,只有1种跳法;当n=2时,有2种跳法
    //f(n)=f(n-1)+f(n-2)

    public static int JumpFloor(int target) {
        int[] arr=new int[target+1];
        arr[0]=1;arr[1]=2;
        for (int i=2;i<target;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[target-1];
    }


    //递归
    public static int JumpFloor2(int target) {
        int[] arr=new int[target+1];
        for (int i=0;i<arr.length;++i)
            arr[i]=-1;
        if (target==1)
            return 1;
        if (target==2)
            return 2;
        if ( arr[target] == -1 )
            arr[target]=JumpFloor2(target-1)+JumpFloor2(target-2);
        return arr[target];
    }
    //动态规划
    public static int JumpFloorBest(int target) {
        int[] arr = new int[target+1];
        arr[0]=1;arr[1]=1;
        for (int i=2;i<=target;++i){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[target];
    }


    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);
        System.out.println(list.size());
        //System.out.println(JumpFloorBest(5));
    }
}
