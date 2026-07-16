import java.util.*;

public class Lightsabers {

    static class Solution {

        public int minimumRemovals(int n, int m, int[] colors, int[] required) {

            int[] count = new int[m + 1];

            int totalRequired = 0;

            for (int x : required)
                totalRequired += x;

            int alreadySatisfied = 0;

            for (int i = 0; i < m; i++) {
                if (required[i] == 0)
                    alreadySatisfied++;
            }

            int satisfied = alreadySatisfied;

            int left = 0;
            int minWindow = Integer.MAX_VALUE;

            for (int right = 0; right < n; right++) {

                int color = colors[right];

                count[color]++;

                if (count[color] == required[color - 1]) {
                    satisfied++;
                }

                while (satisfied == m) {

                    minWindow = Math.min(minWindow, right - left + 1);

                    int leftColor = colors[left];

                    count[leftColor]--;

                    if (count[leftColor] < required[leftColor - 1]) {
                        satisfied--;
                    }

                    left++;
                }
            }

            if (minWindow == Integer.MAX_VALUE)
                return -1;

            return minWindow - totalRequired;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========== Lightsabers ==========");

        System.out.print("Enter number of Jedi Knights (n): ");
        int n = sc.nextInt();

        System.out.print("Enter number of colors (m): ");
        int m = sc.nextInt();

        int[] colors = new int[n];

        System.out.println("Enter the colors of " + n + " Jedi Knights:");

        for (int i = 0; i < n; i++) {
            colors[i] = sc.nextInt();
        }

        int[] required = new int[m];

        System.out.println("Enter required count for each of the " + m + " colors:");

        for (int i = 0; i < m; i++) {
            required[i] = sc.nextInt();
        }

        Solution sol = new Solution();

        int answer = sol.minimumRemovals(n, m, colors, required);

        System.out.println("--------------------------------");

        if (answer == -1)
            System.out.println("No valid interval is possible.");
        else
            System.out.println("Minimum Removals = " + answer);

        sc.close();
    }
}