package 算法;

import org.junit.Test;

public class Partition2 {
    public void QuickSort2(int[] arr){
        QuickSort2(arr,0,arr.length-1);
    }
    public void QuickSort2(int[] arr,int left,int right){
        if(left>right)
            return;
        int index = partition2(arr,left,right);
        QuickSort2(arr, left, index-1);
        QuickSort2(arr, index+1, right);
    }
    //返回p,使得arr[l+1...i-1]<=v,arr[j...r]>=v
    public int partition2(int[] arr,int left,int right){
        int rand= (int) (Math.random()*(right-left+1)+left);
        swap(arr,left,rand);
        int v=arr[left];
        //arr[l+1...i)<=v,arr(j...r]>=v
        int i=left+1,j=right;
        while(true){
            while(i<=right && arr[i]<v) i++;
            while(j>left+1 && arr[j]>v) j--;
            if(i>j) break;
            swap(arr,i++,j--);
        }
        swap(arr,left,j);
        return j;
    }
    public void swap(int[] arr,int a ,int b){
        int temp=arr[a];arr[a]=arr[b];arr[b]=temp;
    }
    @Test
    public void test(){
        int[] arr={9,8,7,6,5,4,3,2,1};
        QuickSort2(arr);
        for (int i:arr)
            System.out.print(i+",");
    }
}
