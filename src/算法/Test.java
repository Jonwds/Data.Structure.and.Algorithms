package 算法;

/** 之字型打印多叉树
 *
 */
public class Test {
    private String[] nums = new String[] { "零","一","二","三","四","五","六","七","八","九" };
    private String[] digits = new String[] { "","十","百","千" };
    private String[] units = new String[] { "","万","亿","万亿" };
    // 1,2345,6789
    public String num2Chinese(int num){
        StringBuilder res = new StringBuilder();
        String allStr = String.valueOf(num);
        int firstGroupNums = allStr.length() % 4;
        int groupNums = (firstGroupNums>0)? (allStr.length())/4+1 : allStr.length()/4 ;
        int p=0;//用来控制每次循环后,移动的位数
        for (int i=0;i<groupNums;i++){
            int len = (i==0)? firstGroupNums : 4;
            String everyGroupStr = allStr.substring(p,p+len);
            int everyGroupStrLen = everyGroupStr.length();
            for (int j=0;j<everyGroupStrLen;j++){
                int n = Integer.parseInt(everyGroupStr.substring(j,j+1));
                if( n == 0){
                    //判断要不要加零
                }else{
                    res.append(nums[n]);
                    res.append(digits[n]);
                }
            }
            p=p+len;
        }
        return res.toString();
    }
}
