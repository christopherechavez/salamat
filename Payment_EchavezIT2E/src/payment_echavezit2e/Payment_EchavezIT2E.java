
package payment_echavezit2e; // Corrected package name

import java.sql.Connection; // Assuming 'config' handles database connection
import java.sql.PreparedStatement; // For prepared statements (security)
import java.sql.SQLException; // Handle potential database exceptions
import java.util.Scanner;

public class PaymentEchavezIT2E {

    static Scanner sc = new Scanner(System.in);

    // Removed unnecessary second instance of 'config'
    // Assuming 'config' class handles database connection logic

    public void addPayment(Connection conn) throws SQLException { // Handle potential SQL exceptions
        String sql = "INSERT INTO tbl_payment (pid, p_payment_d, p_payment_m, p_status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sc.next()); // Get payment ID
            pstmt.setString(2, sc.next()); // Get payment amount
            pstmt.setString(3, sc.next()); // Get payment date
            pstmt.setString(4, sc.next()); // Get payment method
            pstmt.setString(5, sc.next()); // Get payment status
            pstmt.executeUpdate();
            System.out.println("Payment added successfully!");
        }
    }

    public static void main(String[] args) throws SQLException {
        // ... Replace with actual database connection code (assuming it's in 'config')
        Connection conn = getConnection();

        String resp;

        do {
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.print("Enter action: ");
            int action = sc.nextInt();

            PaymentEchavezIT2E test = new PaymentEchavezIT2E();

            switch (action) {
                case 1:
                    test.addPayment(conn);
                    break;
                case 2:
                    test.viewPayment(conn); // Implement viewPayment logic here (connect to DB, execute query)
                    break;
                case 3:
                    test.updatePayment(conn); // Implement updatePayment logic here (connect to DB, execute query)
                    break;
                case 4:
                    test.deletePayment(conn); // Implement deletePayment logic here (connect to DB, execute query)
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid action. Please try again.");
            }

            System.out.print("Continue? (yes/no): ");
            resp = sc.next();

        } while (resp.equalsIgnoreCase("yes"));

        System.out.println("Thank You!");
        conn.close(); // Close database connection (assuming 'config' handles it)
    }

    // Implement viewPayment, updatePayment, and deletePayment methods here
    // These methods will likely involve connecting to the database, executing queries,
    // and handling results. You'll need to fill in the details based on your specific database schema.

    public void viewPayment(Connection conn) throws SQLException {
        // ... Replace with your code to connect to database, execute SELECT query, and display results
    }

    public void updatePayment(Connection conn) throws SQLException {
        // ... Replace with your code to connect to database, execute UPDATE query based on user choice
    }

    public void deletePayment(Connection conn) throws SQLException {
        // ... Replace with your code to connect to database, execute DELETE query based on user input
    }
}