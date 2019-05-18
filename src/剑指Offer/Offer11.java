package 剑指Offer;
/*
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Offer11 {
    public static void main(String[] args) {
        System.out.println(numberOf1(15));
    }
    // int数据类型是32位,占4字节;
    // long数据类型是64位,占8字节;
    // float数据类型是单精度、32位,占4字节
    //double数据类型是双精度、64位,占8字节；

    //常规解法,循环的次数等于int的位数,32位
   //将n和i做与运算,如果结果是i就说明对应第i位是1;每次讲i左移一位,再和n做与运算;
    public static int NumberOf1(int n) {
        int i=1;int count=0;
        for(int j=0;j<32;j++){
            if((n&i)==i)
                count++;
            i=i<<1;
        }
        return count;
    }

    //一个整数n减1表示,n的二进制数的最右边的1变成0，如果这个1之后有0,0就全变成1,1之前保持不变
    //例如：1100减去1是1011
    //将一个整数减1再和它自身做与运算,就可以将这个整数最右边的1变成0
    public static int numberOf1(int n) {
        int count=0;
        while (n!=0){
            ++count;
            n=n&(n-1);
        }
        return  count;
    }
}
