package 算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class LeetCode93 {
    // s(digits)是符合答案的字符串
    // s(digits[0...n-1])
    //  = letter(digits[0]) + s(digits[1...n-1])
    //  = letter(digits[0]) + letter(digits[1])+ s(digits[2...n-1])
    public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            List<Integer> ip = new ArrayList<>();
            dfs(s, 0, ip, res);
            return res;
        }

        private void dfs(String s, int index, List<Integer> ip, List<String> res){
            if(index == s.length()){
                if(ip.size() == 4)
                    res.add(get_string(ip));
                return;
            }

            if(index == 0){
                ip.add(s.charAt(0) - '0');
                dfs(s, index + 1, ip, res);
            }
            else{
                int next = ip.get(ip.size()-1) * 10 + (s.charAt(index) - '0');
                if(next <= 255 && ip.get(ip.size()-1) != 0){
                    ip.set(ip.size()-1,next);
                    dfs(s, index + 1, ip, res);
                    ip.set(ip.size()-1,ip.get(ip.size()-1)/10);
                }
                if(ip.size() < 4){
                    ip.add(s.charAt(index) - '0');
                    dfs(s, index + 1, ip, res);
                    ip.remove(ip.size()-1);
                }
            }
        }

        private String get_string(List<Integer> ip){
            String res = "";
            for (int i=0;i<ip.size();i++){
                if (i!=ip.size()-1)
                    res+=ip.get(i).toString()+".";
                else
                    res+=ip.get(i).toString();
            }
            return res;
        }
        @Test
        public  void test(){
            String str = "25525511135";
            List<String> strings = restoreIpAddresses(str);
            for (String str1:strings){
                System.out.println(str1);
            }
        }
}
