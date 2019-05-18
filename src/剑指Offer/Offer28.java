package 剑指Offer;

import org.junit.Test;

/*  数组中出现次数超过一半的数字
    数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
    由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Offer28 {
    //找到数组中任意第k大的数字
    //在随机快速排序中,先在数组中随机选一个数字,然后调整数组中数字的顺序,使得比选中的数字小的都在它左边,比选中数字大的都在它右边
    // 如果这个选中的数字的下标刚刚好是k,那么这个数字就是数组中第k大的数字,
    //如果下标大于k,那么就去它的左边找
    // 如果下标小于k,那么就去它的右边找

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length<=0 || array==null)
            return 0;
        int l=0,r=array.length-1;
        int mid=array.length >>1;
        int index=partition(array,l,r);
        while(index !=mid){
            if(index>mid){ //下标大于k,那么就去它的左边找
                r=index-1;
                index=partition(array,l,r);
            }else{
                l=index+1;
                index=partition(array,l,r);
            }
        }
        int result=array[mid];
        if(!check(array,result))
            result=0;
        return result;
    }

    //判断数组是否合理
    public boolean check(int[] arr,int num){
        int count=0;
        for (int i=0;i<arr.length;i++)
            if(arr[i]==num)
                count++;
        boolean flag=true;
        if(count*2 <= arr.length)
            flag=false;
        return flag;
    }


    public int partition(int[] arr,int l,int r){
        int rand = (int) (Math.random()*(r-l+1)+l);
        swap(arr,l,rand);
        int v=arr[l];
        int lt=l;//arr[l+1..lt]<v
        int gt=r+1;//arr[gt..r]>v
        int i=l+1;//arr[lt+1..i)==v
        while(i<gt){ //i>=gt 遍历结束
            if(arr[i]<v){
                swap(arr,++lt,i++);
            }else if(arr[i]>v){
                swap(arr,--gt,i);
            }else{ //arr[i]==v
                i++;
            }
        }
        swap(arr,l,lt);
        return lt;
    }
    public void swap(int[] arr,int a,int b){
        int temp=arr[a];arr[a]=arr[b];arr[b]=temp;
    }

    @Test
    public void test(){
        int[] arr={3,3,3,4,5,6,3,7,3,8,3};
        System.out.println(MoreThanHalfNum_Solution(arr));
    }

}
