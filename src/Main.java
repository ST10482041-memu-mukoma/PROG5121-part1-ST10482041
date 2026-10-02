import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Registration reg = new Registration();
        
        System.out.println("=== PROG5121 Registration System ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter cell phone (e.g., +27838968976): ");
        String cellPhone = scanner.nextLine();
        
        String result = reg.registerUser(username, password, cellPhone);
        System.out.println(result);
        if (result.equals("Username successfully captured.")) {
            System.out.println("\n=== Login System ===");
            Login login = new Login(username, password);
            
            System.out.print("Enter username to login: ");
            String loginUser = scanner.nextLine();
            System.out.print("Enter password to login: ");
            String loginPass = scanner.nextLine();
            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter your last name: ");
            String lastName = scanner.nextLine();
            
            String loginStatus = login.returnLoginStatus(loginUser, loginPass, firstName, lastName);
            System.out.println(loginStatus);
        }
        scanner.close();
    }
}

