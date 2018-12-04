package problemSolving.algorithm.greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LargetPermutation{

    static HashMap<Integer,Integer> map=new HashMap<>();

    static int number;
    static String n="";
    // Complete the largestPermutation function below.
    static int[] largestPermutation(int k, int[] arr) {

        int b[]=Arrays.copyOf(arr,arr.length);
        Arrays.sort(b);
int index=0;
        for(int counter=0;index<k;counter++)
        {

            int temp=arr[counter];
            int max=b[b.length - counter -1];
            if(map.get(max)!=counter)
            {
                arr[counter]=max;
                map.put(temp,map.get(max));
                map.put(max,counter);
                arr[map.get(temp)]=temp;

                index++;
            }

        }
        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);

            map.put(arrItem,i);

            arr[i] = arrItem;
        }

        int[] result = largestPermutation(k, arr);

        for (int i = 0; i < result.length; i++) {
            System.out.println(String.valueOf(result[i]));


        }


        scanner.close();
    }
}

