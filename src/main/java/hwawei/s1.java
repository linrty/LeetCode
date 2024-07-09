package hwawei;

import java.util.Arrays;
import java.util.Scanner;

public class s1 {

    public static void main(String[] args) {
        int [] nums = new int[1000];
        Scanner scanner = new Scanner(System.in);
        int pos = 0;
        String str = scanner.nextLine();
        int x = scanner.nextInt();
        for (String s : str.split(" ")) {
            nums[pos++] = Integer.parseInt(s);
        }
        Arrays.sort(nums, 0, pos);
        Arrays.binarySearch(nums, 0, pos, x);
        int a = 'A' - 'a';
        int left = 0;
        int right = pos - 1;
        int mid = 0;
        char[] path = new char[1000];
        int p = 1;
        while(left <= right) {
            mid = (left + right) / 2;
            // System.out.println("mid: " + mid + " left: " + left + " right: " + right);
            if (nums[mid] == x) {
                path[p++] = 'Y';
                break;
            } else if (nums[mid] < x) {
                left = mid + 1;
                path[p++] = 'R';
            } else {
                right = mid - 1;
                path[p++] = 'L';
            }
        }
        if (path[p-1] == 'Y') {
            path[0] = 'S';
            for (int i = 0; i < p; i++) {
                System.out.print(path[i]);
            }
        } else {
            System.out.println("N");
        }
    }

}
