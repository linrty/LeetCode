package s187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        int len =  s.length();
        if (len < 10) return res;
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0;i<=len-10;i++){
            String tmp = s.substring(i,i+10);
            map.put(tmp,map.getOrDefault(tmp,0)+1);
        }
        for (String str:map.keySet()){
            if (map.get(str) > 1){
                res.add(str);
            }
        }
        return res;
    }
}
