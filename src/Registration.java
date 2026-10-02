public class Registration {
    
    // Method 1: Check if username contains underscore and is max 5 chars
    public boolean checkUserName(String username) {
        if (username == null) return false;
        if (username.length() > 5) return false;
        if (!username.contains("_")) return false;
        return true;
    }
    
    // Method 2: Check if password meets complexity rules
    public boolean checkPasswordComplexity(String password) {
        if (password == null) return false;
        if (password.length() < 8) return false;
        
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) hasCapital = true;
            if (Character.isDigit(c)) hasNumber = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        
        return hasCapital && hasNumber && hasSpecial;
    }
    
    // Method 3: Check cell phone number with regex
    // Attribution: Regex pattern based on South African international format
    // Reference: Apache Commons Validator, https://commons.apache.org/proper/commons-validator/
    public boolean checkCellPhoneNumber(String cellPhone) {
        if (cellPhone == null) return false;
        // South African international format: +27 followed by 9 digits
        String regex = "^\\+27[0-9]{9}$";
        return cellPhone.matches(regex);
    }
    
    // Method 4: Register user - returns message based on validation
    public String registerUser(String username, String password, String cellPhone) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }
        return "Username successfully captured.";
    }
}