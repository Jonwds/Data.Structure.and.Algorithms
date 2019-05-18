package 剑指Offer;
/*  数值的整数次方
    给定一个double类型的浮点数base和int类型的整数exponent。
    求base的exponent次方。
 */
public class Offer12 {
    public static void main(String[] args) {
        System.out.println(66&0x1);
    }
    public static double PowerMyself(double base, int exponent) {
        if(base==0.0)//错误！！注意判断double类型相等不能用==
            return 0.0;
        if (exponent==0){
            return 1.0;
        }else if (exponent>0){
            double result=1.0;
            for (int i=0;i<exponent;i++)
                result=result*base;
            return result;
        }else {
            exponent=exponent*-1;
            double result=1.0;
            for (int i=0;i<exponent;i++)
                result=result*base;
            return 1/result;
        }
    }
    public static double Power(double base, int exponent) {
        boolean invalidInput =false;
        if(Double.compare(base,0.0)==0 && exponent<0){
            invalidInput=true;
            System.out.println("非法输入!");
            return 0.0;
        }
        int absExponent = exponent;
        if (exponent<0)
            absExponent=-exponent;
        double result=PowerWithAbsExponentBetter(base,absExponent);
        if (exponent<0)
            result= 1.0/result;
        return result;
    }
    public static double PowerWithAbsExponent(double base, int exponent) {
        double result=1.0;
        for (int i=0;i<exponent;i++){
            result*=base;
        }
        return result;
    }
    //       | a^(n/2)*a^(n/2) ，n为偶数
    //a^n= |
    //      | a^(n-1/2)*a^(n-1/2)*a , n为奇数
    //用位运算符代替乘除法和求余运算
    public static double PowerWithAbsExponentBetter(double base, int exponent) {
        if(exponent==0)
            return 1;
        if (exponent==1)
            return base;
        double result = PowerWithAbsExponentBetter(base, exponent >> 1);//一个数右移1位表示除2
        result*=result;
        if((exponent & 0x1) ==1)//exponent为奇数时, n&0x1代表了n%2
            result*=base;
        return result;

    }
}
