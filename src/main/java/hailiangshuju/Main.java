package hailiangshuju;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Map<String, Integer>map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            String s = String.valueOf(str.charAt(i));
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())){
                return o1.getKey().compareTo(o2.getKey());
            }else{
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry: list){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
