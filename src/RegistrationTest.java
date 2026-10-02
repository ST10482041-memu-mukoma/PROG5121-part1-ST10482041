import org.junit.Test;
import static org.junit.Assert.*;

public class RegistrationTest {
    
    Registration reg = new Registration();
    
    // ========== USERNAME TESTS ==========
    
    @Test
    public void testUsernameCorrectlyFormatted() {
        assertTrue(reg.checkUserName("kyl_1"));
    }
    
    @Test
    public void testUsernameIncorrectlyFormatted() {
        assertFalse(reg.checkUserName("kyle!!!!!!"));
    }
    
    // ========== PASSWORD TESTS ==========
    
    @Test
    public void testPasswordMeetsRequirements() {
        assertTrue(reg.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
    
    @Test
    public void testPasswordDoesNotMeetRequirements() {
        assertFalse(reg.checkPasswordComplexity("password"));
    }
    
    // ========== CELL PHONE TESTS ==========
    
    @Test
    public void testCellPhoneCorrectlyFormatted() {
        assertTrue(reg.checkCellPhoneNumber("+27838968976"));
    }
    
    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        assertFalse(reg.checkCellPhoneNumber("08966553"));
    }
    
    // ========== REGISTRATION TESTS ==========
    
    @Test
    public void testRegisterUserSuccess() {
        String result = reg.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Username successfully captured.", result);
    }
    
    @Test
    public void testRegisterUserBadUsername() {
        String result = reg.registerUser("kyle!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }
    
    @Test
    public void testRegisterUserBadPassword() {
        String result = reg.registerUser("kyl_1", "password", "+27838968976");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);
    }
    
    @Test
    public void testRegisterUserBadCellPhone() {
        String result = reg.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553");
        assertEquals("Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.", result);
    }
    
    // ========== LOGIN TESTS ==========
    
    @Test
    public void testLoginSuccess() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }
    
    @Test
    public void testLoginFailureWrongPassword() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!");
        assertFalse(login.loginUser("kyl_1", "wrongpassword"));
    }
    
    @Test
    public void testLoginFailureWrongUsername() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!");
        assertFalse(login.loginUser("wronguser", "Ch&&sec@ke99!"));
    }
    
    @Test
    public void testReturnLoginStatusSuccess() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!");
        String result = login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertEquals("Welcome Kyle, Smith it is great to see you again.", result);
    }
    
    @Test
    public void testReturnLoginStatusFailure() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!");
        String result = login.returnLoginStatus("kyl_1", "wrong", "Kyle", "Smith");
        assertEquals("Username or password incorrect, please try again.", result);
    }
}