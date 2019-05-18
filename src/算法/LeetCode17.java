package 算法;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LeetCode17 {
    String[] map={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> result =new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits=="" || digits==null)
            return null;

        result=letterCombinations(digits,0,"");
        return result;
    }
    public List<String> letterCombinations(String digits,int index,String str) {
        if (index==digits.length()){
            result.add(str);
            return null;
        }
        char c = digits.charAt(index);
        assert ( c <= '9'&& c >= '0');
        String letter = map[c-'0'];
        for (int i=0;i<letter.length();i++){
            letterCombinations(digits,index+1,str+letter.charAt(i));
        }
        return result;
    }

    @Test
    public void test(){
        String str ="23";
        List<String> strings = letterCombinations(str);
        for (String s : strings){
            System.out.println(s);
        }
    }
    // s(digits)是符合答案的字符串
    // s(digits[0...n-1])
    //  = letter(digits[0]) + s(digits[1...n-1])
    //  = letter(digits[0]) + letter(digits[1])+ s(digits[2...n-1])
}
