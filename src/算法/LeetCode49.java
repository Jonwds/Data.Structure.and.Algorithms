package 算法;

import org.junit.Test;

import java.util.*;

/*
    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

输入:
    ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
    [ ["ate","eat","tea"],["nat","tan"],["bat"] ]
说明：
    所有输入均为小写字母。
    不考虑答案输出的顺序。
 */
public class LeetCode49 {

    //维护一个映射 map:{String -> List}
    // 其中每个键 K 是一个排序字符串，每个值是初始输入的字符串的列表。
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List> map = new HashMap<>();
        for (String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key))
                map.put(key,new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());

    }

    @Test
    public void test(){
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list  : lists)
            System.out.print(list);
    }
}
