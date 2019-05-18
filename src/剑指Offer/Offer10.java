package 剑指Offer;
/*
    我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
    请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Offer10 {
    public int RectCover(int target) {
        int[] array={1,2};
        if(target==1||target==2)
            return array[target-1];
        int f1=1,f2=2;
        int f3=0;
        for (int i=3;i<=target;i++){
            f3=f2+f1;
            f1=f2;f2=f3;
        }
        return f3;
    }
}
