import java.util.*;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Store all elements in HashSet
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Traverse the HashSet
        for (int num : set) {

            // Check if the current number is the start of a sequence
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                // Count consecutive numbers
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========== Longest Consecutive Sequence ==========\n");

        // Read size of array
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        System.out.println("\nEnter " + n + " integers (space-separated or one per line):");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Find answer
        int result = longestConsecutive(nums);

        // Display output
        System.out.println("\nLength of the Longest Consecutive Sequence = " + result);

        sc.close();
    }
}