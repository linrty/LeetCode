package s1694;

public class Solution {
    public String reformatNumber(String number) {
        int len = number.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (number.charAt(i) != ' ' && number.charAt(i) != '-'){
                stringBuilder.append(number.charAt(i));
            }
        }
        int resLen = stringBuilder.length();
        int j = 0;
        while(true){
            int endLen = resLen - j + 1;
            if (endLen == 2 || endLen == 3) break;
            switch (endLen){
                case 4:
                    j = j + 2;
                    stringBuilder.insert(j, '-');
                    j++;
                    break;
                default:
                    j = j + 3;
                    stringBuilder.insert(j, '-');
                    j++;
                    break;
            }

        }
        return stringBuilder.toString();
    }
}
