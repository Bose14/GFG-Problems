/* Given two strings 'str1' and 'str2', check if these two strings are isomorphic to each other.

If the characters in str1 can be changed to get str2, then two strings, str1 and str2, are isomorphic. 

A character must be completely swapped out for another character while maintaining the order of the characters. 

A character may map to itself, but no two characters may map to the same character. */


//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();
        if(len1 != len2) return false;
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for(int i=0; i<len1; i++){
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if(map1.containsKey(ch1)){
                if(map1.get(ch1) != ch2) return false;
            }
            else{
                map1.put(ch1, ch2);
            }
            if(map2.containsKey(ch2)){
                if(map2.get(ch2) != ch1) return false;
            }
            else{
                map2.put(ch2, ch1);
            }
        }
        return true;
        
    }
}
