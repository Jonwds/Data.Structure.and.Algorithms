package 剑指Offer;
/*
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Offer06 {
    public static void main(String[] args) {
        int[] array={3,4,5,1,2};
        System.out.println(minNumberInRotateArray(array));
    }
    public static int minNumberInRotateArray(int [] array) {
        if(array==null || array.length<=0)
            return 0;
        int left=0,right=array.length-1;
        int mid =0;
        while(array[left]>=array[right]){
            if(left+1==right){
                mid=right;
                break;
            }
            mid =(left+right)/2;
            if(array[left]==array[mid] && array[right]==array[mid])
                return minNumberInArray(array,left,right);
            if(array[left] <= array[mid]){
                left = mid;
            }else if(array[mid] <= array[right])
                right=mid;
        }
        return array[mid];
    }
    public static int minNumberInArray(int [] array,int left,int right) {
        int min=array[left];
        for (int i=left+1;i<=right;i++){
            if(array[i]<min)
                min=array[i];
        }
        return min;
    }
}
