package 剑指Offer;
/*
    输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
    所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Offer13 {
    public static void main(String[] args) {
        int[] arr = {10,8,6,4,2,1,3,5,7,9};
        reOrderArray(arr);
        for (int i:arr)
            System.out.print(i+" ");
    }
    //保证奇数和奇数，偶数和偶数之间的相对位置不变。
    public static void reOrderArray(int [] array) {
        if(array.length<=0 || array==null)
            return;
        int oddCount=0,oddBegin=0;
        int[] result=new int[array.length];
        for (int i=0;i<array.length;++i){
            if((array[i]&1)==1)
                ++oddCount;
        }
        for (int i=0;i<array.length;++i){
            if((array[i]&1)==1)
                result[oddBegin++]=array[i] ;
            else
                result[oddCount++]=array[i];
        }
        for(int i=0;i<array.length;++i)
            array[i]=result[i];
    }


    //不能保证奇数和奇数、偶数和偶数的相对次序
    public static void reOrder(int [] array) {
        if(array.length<=0 || array==null)
            return;
        int left=0,right=array.length-1;
        while(left<right){
            while (left<right && !oddOrEven(array[left]) )
                left++;
            while (left<right && oddOrEven(array[right]) )
                right--;

            if(left<right){
                int temp=array[left];
                array[left]=array[right];
                array[right]=temp;
            }
        }
    }
    public static boolean oddOrEven(int n){
        return (n & 1)==0;
    }



}
