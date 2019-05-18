package 算法;
/* Find all anagrams in a string
    给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
    字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：
    字母异位词指字母相同，但排列不同的字符串。
    不考虑答案输出的顺序。
示例 1:
    输入:
        s: "cbaebabacd" p: "abc"
    输出:
        [0, 6]
    解释:
        起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
        起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 示例 2:
    输入:
        s: "abab" p: "ab"
    输出:
        [0, 1, 2]
 */

import org.junit.Test;

import java.util.*;

public class LeetCode438 {
    /*输入:
        s: "cbaebabacd" p: "abc"
    输出:
        [0, 6]
    */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen=s.length(),pLen=p.length();
        if(sLen<pLen)
            return result;
        int[] pArr=new int[26];  //字符串只包含小写英文字母
        for (int i=0;i<pLen;i++)
            pArr[ p.charAt(i) - 'a' ]++;
        int[] sArr=new int[26];
        int i=0,j=0;//[i..j)

        while( i < sLen && j<sLen){
            sArr[ s.charAt(j++) - 'a' ]++; //向右滑动一格
            if( j-i == pLen && same(sArr,pArr))
                result.add(i);
            if( j-i >= pLen) //向左滑动一格
                sArr[ s.charAt(i++) - 'a' ]--;
        }
        return  result;
    }
    private boolean same(int[] sArr,int[] pArr){

        for (int i=0;i<26;i++){
            if(sArr[i] != pArr[i])
                return false;
        }
        return true;
    }
    
    @Test
    public void test(){
        String s = "cbaebabacd",p="abc";
        List<Integer> list = findAnagrams(s, p);
        for(int i:list)
            System.out.print(i+" ");
    }
}
