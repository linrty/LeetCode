package s901;

import java.util.ArrayList;
import java.util.List;

public class Solution {
}


class StockSpanner {

    int[] arr;
    int index = 0;

    public StockSpanner() {
        arr = new int[10005];
        index = 0;
    }

    public int next(int price) {
        int pos = index;
        int res = 0;
        arr[index++] = price;
        while(pos >= 0 && arr[pos] <= price){
            pos--;
            res++;
        }
        return res;
    }
}
