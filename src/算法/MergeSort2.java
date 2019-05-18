package 算法;

import org.junit.Test;

//自底向上的归并排序, 因为没有使用数组的索引特性, 可以对链表进行 nlogn的排序!!
public class MergeSort2 {
    public static void MergeSort(int[] arr){
        int n=arr.length;
        for (int size=1;size<=n;size+=size){ //1、2、4、8...
            for(int i=0;i+size<n;i+=size*2)
                //对[i..i+size-1]和[i+size...i+2*size-1]进行归并
                merge(arr,i,i+size-1,Math.min(i+size*2-1,n-1));
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp=new int[right-left+1];
        //temp从0开始,arr从left开始,所以temp和arr有left的偏移量
        for (int i=left;i<=right;++i)
            temp[i-left]=arr[i];

        int i=left,j=mid+1;
        for (int k=left;k<=right;++k){
            //保证i在左半边[l..mid],j在右半边[mid+1...r],不会越界
            if (i>mid){ //左半边归并完了,将右半边剩余的元素并入数组
                arr[k]=temp[j-left];
                j++;
            }else if(j>right){//右半边归并完了,将左半边剩余的元素并入数组
                arr[k]=temp[i-left];
                i++;
            }else if (temp[i-left]<temp[j-left]){
                arr[k]=temp[i-left];
                i++;
            }else {
                arr[k]=temp[j-left];
                j++;
            }
        }
    }
    @Test
    public void test(){
        int[] arr={9,8,7,6,5,4,3,2,1};
        MergeSort(arr);
        for (int i:arr)
            System.out.print(i+",");
    }


}
