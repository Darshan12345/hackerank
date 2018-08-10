package problemSolving.algorithm.greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinAbsoluteDifference {

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {

        int first=0,second=0;
        Arrays.sort(arr);
        int minDifference=Math.abs(arr[0]-arr[1]);
        int currentDif=0;

        long startTime=System.nanoTime();
        for(int i=1;i<arr.length-1;i++)
        {
            currentDif=Math.abs(arr[i]-arr[i+1]);
            if(minDifference>currentDif)
            {
                minDifference=currentDif;
            }

        }
        long end=System.nanoTime();
       // System.out.println("Time:"+end-startTime);
        return minDifference;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
  //      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(arr);

        System.out.println(result);

        scanner.close();
    }
}
