package s777;

public class Solution {
    public boolean canTransform(String start, String end) {
        int len = start.length();
        int i,j;
        i = j = 0;
        StringBuilder startBuilder = new StringBuilder(start);

        StringBuilder endBuilder = new StringBuilder(end);
        while(j < len){
            while(j<len && endBuilder.charAt(j) == 'X'){
                j++;
            }
            while(i<len && startBuilder.charAt(i) == 'X'){
                i++;
            }
            if (i==len && j == len){
                return true;
            }
            if ((i==len && j!=len) || (i!=len && j==len)){
                return false;
            }
            if (endBuilder.charAt(j) != startBuilder.charAt(i)){
                return false;
            }
            if (i > j){
                if(startBuilder.charAt(i) == 'R'){
                    return false;
                }
                startBuilder.deleteCharAt(i);
                startBuilder.insert(j,endBuilder.charAt(j));
                j++;
                i = j;
            }else if (j > i){
                if(startBuilder.charAt(i) == 'L'){
                    return false;
                }
                endBuilder.deleteCharAt(j);
                endBuilder.insert(i,startBuilder.charAt(i));
                i++;
                j = i;
            }else{
                i++;
                j++;
            }
        }
        return true;
    }
}
