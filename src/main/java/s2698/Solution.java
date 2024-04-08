package s2698;

public class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1;i<=n;i++){
            int num = i*i;
            if (dfs(num,0,i)){
                res+=num;
            }
        }
        return res;
    }
    public boolean dfs(int num,int sum,int i){
        if (num == 0){
            if (sum == i){
                return true;
            }else{
                return false;
            }
        }
        int tmp = 10;
        while(true){
            if (dfs(num/tmp,sum+num%tmp,i)){
                return true;
            }
            if (num/tmp == 0){
                break;
            }
            tmp *= 10;
        }
        return false;
    }
}
