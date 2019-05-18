package 剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;

/*
    大家都知道斐波那契数列，
    现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
        n<=39
 */
public class Offer07 {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        System.out.println(fib2(40));
        long endTime=System.currentTimeMillis();
        System.out.println((endTime-startTime)/1000);
    }
    public static int Fibonacci(int n) {//自己写的
        int[] array={0,1};
        if(n<2)
            return array[n];
        int f0=0,f1=1;
        int f2=0;
        for(int i=2;i<=n;i++){ //自下而上
            f2=f0+f1;
            f0=f1;f1=f2;
        }
        return f2;
    }
    //记忆化搜索,自上而下
    public static int fib(int n){
        int[] arr=new int[n+1];
        for (int i=0;i<arr.length;i++)
            arr[i]=-1;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(arr[n]==-1)
            arr[n]= fib(n-1)+fib(n-2);
        return arr[n];
    }

    //动态规划,自下而上
    public static int fib2(int n){
        int[] arr = new int[n+1];
        arr[0]=0;arr[1]=1;
        for (int i=2;i<arr.length;++i){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];

    }

}
