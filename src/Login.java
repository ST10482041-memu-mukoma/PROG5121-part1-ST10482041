public class Login {
    
    // Store registered credentials for comparison
    private String registeredUsername;
    private String registeredPassword;
    
    // Constructor - stores the registered user details
    public Login(String username, String password) {
        this.registeredUsername = username;
        this.registeredPassword = password;
    }
    
    // Method 1: Verify login details match registered details
    public boolean loginUser(String username, String password) {
        if (username == null || password == null) return false;
        return username.equals(registeredUsername) 
            && password.equals(registeredPassword);
    }
    
    // Method 2: Return login status message
    public String returnLoginStatus(String username, String password, 
                                     String firstName, String lastName) {
        if (loginUser(username, password)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}