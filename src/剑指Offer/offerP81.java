package 剑指Offer;
/*
    对公司所有员工的年龄进行排序，公司共有几万人，
    可以使用常量大小的辅助内存，不得超过O(n)
 */
public class offerP81 {
    private static final int  oldestAge=99;

    public static void sort(int[] ages){

        if (ages.length<=0 || ages==null)
            return;
        int[] timesOfAge=new int[oldestAge+1];
        /*for (int i=0;i<=oldestAge;i++){
            System.out.println(timesOfAge[i]);
        }*/
        for (int i=0;i<ages.length;i++){
            int age=ages[i];
            if (age<0 || age>oldestAge){
                return;
            }
            ++timesOfAge[age];
        }
        int index=0;
        for (int i=0;i<=oldestAge;i++){ //对timesOfAge进行遍历
            for (int j=0;j<timesOfAge[i];j++){ //针对timesOfAge上的每一个年龄，例如22岁有10个人，循环10次
                ages[index]=i;  //22岁排在数组最前面，重复10次
                ++index;
            }
        }

    }

}
