package 算法;

import org.junit.Test;

import java.util.Scanner;

/*  两数之和 II - 输入有序数组
    给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
    函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

    返回的下标值（index1 和 index2）不是从零开始的。
    你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
示例:

输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class LeetCode167 {

    //暴力解法：没有使用到数组的特性--有序！ 想到二分搜索法！
    public int[] twoSum(int[] numbers, int target) {
        int temp=0;
        int[] result = new int[2];
        for(int i=0;i<numbers.length;i++){
            temp=numbers[i];
            for (int j=numbers.length-1;j>i;j--){
                if(temp+numbers[j]==target){
                    result[0]=i+1;result[1]=j+1;
                    return result;
                }
            }
        }
        return result;
    }
    //利用二分搜索法
    public int[] twoSum2(int[] numbers, int target) {
        int temp=0;int[] tempArr=new int[numbers.length-1];
        int[] result = new int[2];
        for(int i=0;i<numbers.length;i++){
            temp=target-numbers[i];
            System.arraycopy(numbers,i+1,tempArr,0,numbers.length-i-1);
            //在剩余的有序数组中寻找temp
            int search = search(tempArr, temp);
            if(search != -1 ){
                result[0]=i+1;result[1]=search+2;
                return result;
            }
        }
        return result;
    }
    public int search(int[] arr,int target){
        int l=0,r=arr.length-1; //在[l..r]的范围里寻找target
        while(l <= r){
            int mid=(l+r)>>1;
            if( target > arr[mid] ){ //target在右半边
                l=mid+1;
            }else if( target < arr[mid] ){
                r=mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    //对撞指针 O(n)
    public int[] twoSum3(int[] numbers, int target) {
        int[] arr = new int[2];
        int i=0,j=numbers.length-1;
        while( i < j ){
            if(numbers[i]+numbers[j] < target){
                i++;
            }else if(numbers[i]+numbers[j] > target){
                j--;
            }else { //  numbers[i]+numbers[j]==target

                break;
            }
        }
        arr[0]=i+1;arr[1]=j+1;
        return arr;
    }


    @Test
    public void test(){
        int[] arr={2, 7, 11, 15};
//        int[]  tempArr=new int[3];
//        System.arraycopy(arr,1,tempArr,0,arr.length-1);
        int[] twoSum = twoSum3(arr, 18);
        for (int i: twoSum)
            System.out.print(i+" ");
    }


 /*
    猿辅导公司的 N位（N>=4）研发同学组织了一次秋游活动，某同学带了个无人机在高空拍照，活动结束时，先拍了一张所有同学排成公司猴头Logo的照片， 接着有人提议再排成“猿”的首字母Y字形来拍一张合照。

    用字符串中的每一个字符（不是换行符或结束符'\0'）代表一位老师，输出排好后的队形。要求 Y字除去中心点外，上下半部分等高，按照从左到右，从上到下进行排序。队形中没人的部分用空格占位。
    输入数据保证可以排出一个完整的Y字，即长度为 3k+1 （k>=1）

    例如: 7个 x ，排成队形为（为了方便说明，这里用‘-’代替空格）：
    x---x
    -x-x
    --x
    --x
    --x

    输入描述:
    输入数据有两行，第一行输入N(N<=1000)，表示字符串长度。
    第二行输入字符串。

    输出描述:
    用字符串表示的排好的队形，没人处用空格（' '）占位，行尾不能有多余字符，即每行最后一个字符（除了换行符以外），为字符串中代表该老师的字符。

输入例子1:
    4
    a3f/

输出例子1:
    a 3
     f
     /
 */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt(); //4
        String s = sc.next();// a3f/
        int k=(N-1)/3;
        int rows=2*k+1;int colums=2*k+1;
        char[][] chars =new char[rows][colums];
        int count=0;
        for(int i=0;i<rows/2;i++){
            chars[i][i]=s.charAt(count++);
            chars[i][rows-i-1]=s.charAt(count++);
        }
        for(int i=rows/2;i<rows;i++){
            chars[i][rows/2]=s.charAt(count++);
        }
        for(int i=0;i<rows;i++){
            for (int j=0;j<rows;j++){
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }

}
