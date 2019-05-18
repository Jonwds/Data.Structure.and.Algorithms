package 剑指Offer;

import java.util.ArrayList;

/*  顺时针打印矩阵
    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
    例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
    则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Offer19 {
    public static void main(String[] args) {
        int[][] abc={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> arrayList = printMatrix(abc);
        System.out.println(arrayList);
    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int rows=matrix.length;//行数
        int columns=matrix[0].length;//列数
        if (matrix==null || rows<=0 || columns<=0)
            return null;
        ArrayList<Integer> arrayList=new ArrayList<>();
        int start=0;
        //对于一个5*5的矩阵,最后一圈只有一个数字,对应的坐标为(2,2),我们发现5>2*2
        //对于一个6*6的矩阵,最后一圈有4个数字,对应的左上角坐标为(2,2),发现6>2*2仍成立
        //循环的条件：rows>start*2 并且 columns>start*2
        while(rows>start*2 && columns>start*2){ //有几圈就循环几次
            ArrayList<Integer> tempList = printMatrixInCircle(matrix, rows, columns, start);//每次循环,按顺时针一圈存入集合
            for (int i:tempList){
                arrayList.add(i);
            }
            ++start;
        }
        return arrayList;
    }
    //循环一圈分为4步：第一步,从左到右打印一行;第二步,从上到下打印一列;
    // 第三步,从右往左打印一行;第四步,从下往上打印一列;
    public static ArrayList<Integer> printMatrixInCircle(int [][] matrix,int rows,int columns,int start) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int endY=columns-1-start;
        int endX=rows-1-start;
        for(int i=start;i<=endY;++i) // 从左到右打印一行
            arrayList.add(matrix[start][i]);
        if(endX>start)//有第二步的前提是,终止的行号>起始的行号
            for(int i=start+1;i<=endX;++i) // 从上往下打印一列
                arrayList.add(matrix[i][endY]);
        if(endX>start && endY>start) //有第三步的前提是,至少有两行两列,即终结的列数>起始的列数 且 终结的列数>起始的列数
            for (int i=endY-1;i>=start;--i) //从右往左打印一行
                arrayList.add(matrix[endX][i]);
        if(endX>start-1 && endY>start)//有第四步的前提是,至少有三行两列,即终结行号比起始行号至少大2,同时终结列号>起始列号
            for (int i=endX-1;i>=start+1;i--)//从下往上打印一列
                arrayList.add(matrix[i][start]);

        return  arrayList;
    }




}
