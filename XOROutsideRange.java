import java.util.*;

public class XOROutsideRange {

    static class Solution {

        public List<Integer> specialXor(int N, int Q, int[] a, int[][] query) {

            List<Integer> ans = new ArrayList<>();

            // Prefix XOR array
            int[] prefix = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                prefix[i] = prefix[i - 1] ^ a[i - 1];
            }

            // XOR of the complete array
            int totalXor = prefix[N];

            // Process each query
            for (int i = 0; i < Q; i++) {
                int L = query[i][0];
                int R = query[i][1];

                int subXor = prefix[R] ^ prefix[L - 1];
                ans.add(totalXor ^ subXor);
            }

            return ans;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========== XOR Outside Range ==========\n");

        System.out.print("Enter the size of the array (N): ");
        int N = sc.nextInt();

        System.out.print("Enter the number of queries (Q): ");
        int Q = sc.nextInt();

        int[] a = new int[N];

        System.out.println("\nEnter " + N + " array elements:");
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        int[][] query = new int[Q][2];

        System.out.println("\nEnter " + Q + " queries (L R):");
        System.out.println("(L and R are 1-based indices of the subarray to exclude)");

        for (int i = 0; i < Q; i++) {
            query[i][0] = sc.nextInt();
            query[i][1] = sc.nextInt();
        }

        Solution sol = new Solution();
        List<Integer> result = sol.specialXor(N, Q, a, query);

        System.out.println("\nOutput:");

        for (int x : result) {
            System.out.println(x);
        }

        sc.close();
    }
}