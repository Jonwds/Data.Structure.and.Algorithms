package 算法;

import org.junit.Test;

/*
编写一个函数，其作用是将输入的字符串反转过来。

示例 1:
    输入: "hello"
    输出: "olleh"
示例 2:
    输入: "A man, a plan, a canal: Panama"
    输出: "amanaP :lanac a ,nalp a ,nam A"
 */
public class LeetCode344 {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int i=0,j=chars.length-1;
        while (i<j) {
            swap(chars, i++, j--);
        }
        return new String(chars);
    }
    public void swap(char[] c,int a,int b){
        char temp=c[a];
        c[a]=c[b];c[b]=temp;
    }
    @Test
    public void test(){
        String s="A man, a plan, a canal: Panama";
        String string = reverseString(s);
        System.out.println(string);
    }
}
