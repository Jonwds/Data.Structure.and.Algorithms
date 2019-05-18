package 剑指Offer;

public class offerP103 {
    public static void main(String[] args) {
        System.out.println(change(8,7));
    }

    //用一条语句判断一个整数是不是2的整数次方
    public static boolean judge(int n){
        return (n&(n-1))==0;
    }
    //输入两个整数m和n,计算需要改变m的二进制表示中的多少位才能得到n
    //例如：10的二进制位1010,13的二进制位1101,需要改变1010中的3位才能得到1101
    //1.求m和n的异或; 2.计算异或中1的位数
    public static int change(int m,int n){
        int i=m^n;
        int count=0;
        while(i!=0){
            i=i&(i-1);
            count++;
        }
        return count;
    }
}
