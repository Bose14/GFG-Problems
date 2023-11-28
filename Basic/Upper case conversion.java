//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String str = br.readLine();
                    Solution ob = new Solution();
                    System.out.println(ob.transform(str));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String transform(String s)
    {
       StringBuffer s1 = new StringBuffer();
        char ch = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (ch == ' ' && s.charAt(i) != ' ')
                s1.append(
                    Character.toUpperCase(s.charAt(i)));
            else
                s1.append(s.charAt(i));
            ch = s.charAt(i);
        }
        return s1.toString().trim();
    }
}
