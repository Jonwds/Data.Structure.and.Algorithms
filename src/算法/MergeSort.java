package 算法;

import org.junit.Test;

//自顶向下归并排序
public class MergeSort {
    //对arr[l...mid]和arr[mid+1...r]进行归并
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
    //递归使用归并排序,对arr[l...r]进行排序
    private static void mergeSort(int[] arr,int l,int r){
    //        if(l>=r)
    //            return;
        //!!优化2：当元素很少时,直接使用插入排序更快
        if(l-r <= 15)
            insertionSort(arr,l,r);
        int mid=(l+r)/2;
        mergeSort(arr,0,mid);
        mergeSort(arr,mid+1,r);
        //！优化：当arr[mid]<=arr[mid+1],说明已经有序,就不用归并了
        if(arr[mid]>arr[mid+1])
            merge(arr,l,mid,r);
    }
    public static void mergeSort(int[] arr) {
        mergeSort(arr,0,arr.length-1);
    }

    public static void insertionSort(int[] arr,int l,int r){
        for(int i=l+1;i<=r;i++){
            int toBeInserted=arr[i];
            int j=i;
            for(;j>l && arr[j-1]>toBeInserted;j--)
                arr[j]=arr[j-1];
            arr[j]=toBeInserted;
        }
    }



    @Test
    public void test(){
        int[] arr={9,8,7,6,5,4,3,2,1};
        insertionSort(arr,0,arr.length-1);
        for (int i:arr)
            System.out.print(i+",");
    }
}