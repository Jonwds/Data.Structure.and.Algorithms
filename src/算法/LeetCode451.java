package 算法;

import org.junit.Test;

import java.util.*;

/* 根据字符出现频率排序
    给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
示例 1:
输入:
    "tree"
输出:
    "eert"
解释:
    'e'出现两次，'r'和't'都只出现一次。
    因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
示例 2:
输入:
    "cccaaa"
输出:
    "cccaaa"
解释:
    'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
    注意"cacaca"是不正确的，因为相同的字母必须放在一起。
示例 3:
输入:
    "Aabb"
输出:
    "bbAa"
解释:
    此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
    注意'A'和'a'被认为是两种不同的字符。
 */
public class LeetCode451 {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new TreeMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i),1);
        }
        StringBuffer sb = new StringBuffer();

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        // 1.8以前的写法,借助于Collections的sort(List<T> list, Comparator<? super T> c)方法
        /*Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry<Character, Integer> entry : list){
            System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
            for (int i=0;i<entry.getValue();i++){
                sb.append(entry.getKey());
            }
        }*/
        // 1.8以后的写法,借助于Lambada
        Collections.sort(list,((o1, o2) -> o2.getValue().compareTo(o1.getValue())));
        list.forEach(entry->{
            for (int i=0;i<entry.getValue();i++)
                sb.append(entry.getKey());
        });
        return sb.toString();
    }
    @Test
    public void test(){
        String s = "Aabb";String t = "tree";
        System.out.println(frequencySort(s));
    }
}
