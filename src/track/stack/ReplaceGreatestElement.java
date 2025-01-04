package track.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Problem: Replace Elements with Greatest Element on Right Side
 * Link: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/
 */
public class ReplaceGreatestElement {
    /**
     * Approach 1: find next greater element from right using for loop
     */
    public static int[] replaceElements(int[] arr) {

        int n =  arr.length;
        int maxfromRight = arr[n-1];
        arr[n-1] = -1;

        for(int i=n-2;i>=0;i--)
        {
            int temp = arr[i];
            arr[i] = maxfromRight;
            if(temp>maxfromRight)
            {
                maxfromRight = temp;
            }
        }
        return arr;
    }

    //TC: O(n), SC: o(1)

    // Approach - 2: Using Stack
    // We need greatest element from right
    // So we can keep increasing value from right in stack in that way we can get top element as a greater element
    public static int[] replaceElements2(int[] arr) {
        int n = arr.length;
        int[] greatest = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Initialize the result array with -1
        Arrays.fill(greatest, -1);

        stack.push(arr[n-1]);
        for (int i = n - 2; i >= 0; i--) {
            greatest[i] = stack.peek();
            if(stack.peek() < arr[i]) {
                stack.push(arr[i]);
            }
        }

        return greatest;
    }
    //TC: O(n), SC: O(n)

    public static void main(String[] args) {
        int[] arr = new int[]{16, 17, 4, 3, 5, 2};
        int[] ans = replaceElements2(arr);
        System.out.println(Arrays.toString(ans));
    }
}
