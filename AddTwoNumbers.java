import java.util.Scanner;

// Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class AddTwoNumbers {

    // Function to add two numbers represented by linked lists
    public static Node addTwoNumbers(Node head, Node head1) {

        Node dummy = new Node(0);
        Node curr = dummy;

        int carry = 0;

        while (head != null || head1 != null || carry != 0) {

            int sum = carry;

            if (head != null) {
                sum += head.data;
                head = head.next;
            }

            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }

            carry = sum / 10;

            curr.next = new Node(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
    }

    // Create linked list
    public static Node createList(Scanner sc, int n) {

        if (n == 0)
            return null;

        Node head = new Node(sc.nextInt());
        Node temp = head;

        for (int i = 1; i < n; i++) {
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }

        return head;
    }

    // Print linked list
    public static void printList(Node head) {

        while (head != null) {
            System.out.print(head.data);

            if (head.next != null)
                System.out.print(" -> ");

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // First linked list
        System.out.print("Enter number of nodes in first linked list: ");
        int n1 = sc.nextInt();

        System.out.println("Enter elements:");
        Node head = createList(sc, n1);

        // Second linked list
        System.out.print("Enter number of nodes in second linked list: ");
        int n2 = sc.nextInt();

        System.out.println("Enter elements:");
        Node head1 = createList(sc, n2);

        // Add the two linked lists
        Node result = addTwoNumbers(head, head1);

        // Print result
        System.out.println("Result Linked List:");
        printList(result);

        sc.close();
    }
}