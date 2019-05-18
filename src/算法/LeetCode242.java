package 算法;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
示例 1:
    输入: s = "anagram", t = "nagaram"
    输出: true
示例 2:
    输入: s = "rat", t = "car"
    输出: false
说明:
    你可以假设字符串只包含小写字母。
进阶:
    如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        for (char c:s.toCharArray()){
            if(!sMap.containsKey(c))
                sMap.put(c,1);
            else
                sMap.put(c,sMap.get(c)+1);
        }
        for (char c:t.toCharArray()){
            if(!tMap.containsKey(c))
                tMap.put(c,1);
            else
                tMap.put(c,tMap.get(c)+1);
        }
        return sMap.equals(tMap);
    }

    public boolean isAnagram2(String s, String t) {
        int[] sArr=new int[256];int[] tArr=new int[256];
        for (int i=0;i<s.length();i++){
            sArr[s.charAt(i)]++;
        }
        for (int i=0;i<t.length();i++){
            tArr[t.charAt(i)]++;
        }
        return  isSame(sArr,tArr);
    }
    public boolean isSame(int[] a,int[] b){
        for (int i=0;i<a.length;i++){
            if (a[i]!=b[i])
                return false;
        }
        return true;
    }
    @Test
    public void test(){
        String s = "anagram";
        String t = "nagaram";
        System.out.print(isAnagram(s,t));
    }
}
