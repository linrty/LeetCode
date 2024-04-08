package s412;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/10/13 20:07
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i%3 == 0 && i%5 == 0){
                list.add("FizzBuzz");
            }else if (i%3 == 0){
                list.add("Fizz");
            }else if (i%5 == 0){
                list.add("Buzz");
            }else{
                list.add(Integer.toString(i));
            }
        }
        return list;
    }
}
