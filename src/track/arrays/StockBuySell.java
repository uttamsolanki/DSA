package track.arrays;

/**
 * Problem: Given an array are denoting the cost of stock on each day, the task is to find the maximum total profit if we can buy and sell the stocks any number of times.
 * Note: We can only sell a stock which we have bought earlier and we cannot hold multiple stocks on any day.
 * Link: https://www.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1
 */
public class StockBuySell {
    public static int approach1(int[] arr) {
        int maxProfit = 0;
        int totalProfit = 0;
        int min = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            int profit = arr[i]-min;
            if(arr[i-1]>arr[i])
            {
                totalProfit+=maxProfit;
                min = arr[i];
                profit=0;
                maxProfit=0;
            }
            else
                maxProfit = Math.max(maxProfit,profit);
        }
        return totalProfit+maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 2, 2, 4};
        int ans = approach1(arr);
        System.out.println(ans);
    }
}
