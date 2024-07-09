package meidi;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Arrays;
import java.util.Scanner;

public class s2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int k = 0 ; k < n; k++)  a[k] = scanner.nextInt();
        int i = 0;
        int j = n - 1;
        while (i < j){
            while (i < j && a[i]%2 == 1) i++;
            while(j > i && a[j]%2 == 0) j--;
            if (i >= j) break;
            int num = a[i];
            a[i] = a[j];
            a[j] = num;
        }
        int pos = 0;
        while(a[pos] %2 == 1) pos++;
        if (pos == 0 || pos == n){
            Arrays.sort(a);
        }else{
            Arrays.sort(a,0,pos);
            Arrays.sort(a,pos,n);
        }
        for (int k = 0 ; k < n; k++){
            if (k == 0) System.out.print(a[k]);
            else System.out.print(" " + a[k]);
        }

    }
}
