import java.util.*;

public class ClosestTripletSum {

    static class Solution {

        public int closestTripletSum(int[] arr, int target) {

            if (arr.length < 3) {
                throw new IllegalArgumentException("Array must contain at least 3 elements.");
            }

            Arrays.sort(arr);

            int n = arr.length;
            int closestSum = arr[0] + arr[1] + arr[2];

            for (int i = 0; i < n - 2; i++) {

                int left = i + 1;
                int right = n - 1;

                while (left < right) {

                    int sum = arr[i] + arr[left] + arr[right];

                    // Better answer found
                    if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                        closestSum = sum;
                    }
                    // Same difference, choose the larger sum
                    else if (Math.abs(sum - target) == Math.abs(closestSum - target)
                            && sum > closestSum) {
                        closestSum = sum;
                    }

                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        // Exact match
                        return sum;
                    }
                }
            }

            return closestSum;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("        3 Sum Closest Problem");
        System.out.println("===================================");

        System.out.print("Enter the number of elements (N): ");
        int n = sc.nextInt();

        if (n < 3) {
            System.out.println("Array must contain at least 3 elements.");
            sc.close();
            return;
        }

        int[] arr = new int[n];

        System.out.println("Enter " + n + " integers:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the target value: ");
        int target = sc.nextInt();

        Solution sol = new Solution();

        int answer = sol.closestTripletSum(arr, target);

        System.out.println("-----------------------------------");
        System.out.println("Closest Triplet Sum = " + answer);
        System.out.println("-----------------------------------");

        sc.close();
    }
}