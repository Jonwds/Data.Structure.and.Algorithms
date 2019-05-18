package 算法;

import org.junit.Test;

import java.util.List;

/*  最小覆盖子串
给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。

示例：
    输入: S = "ADOBECODEBANC", T = "ABC"
    输出: "BANC"
说明：
    如果 S 中不存这样的子串，则返回空字符串 ""。
    如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class LeetCode76 {
    public String minWindow(String s, String t) {
        if (s.length()<t.length())
            return "";
        int[] tArr=new int[256];
        for(int i=0;i<t.length();i++)
            tArr[t.charAt(i)]++;
        int[] sArr=new int[256];
        int l=0,r=0;//窗口[l..r)
        int count=0; //保存窗口中等于字符串t的字符的数量, count==t.length()时,说明找到一个满足条件的子串
        int minlength=s.length()+1,startIndex=-1;
        while (l<s.length()){
            if(r<s.length() && count<t.length()){  //r向右滑动一格
                sArr[s.charAt(r)]++;
                if(sArr[s.charAt(r)] <= tArr[s.charAt(r)])
                    count++;
                r++;
            }else{
                if(count==t.length() && r-l<minlength){ //更新最小字符串的长度和开始索引
                    minlength=r-l;
                    startIndex=l;
                }
                //l向左滑动一格
                sArr[s.charAt(l)]--;
                if(sArr[s.charAt(l)] < tArr[s.charAt(l)])
                    count--;
                l++;
            }
        }
        if(startIndex!=-1)
            return s.substring(startIndex,startIndex+minlength);
        return "";
    }
    @Test
    public void test(){
        String s = "ADOBECODEBANC",p="ABC";
        System.out.print(minWindow(s, p));


    }
}
