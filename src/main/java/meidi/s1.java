package meidi;

public class s1 {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            int num = i;
            int num1 = i % 10;
            int num2 = (i/10)%10;
            int num3 = i/100;
            if (num1 * num1 * num1 + num2 * num2 * num2 + num3 * num3 * num3 == i){
                System.out.println(i);
            }
        }
    }
}
