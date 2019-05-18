package 算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    编写一个算法来判断一个数是不是“快乐数”。
一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
示例:
    输入: 19
    输出: true
解释:
    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1
 */
public class LeetCode202 {
    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int sum=n;
        while(sum!=1){
            int m=sum;
            sum=0;
            while(m!=0){
                list.add( m % 10);
                m=m/10;
            }
            for(int i=0;i<list.size();i++){
                sum+=(list.get(i)*list.get(i));
            }
            list=new ArrayList<>();
            if(!set.contains(sum))
                set.add(sum);
            else
                return false;
        }
        return true;
    }
    //优化版本
    public boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            n=sum(n);
            if (!set.contains(n))
                set.add(n);
            else
                return false;
        }
        return true;
    }
    private int sum(int num){
        int res=0;
        while(num!=0){
            int i=num%10;
            res += (i*i);
            num /= 10;
        }
        return res;
    }
    @Test
    public void test(){

        System.out.print(isHappy(19));
    }
}
