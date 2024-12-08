package track.arrays;

/**
 * Problem: Given a string s consisting of only '0's and '1's,  find the last index of the '1' present.
 * Note: If '1' is not present, return "-1"
 * Link: https://www.geeksforgeeks.org/problems/last-index-of-15847/1
 */
public class LastIndex {
    public static int approach1(String s) {

        int n = s.length()-1;

        while(n>=0)
        {
            if(s.charAt(n)=='1')
            {
                return n;
            }
            n--;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "0";
        int ans = approach1(s);
        System.out.println(ans);
    }
}
