package 算法;

import org.junit.Test;

/*
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

示例 1:
    输入: "hello"
    输出: "holle"
示例 2:
    输入: "leetcode"
    输出: "leotcede"
说明:
    元音字母不包含字母"y"。
 */
public class LeetCode345 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i=0,j=chars.length-1;
        while (i<j){
            while(i<j && !isVowels(chars[i]))
                i++;
            while(i<j && !isVowels(chars[j]))
                j--;
            swap(chars,i++,j--);
        }
        return new String(chars);
    }
    public boolean isVowels(char c){
        if( c=='a'|| c=='e'|| c=='i'|| c=='o'|| c=='u'||c=='A'|| c=='E'|| c=='I'|| c=='O'|| c=='U')
            return true;
        else
            return false;
    }
    public void swap(char[] c,int a,int b){
        char temp=c[a];
        c[a]=c[b];c[b]=temp;
    }
    @Test
    public void test(){
        String s="aA";
        String string = reverseVowels(s);
        System.out.println(string);
    }
}
