import java.util.Scanner;

public class MaxSubarray{

    // Function to find the maximum subarray sum
    public static int maxSubArray(int[] nums) {

        // Initialize current sum and maximum sum with the first element
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Traverse the array starting from the second element
        for (int i = 1; i < nums.length; i++) {

            // Either start a new subarray or continue the existing one
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update the maximum sum if currentSum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the size of the array
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        // Create the array
        int[] nums = new int[n];

        // Read array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call the function and print the result
        int answer = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum = " + answer);

        sc.close();
    }
}