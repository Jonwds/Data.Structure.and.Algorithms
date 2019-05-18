package Google面试;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Generate all combinations and output them
 * select n elements form data.
 */
public class Combinations {
    public void combinations(List<Integer> selected,List<Integer> data, int n){
        if(n == 0){
            //output all selected elements
            for (int i:selected){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        if (data.isEmpty()){
            return;
        }

        //选择了第0号元素
        selected.add(data.get(0));
        combinations(selected,data.subList(1,data.size()),n-1);

        //没选择第0号元素
        selected.remove(selected.size()-1);
        combinations(selected,data.subList(1,data.size()),n);

    }

    @Test
    public void test(){
        combinations(new ArrayList<>(), Arrays.asList(1,2,3,4,5),2);
    }


}
