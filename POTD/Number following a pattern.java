/* Given a pattern containing only I's and D's. I for increasing and D for decreasing. Devise an algorithm to print the minimum number following that pattern. Digits from 1-9 and digits can't repeat. */



//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S){
        Stack<Integer> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int n = 1;
            for (int i=0; i<S.length(); i++) {
                stack.push(n++);
                if (S.charAt(i) == 'I') {
                    while (!stack.isEmpty()) {
                        sb.append(String.valueOf(stack.pop()));
                    }
                }
            }
            stack.push(n);
            while (!stack.isEmpty()) {
                sb.append(String.valueOf(stack.pop()));
                
            }
            return sb.toString();
    }
}
