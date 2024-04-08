package s71;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/9/10 8:56
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        String path = new String("///eHx/..");
        System.out.println(new Solution().simplifyPath(path));
    }

    public String simplifyPath(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] pathChar = path.toCharArray();
        int len = path.length();
        int i = 0;
        while (i < len){
            System.out.println(stringBuilder.toString());
            while (i<len && pathChar[i] == '/'){
                i++;
            }
            StringBuilder name = new StringBuilder();
            while (i<len && pathChar[i]!='/'){
                name.append(pathChar[i]);
                i++;
            }
            String nameString = name.toString();
            if ("".equals(nameString)){
                if ("".equals(stringBuilder.toString())){
                    stringBuilder.append('/');
                }
                break;
            }else{
                if (".".equals(nameString)){
                    if ("".equals(stringBuilder.toString())){
                        stringBuilder.append('/');
                    }
                }else if ("..".equals(nameString)){
                    if ("/".equals(stringBuilder.toString())){
                    }else{
                        if ("".equals(stringBuilder.toString())){
                            stringBuilder.append('/');
                            continue;
                        }
                        int sLen = stringBuilder.length()-1;
                        int stringLen = sLen;
                        while (sLen>=1 && stringBuilder.charAt(sLen) != '/'){
                            stringBuilder.deleteCharAt(sLen);
                            sLen--;
                        }
                        stringBuilder.deleteCharAt(sLen);
                        /*if (sLen == 0){
                            stringBuilder.delete(0,stringLen-1);
                        }else{
                            System.out.println(sLen);
                            System.out.println(stringLen);
                            stringBuilder.delete(sLen-1,stringLen);
                        }*/
                    }
                }else{
                    if ("/".equals(stringBuilder.toString())){
                        stringBuilder.append(nameString);
                    }else{
                        stringBuilder.append('/');
                        stringBuilder.append(nameString);
                    }
                }
            }
        }
        if ("".equals(stringBuilder.toString())){
            stringBuilder.append('/');
        }
        if (stringBuilder.length()!=1 && stringBuilder.charAt(stringBuilder.length()-1) == '/'){
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        return stringBuilder.toString();
    }
}
