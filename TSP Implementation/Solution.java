import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the howManyGoodSubarrays function below.
    static long howManyGoodSubarrays(int[] array, int m, int k) {

           
        int count = 0; 
    int i, j, mul; 
 
    for (i = 0; i < n; i++)
    {
        // Counter for single element
        if (array[i]%m==k)
            count++;
 
        mul = array[i];
 
        for (j = i + 1; j < n; j++) 
        {
            // Multiple subarray
            mul = mul * array[j]; 
            // If this multiple is less
            // than k, then increment
            if (mul%m==k) 
                count++; 
            else
                break; 
        }
    }
 
    return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nmk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmk[0]);

            int m = Integer.parseInt(nmk[1]);

            int k = Integer.parseInt(nmk[2]);

            int[] A = new int[n];

            String[] AItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int AItem = Integer.parseInt(AItems[i]);
                A[i] = AItem;
            }

            long result = howManyGoodSubarrays(A, m, k);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
