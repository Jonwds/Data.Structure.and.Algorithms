package 算法;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*
    给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。

示例 1:
    输入: [[1,1],[2,2],[3,3]]
    输出: 3
解释:
^
|
|        o
|     o
|  o
+------------->
0  1  2  3  4

示例 2:
    输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
    输出: 4
解释:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
 */
public class LeetCode149 {
    class Point {
       int x;
       int y;
       Point() { x = 0; y = 0; }
       Point(int a, int b) { x = a; y = b; }
   }
   //判断在一条直线上：斜率相等  [[1,1],[2,2],[3,3]]
    public int maxPoints(Point[] points) {
        int max=-1;
        for (int i=0;i<points.length;i++){
            Map<Double,Integer> map = new HashMap<>();
            int same=0;
            for (int j=0;j<points.length;j++){
                if(points[i].x==points[j].x && points[i].y==points[j].y){
                    same++;
                    if(same > max)
                        max=same;
                }
                else {
                    double k = getK(points[i], points[j]);
                    map.put(k,map.getOrDefault(k,0)+1);
                }
            }

            for (int value:map.values()){
                if (value>max)
                    max=value;
            }

        }

        return  max;
    }
    //计算两个点的斜率
    private double  getK(Point a, Point b){
        //if(b.x == a.x )

        double k = ((double)b.y-(double)a.y)/((double)b.x-(double)a.x);
        return k;
    }
    @Test
    public void test(){
        //输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
        //    输出: 4
//        Point a =new Point(1,1);Point b =new Point(3,2);Point c =new Point(5,3);
//        Point d =new Point(4,1);Point e =new Point(2,3);Point f =new Point(1,4);
        Point a =new Point(1,1);Point b =new Point(1,1);
        Point c =new Point(2,2);Point d =new Point(2,2);

        Point[] arrs=new Point[4];
        arrs[0]=a;arrs[1]=b;arrs[2]=c;arrs[3]=d;//arrs[4]=e;arrs[5]=f;
        System.out.print(maxPoints(arrs));
    }
}
