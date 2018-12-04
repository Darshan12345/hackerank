package problemSolving.algorithm.greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Djkstras {


    static class Node{
        int V;
        int adjacent[][];

        public Node(int v)
        {
            V=v;
            adjacent=new int[v][v];
        }



    }

    // Complete the shortestReach function below.
    static int[] shortestReach(int n, int[][] edges, int s) {

        Node node=new Node(n);
        int []result=new int[n];
        boolean []visited=new boolean[n];
        for(int i=0;i<n;i++)
        {
            result[i]=Integer.MAX_VALUE;

        }

        result[s-1]=0;
        for(int row=0;row<edges.length;row++)
        {

            node.adjacent[edges[row][0]-1][edges[row][1]-1]=edges[row][2];

            node.adjacent[edges[row][1]-1][edges[row][0]-1]=edges[row][2];
              //System.out.println("Node:"+node.adjacent[edges[row][0]-1][edges[row][1]-1]);

        }


        for(int counter=0;counter<n;counter++)
        {
            int index=findMin(result,visited);
            visited[index]=true;

            for(int i=0;i<n;i++)
            {
                // System.out.println("current node:"+index+"\tadjacent:"+i);
                if((node.adjacent[index][i]!=0) && !visited[i] && ( result[i]> result[index]+node.adjacent[index][i]) && result[index]!=Integer.MAX_VALUE )
                {
                    result[i]=result[index]+node.adjacent[index][i];

                    // System.out.println("edge:\t"+index+"\t"+i+"\t sum:"+result[i]);
                }
            }
        }
        return result;

    }

    static int findMin(int result[], boolean []visited){
        int min=Integer.MAX_VALUE;
        int i=-1;
        for(int index=0;index<result.length;index++)
        {
            if(result[index]<=min && !visited[index])
            {
                min=result[index];
                i=index;

            }
        }
        return i;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][3];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 3; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = shortestReach(n, edges, s);

            for (int i = 0; i < result.length; i++) {
                if(result[i]!=0)
                    System.out.println(String.valueOf(result[i])+"\t");


            }

        }

        scanner.close();
    }
}
