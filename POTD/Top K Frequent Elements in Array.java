//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i + 1]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[] ans = obj.topK(nums, k);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] topK(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a list of map entries (element, frequency)
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

        // Sort the list in descending order of frequency and element
        Collections.sort(entryList, (a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return b.getKey() - a.getKey();
            }
            return b.getValue() - a.getValue();
        });

        // Take the top k elements
        int[] topKElements = new int[k];
        for (int i = 0; i < k; i++) {
            topKElements[i] = entryList.get(i).getKey();
        }

        return topKElements;
    }
}
