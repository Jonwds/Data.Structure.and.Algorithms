package 算法;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
    给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，
    其中 点i和点j之间的距离 与 点i和点k之间的距离相等（需要考虑元组的顺序）。
    找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。

输入:
    [  [0,0],
      [1,0],
      [2,0]
    ]
输出:
    2
解释:
    两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 */
public class LeetCode447 {
    // {0,0},
    // {1,0},
    // {2,0},
    public int numberOfBoomerangs(int[][] points) { //[0][0]和[0][1]表示一个点
        //键存储点到i的距离,值存储有多少个这样的点
        int res = 0;
        for (int i=0;i<points.length;i++){
            Map<Integer,Integer> map = new HashMap<>();
            for (int j=0;j<points.length;j++){
                if(i!=j){
                    int distant = distant(points[i],points[j]);
                    map.put(distant,map.getOrDefault(distant,0)+1);
                }
            }

            for (Integer value : map.values()){
                if (value>1){
                    res+=value*(value-1);
                }
            }
        }


        return res;
    }
    private int distant(int[] a,int [] b){
        int x = b[0]-a[0];
        int y = b[1]-a[1];
        return x*x + y*y;
    }
    public int numberOfBoomerangs2(int[][] points) { //[0][0]和[0][1]表示一个点

        return 0;
    }

    @Test
    public void test(){
//        int[][] arrs={ {0,0},{1,0},{2,0}};
//        System.out.print(numberOfBoomerangs(arrs));
        printTriangle(7);
    }

    //1
    //1   1
    //1   2   1
    //1   3   3   1
    //1   4   6   4   1
    //1   5  10 10 5   1
    public void printTriangle(int n){
        int[][] arr = new int[n][n];
        for (int i=0;i<n;i++){
            //arr[i]=new int[i+1];
            for (int j=0;j<=i;j++){
                if(j==0 || j==i)
                    arr[i][j]=1;
                else
                    arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
