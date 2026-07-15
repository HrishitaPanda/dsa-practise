import java.util.*;

public class ShortestSubArray{

    // Function to find the length of the shortest subarray
    public static int shortestSubarray(int[] nums, int k) {

        int n = nums.length;

        // Prefix sum array
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();

        int minLength = n + 1;

        for (int i = 0; i <= n; i++) {

            // Check if current prefix forms a valid subarray
            while (!deque.isEmpty() &&
                   prefix[i] - prefix[deque.peekFirst()] >= k) {

                minLength = Math.min(minLength, i - deque.pollFirst());
            }

            // Maintain increasing order of prefix sums
            while (!deque.isEmpty() &&
                   prefix[i] <= prefix[deque.peekLast()]) {

                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return (minLength == n + 1) ? -1 : minLength;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        int ans = shortestSubarray(nums, k);

        System.out.println("Shortest Subarray Length = " + ans);

        sc.close();
    }
}