package 算法;

import org.junit.Test;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        System.out.println(search(arr,5));
    }

    public static int search(int[] arr ,int target){
        int l=0,r=arr.length-1;//在[l...r]的范围里寻找target

        while(l<=r){  //当l==r时,区间[l....r]仍然有效
            // int mid = (l+r)/2;  有bug!当l和r太大时,加法会溢出
            int mid = l + (r-l)/2;
            if(target<arr[mid]){
                r=mid-1;    //target在[l...mid-1]中
            }else if(target>arr[mid]){
                l=mid+1;    //target在[mid+1...r]中
            }else{
                return mid;
            }
        }
        return -1;
    }
}
