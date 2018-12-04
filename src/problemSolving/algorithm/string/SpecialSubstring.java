package problemSolving.algorithm.string;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SpecialSubstring {

    // Complete the substrCount function below.
    static long substrCount( String s) {

        HashSet<Character> set=new HashSet<>();
        long counter=0;
        for(int length=0;length<s.length();length++)
        {

            for(int startIndex=0;(length+startIndex)<s.length();startIndex++)
            {
                if(checkPalindrome(startIndex,startIndex+length,s,set))
                {
                   // System.out.println(s.substring(startIndex,startIndex+length+1));
                    counter++;
                }

            }
        }

        return counter;

    }

    public static boolean checkPalindrome(int startIndex, int endIndex, String s, HashSet<Character> set)
    {
        int index=startIndex;

        boolean isPalindrome=true;
        if((endIndex-startIndex+1)%2==0)
        {



            while(index<=endIndex)
            {
                set.add(s.charAt(index));
                index++;
                if(set.size()>1)
                {
                    isPalindrome=false;

                    break;
                }
            }

        }
        else
        {
            int mid=(endIndex+startIndex)/2;

            while(index<=endIndex)
            {
                if(index!=mid)
                    set.add(s.charAt(index));

                if(set.size()>1)
                {
                    isPalindrome=false;

                    break;
                }
                index++;
            }
        }

        set.clear();
        if(isPalindrome)
            return true;
        else
            return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount( s);


        System.out.println(result);
      //  bufferedWriter.write(String.valueOf(result));
      //  bufferedWriter.newLine();

      //  bufferedWriter.close();

        scanner.close();
    }
}
