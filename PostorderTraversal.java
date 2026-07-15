import java.util.*;

// Tree Node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class PostorderTraversal {

    // Function to perform postorder traversal
    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;
        TreeNode lastVisited = null;

        while (curr != null || !st.isEmpty()) {

            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {

                TreeNode peek = st.peek();

                if (peek.right != null && lastVisited != peek.right) {
                    curr = peek.right;
                } else {
                    ans.add(peek.val);
                    lastVisited = st.pop();
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        // Creating the tree
        //
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7
        //

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> result = postorderTraversal(root);

        System.out.println("Postorder Traversal:");

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}