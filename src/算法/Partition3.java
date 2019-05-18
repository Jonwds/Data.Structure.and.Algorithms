package 算法;

import org.junit.Test;

public class Partition3 {
    public void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }
    //三路快排:将arr分为三部分：<v ; >v ; ==v
    //之后递归对<v , >v 两部分继续进行三路快速排序
    public void quickSort(int[] arr,int l,int r){
        if(l>r)
            return;
        int rand= (int) (Math.random()*(r-l+1)+l);
        swap(arr,l,rand);
        int v=arr[l];

        int lt=l;   //arr[l+1...lt] < v
        int gt=r+1; //arr[gt..r] > v
        int i=l+1;  //arr[lt+1..i) == v
        while(i < gt){
            if( arr[i] < v) {  //arr[i]<v ,swap(lt+1,i)
                swap(arr,++lt,i++);
            }
            else if(arr[i] > v){  //arr[i]>v ,swap(gt-1,i)
                swap(arr,--gt,i);
            }else {
                i++;
            }
        }
        swap(arr,l,lt);
        quickSort(arr,l,lt-1);
        quickSort(arr,gt,r);
    }

    public void swap(int[] arr,int a ,int b){
        int temp=arr[a];arr[a]=arr[b];arr[b]=temp;
    }

    @Test
    public void test(){
        int[] arr={9,8,7,6,5,4,3,2,1};
        quickSort(arr);
        for (int i:arr)
            System.out.print(i+",");
    }
}
