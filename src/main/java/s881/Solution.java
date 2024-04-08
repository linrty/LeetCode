package s881;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/26 9:34
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int sta = 0 ;
        int end = people.length-1;
        int num = 0;
        while (sta<=end){
            if (sta==end){
                num++;
                break;
            }
            if (people[sta]+people[end]<=limit){
                num++;
                sta++;
                end--;
            }else{
                num++;
                end--;
            }
        }
        return num;
    }
}
