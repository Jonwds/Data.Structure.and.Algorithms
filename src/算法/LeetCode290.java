package 算法;

import java.util.HashMap;
import java.util.Map;

/*
    给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。

示例1:
    输入: pattern = "abba", str = "dog cat cat dog"
    输出: true
示例 2:
    输入:pattern = "abba", str = "dog cat cat fish"
    输出: false
示例 3:
    输入: pattern = "aaaa", str = "dog cat cat dog"
    输出: false
示例 4:
    输入: pattern = "abba", str = "dog dog dog dog"
    输出: false
说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class LeetCode290 {
    public boolean wordPattern(String pattern, String str) {
        String[] sArr = str.split(" ");
        if (sArr.length != pattern.length())
            return false;
        Map<Character,String> map = new HashMap<>();
        for (int i=0;i<pattern.length();i++){
            if (!map.containsKey(pattern.charAt(i))){ //map不存在key, 若map里已经有value值,返回false,没有则存入
                if(map.containsValue(sArr[i]))  //"abba" --> "cat cat cat cat"
                    return false;
                else
                    map.put(pattern.charAt(i),sArr[i]);
            }else{ //map中存在key,比较value与字符串sArr[i]是否相等,不等则false
                if (!map.get(pattern.charAt(i)).equals(sArr[i]))    //"abba" --> "dog cat dog cat"
                    return false;
            }
        }
        return  true;
    }
}
