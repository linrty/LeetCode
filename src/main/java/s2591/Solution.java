package s2591;

public class Solution {
    public int distMoney(int money, int children) {
        int res = 0;
        int sum = money - children;
        if (children * 7 > sum) {
            res = sum / 7;
            if (sum % 7 == 3 && res == children - 1){
                res--;
            }
        } else if (children * 7 == sum) {
            res = children;
        }else {
            res = children - 1;
        }
        return res;
    }
}
