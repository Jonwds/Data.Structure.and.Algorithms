package 算法;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:
    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 3:
    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i=0,j=0;//窗口[i,j)（最初 j = i  ）
        int len=0;
        Set<Character> set = new HashSet<>();//使用 HashSet 将字符存储在窗口
        while( i<n && j<n){
            if(!set.contains(s.charAt(j))){  //当前字符不在HashSet中，我们会继续滑动j
                set.add(s.charAt(j++));
                len=Math.max(len,j-i);
            }else{  //当前字符在HashSet中,在窗口中一直删除,直到删除了重复的字符
                set.remove(s.charAt(i++));
            }
        }
        return  len;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring3(String s) {
        int[] arr = new int[256];
        int i=0,j=0,n=s.length(); //[i,j)
        int len=0;
        while(j<n){
            if(arr[s.charAt(j)]==0)
                arr[s.charAt(j++)]++;
            else
                arr[s.charAt(i++)]--;
            len=Math.max(len,j-i);
        }
        return len;
    }


    @Test
    public void test(){
        String s = "abcabcbb";
        int sum = lengthOfLongestSubstring3(s);
        System.out.println(sum);
    }

}
