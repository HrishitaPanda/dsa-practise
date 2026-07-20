import java.util.*;

public class SubarraySumDivisibleByK {

    public static long subarraysDivByK(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Remainder 0 has occurred once before processing any element
        map.put(0, 1);

        long answer = 0;
        long prefixSum = 0;

        for (int num : arr) {

            prefixSum += num;

            // Handle negative numbers
            int remainder = (int) ((prefixSum % k + k) % k);

            // If this remainder has been seen before,
            // all previous occurrences form valid subarrays
            answer += map.getOrDefault(remainder, 0);

            // Store/update the frequency of this remainder
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========== Subarray Sum Divisible By K ==========\n");

        // Read array
        System.out.println("Enter the array elements (space-separated):");
        String[] input = sc.nextLine().trim().split("\\s+");

        int[] arr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Read k
        System.out.print("\nEnter the value of k: ");
        int k = sc.nextInt();

        // Find answer
        long result = subarraysDivByK(arr, k);

        // Display output
        System.out.println("\nNumber of subarrays whose sum is divisible by " + k + " = " + result);

        sc.close();
    }
}