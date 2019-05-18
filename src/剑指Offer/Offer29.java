package 剑指Offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*  最小的k个数
    输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Offer29 {
    //利用快排的思路
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input.length<=0 || input==null || k>input.length || k<=0)
            return result;
        int l=0,r=input.length-1;
        int index = partition(input,l,r);

        while (index!=k-1){
            if(index > k-1){  //下标大于k,那么就去它的左边找
                r=index-1;
                index=partition(input,l,r);
            }else{          //下标小于k,那么就去它的右边找
                l=index+1;
                index=partition(input,l,r);
            }
        }
        for (int i=0;i<k;i++)
            result.add(input[i]);

        return result;
    }
    public int partition(int[] arr,int l,int r){
        int rand = (int) (Math.random()*(r-l+1)+l);
        swap(arr,l,rand);
        int v=arr[l];
        int lt=l;
        int gt=r+1;
        int i=l+1;
        while(i<gt){
            if(arr[i]<v){  //   arr[l+1..lt]<v
                swap(arr,++lt,i++);
            }else if(arr[i]>v){ //  arr[gt..r]>v
                swap(arr,--gt,i);
            }else{ //   arr[i] == v
                i++;
            }
        }
        swap(arr,l,lt);
        return lt;
    }
    public void swap(int[] arr,int a,int b){
        int temp=arr[a];arr[a]=arr[b];arr[b]=temp;
    }

    //利用大顶堆的思想
    //1.堆的元素数量<k,直接入堆
    //2.当前元素 < 堆顶元素,替换堆顶元素
    //3.当前元素 >= 堆顶元素, 跳过
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input==null || input.length<=0 || k<=0 || k>input.length)
            return  result;
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1); //return (x < y) ? -1 : ((x == y) ? 0 : 1);
            }
        });
        for (int i=0;i<input.length;i++){
            if(maxHeap.size() < k){
                maxHeap.offer(input[i]);
            }else {
                if (input[i] < maxHeap.peek() ) {
                    maxHeap.poll();
                    maxHeap.offer(input[i]);
                }
            }
        }
        maxHeap.forEach( i -> {
            result.add(i);
        });
        return  result;
    }



    @Test
    public void test(){
        int[] arr={4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = GetLeastNumbers_Solution(arr, 4);
        for(int i:list )
            System.out.print(i+" ");
    }
}
