package 剑指Offer;
/*
    剪绳子
 */
public class offerP96 {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }
    public static int solution(int length){
        if(length<2)
            return 0;
        if (length==2)
            return 1;
        if (length==3)
            return 2;
        int[] result=new int[length+1];
        result[0]=0;result[1]=1;result[2]=2;
        result[3]=3;//todo???
        int max=0;
        for (int i=4;i<=length;++i){
             max=0;//todo？
            for (int j=1;j<=i/2;++j){
                int temp=result[j]*result[i-j];
                if (max<temp)
                    max=temp;
                result[i]=max;//todo?
            }
        }
        return result[length];
    }

}
