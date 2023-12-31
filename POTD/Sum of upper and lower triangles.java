/* Given a square matrix of size N*N, print the sum of upper and lower triangular elements. 
Upper Triangle consists of elements on the diagonal and above it. 
The lower triangle consists of elements on the diagonal and below it. */


//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    matrix[i][j] = sc.nextInt();

            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.sumTriangles(matrix,n);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return sum of upper and lower triangles of a matrix.
    static ArrayList<Integer> sumTriangles(int matrix[][], int n)
    {
        ArrayList<Integer> answer=new ArrayList<>();
        int upper=0,lower=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(i<=j)
                {
                    upper+=matrix[i][j];
                }
                if(i>=j)
                {
                    lower+=matrix[i][j];
                }
            }
        }
        answer.add(upper);
        answer.add(lower);
        return answer;
        }
}
