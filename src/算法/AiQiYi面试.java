package 算法;

import org.junit.Test;

/** 题目描述：给定一个数字,将它转为中文的读法(单位到亿)
 *  例如：1234567 读作一百二十三万四千五百六十七
 */
public class AiQiYi面试 {
    static char[] numArr = {'零','一','二','三','四','五','六','七','八','九'};
    static String[] unitArr = {"","十","百","千","万","十万","百万","千万","亿"};
    public String num2Chinese(int num){
        char[] chars = String.valueOf(num).toCharArray();
        int len = chars.length;
        StringBuilder res = new StringBuilder();
        for (int i=0;i<len;i++){
            int temp = Integer.valueOf(String.valueOf(chars[i]));
            boolean zeroFlag = temp==0 ? true:false;
            if (zeroFlag){
                while (i<len-1 && chars[i]=='0')
                    i++;
                if (i!=len-1){
                    res.append(String.valueOf(numArr[0]));
                }
            }else{
                res.append(numArr[temp]);
                res.append(unitArr[len-i-1]);
            }
        }
        return res.toString();
    }

    private String[] nums = new String[] { "零","一","二","三","四","五","六","七","八","九" };
    private String[] digits = new String[] { "","十","百","千" };
    private String[] units = new String[] { "","万","亿","万亿" };


    public String transfrom( int num )
    {
        String str = String.valueOf(num);

        //把字符串看作一些组，例如：123456789->1,2345,6789
        String result = "";
        int index = 0;//指示数组中的位置
        int firstGroupLength = str.length()%4;
        int groupNums = ( firstGroupLength>0 ? str.length()/4+1 : str.length()/4 );
        //从最左边的那组开始，向右循环
        for( int i=groupNums; i>0; i-- )
        {
            int len=4;
            if ( i==groupNums && firstGroupLength!=0 )//当i为最左边的那组时，组长度可能有变化
            {
                len=firstGroupLength;
            }
            String everyGroupStr = str.substring( index, index+len );
            int everyGroupStrLen = everyGroupStr.length();
            //开始处理数字
            for( int j=0; j<everyGroupStrLen; j++ )
            {
                int n = Integer.parseInt( everyGroupStr.substring(j,j+1) );
                if ( n ==0 ) {
                    if(j<everyGroupStrLen-1
                            && Integer.parseInt(everyGroupStr.substring(j+1,j+2))>0
                            && !result.endsWith(nums[0]))
                    {//加零的条件：不为最后一位 && 下一位数字大于0 && 以前没有加过“零”
                        result += nums[0];
                    }
                }else {
                    //if( !(n==1 && (result.endsWith(nums[0])||result.length()==0) && j==everyGroupStrLen-2) )
                    //{//处理1013一千零"十三"，1113 一千一百"一十三"
                        result += nums[n];
                    //}
                        result += digits[everyGroupStrLen-j-1];
                    }
                }
            //如果这组数字不全是 0 ，则加上单位：万，亿，万亿
            if ( Integer.parseInt(everyGroupStr) !=0 ){
                result += units[i-1];
            }
            index += len;
            }
            return result;
        }


    @Test
    public  void test( ) {
        System.out.println(transfrom(1234567			));
        System.out.println(transfrom(11000000		));
        System.out.println(transfrom(10100000		));
        System.out.println(transfrom(10010000		));
        System.out.println(transfrom(10001000		));

    }

}

