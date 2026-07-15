import java.util.*;

public class PowerSet {

    // Stores all subsets
    static List<List<Integer>> result = new ArrayList<>();

    // Backtracking function
    public static void generateSubsets(int[] nums, int index, List<Integer> current) {

        // Store current subset
        result.add(new ArrayList<>(current));

        // Try every remaining element
        for (int i = index; i < nums.length; i++) {

            // Choose
            current.add(nums[i]);

            // Explore
            generateSubsets(nums, i + 1, current);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========== Power Set ==========\n");

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter " + n + " distinct integers:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        generateSubsets(nums, 0, new ArrayList<>());

        System.out.println("\nPower Set:");

        for (List<Integer> subset : result) {
            System.out.println(subset);
        }

        System.out.println("\nTotal Subsets = " + result.size());

        sc.close();
    }
}