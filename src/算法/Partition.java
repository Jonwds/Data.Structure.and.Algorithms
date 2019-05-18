package 算法;

import org.junit.Test;

public class Partition {
    public static void quickSort(int[] arr){

        quickSort(arr,0,arr.length-1);
    }
    private static void quickSort(int[] arr,int l ,int r){
        if(l>=r)
            return;
        int index=partition(arr,l,r);
        quickSort(arr, l , index-1);
        quickSort(arr,index+1 , r);

    }
    //返回p, arr[l...p-1]<arr[p], arr[p+1...r]>arr[p]
    private static int partition(int[] arr,int l,int r){
        int rand = (int) (Math.random() * (r - l + 1) + l );//生成l-r范围内随机的索引
        swap(arr,l,rand);
        int v=arr[l];
        //arr[l+1...j]< v , arr[j+1...i-1]>v
        int j=l;
        for (int i=j+1;i<=r;i++){   // 当arr[i]>=v , i++
            if(arr[i]<v){
                swap(arr,i,++j);
            }
        }
        swap(arr,l,j);
        return j;
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];arr[j]=temp;
    }
    @Test
    public void test(){
        int[] arr={9,8,7,6,5,4,3,2,1};
        quickSort(arr);
        for (int i:arr)
            System.out.print(i+",");
    }
}


