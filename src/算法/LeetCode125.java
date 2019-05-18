package 算法;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*  验证回文串
    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:
    输入: "A man, a plan, a canal: Panama"
    输出: true
示例 2:
    输入: "race a car"
    输出: false
 */
public class LeetCode125 {
    //正则表达式
    public boolean isPalindrome(String s) {
        boolean flag = true;
        if (s.isEmpty())
            return flag;
        String regex = "[^a-zA-Z0-9]";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(s);
        String str = matcher.replaceAll("").trim();
        char[] chars = str.toLowerCase().toCharArray();
        int i=0,j=chars.length-1;
        while (i<j){
            if( chars[i] == chars[j]){
                i++;j--;
            }else {
                flag = false;
                break;
            }
        }
        return  flag;
    }

    public boolean isPalindrome2(String s) {
        boolean flag = true;
        if (s.isEmpty())
            return flag;
        char[] chars = s.toLowerCase().toCharArray();
        int i=0,j=chars.length-1;
        while (i<j){
            while(i<j && !isRightChar(chars[i]))
                i++;
            while(i<j && !isRightChar(chars[j]))
                j--;
            if(chars[i]==chars[j]){
                i++;j--;
            }else {
                flag=false;
                break;
            }
        }
        return flag;
    }
    public boolean isRightChar(char c){
        if((c<='9' && c>='0')||(c<='z' && c>='a'))
            return true;
        else
            return false;
    }


    @Test
    public void test(){
        String s="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome2(s));
    }
}
