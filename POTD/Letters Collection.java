/*The Postmaster wants to write a program to answer the queries regarding letter collection in a city. 
A city is represented as a matrix mat of size n*m.
Each cell represents a house and contains letters which are denoted by a number in the cell. 
The program should answer q queries which are of following types:
1 i j : To sum all the letters which are at a 1-hop distance from the cell (i,j) in any direction
2 i j : To sum all the letters which are at a 2-hop distance from the cell (i,j) in any direction 
The queries are given in a 2D matrix queries[][].
In one hop distance postmaster can go to any of [(i-1,j-1), (i-1,j), (i-1,j+1), (i,j-1), (i,j+1), (i+1,j-1), (i+1,j), (i+1,j+1)] from (i,j). */




//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int mat[][] = new int[n][m];
            for(int i = 0;i < n;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < m;j++)
                    mat[i][j] = Integer.parseInt(a[j]);
            }
            int q = Integer.parseInt(in.readLine());
            int queries[][] = new int[q][3];
            for(int i = 0;i < q;i++){
                String a1[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < 3;j++)
                    queries[i][j] = Integer.parseInt(a1[j]);
            }
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.matrixSum(n, m, mat, q, queries);
            for(int i = 0;i < q;i++)
                System.out.println(ans.get(i));
        }
    }
}
// } Driver Code Ends
//User function Template for Java
class Solution{
    static List<Integer> matrixSum(int n, int m, int mat[][], int q, int queries[][])
    {
        List<Integer> answer = new ArrayList<>();
        int i1[]= {-1,-1,-1,0,0,1,1,1}; 
        int j1[]= {-1,0,1,-1,1,-1,0,1};
        int i2[]={-2, -2, -2, -2, -2, -1, -1,0,0,1,1,2,2,2,2,2}; 
        int j2[] = {-2,-1,0,1,2,-2,2,-2,2,-2,2,-2, -1,0,1,2};
        for (int i=0; i<q; i++) 
        {
            int sum=0;
            int x = queries[i][1], y=queries [i][2];
            if (queries[i][0]==1) 
            { 
                for (int k=0; k<8; k++) 
                {
                    int numx = x + i1[k], numy = y + j1[k]; 
                    if (numx>= 0 && numx<n && numy>=0 && numy<m) 
                    { 
                        sum += mat [numx][numy];                        
                    }
                }
            }
            else
            { 
                for (int k=0; k<16; k++) 
                {
                    int numx = x + i2[k], numy = y + j2[k]; 
                    if (numx>=0 && numx<n && numy>= 0 && numy<m) 
                    { 
                        sum += mat[numx][numy];   
                    }
                }
            }
            answer.add(sum);               
        }
        return answer;                 
    }                  
}
