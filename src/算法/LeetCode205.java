package 算法;

import com.sun.xml.internal.ws.util.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*  同构字符串
    给定两个字符串 s 和 t，判断它们是否是同构的。
    如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
    所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。
    两个字符不能映射到同一个字符上，但字符可以映射自己本身。

示例 1:
    输入: s = "egg", t = "add"
    输出: true
示例 2:
    输入: s = "foo", t = "bar"
    输出: false
示例 3:
    输入: s = "paper", t = "title"
    输出: true
说明:
    你可以假设 s 和 t 具有相同的长度。
 */
public class LeetCode205 {
    //两个字符不能映射到同一个字符上，但字符可以映射自己本身。
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            if(!map.containsKey( s.charAt(i)) ){    // s = "foo", t = "bar"
                if(!map.containsValue(t.charAt(i)))
                    map.put(s.charAt(i), t.charAt(i));
                else
                    return false; // "ab" , "aa"
             }else{
                if( t.charAt(i)!=map.get(s.charAt(i)) )
                    return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        String s = "ab";String t = "aa";
        System.out.print(isIsomorphic(s,t));
    }
}
