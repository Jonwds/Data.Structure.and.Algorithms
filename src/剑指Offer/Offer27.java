package 剑指Offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*  字符串的排列
    输入一个字符串,按字典序打印出该字符串中字符的所有排列。
    例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba

 */
public class Offer27 {

    @Test
    public  void test(){
        System.out.println(Permutation("abc").toString());
    }
    
    public ArrayList<String> Permutation(String str) {
        List<String> result = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, result);
            Collections.sort(result);
        }
        return (ArrayList)result;
    }

    public void PermutationHelper(char[] chars, int i, List<String> list) {
        if (i == chars.length - 1) {
            String val = String.valueOf(chars);
            if (!list.contains(val))
                list.add(val);
        } else {
            for (int j = i; j < chars.length; j++) {
                //if(i!=j)
                    swap(chars, i, j);
                PermutationHelper(chars, i+1, list);
                //if(i!=j)
                    swap(chars, i, j);
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}

