package org.csci3130.hourie.emailvalidator;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmailValidatorTest {

  
  private final static String[] acceptedEmails = 
    {"john@email.com",
     "jane@email.com",
     "bob.smith@email.com",
     "alice@email.co.uk",
    };
  
  private final static String[] rejectedEmails = 
    {"carolemailcom",
     "johnemail.com",
     "jane@emailcom",
     "bob.smith@email@com",
     // Stage2 test case: Emails cannot start or end with a '.'
     ".bob.smith@email.com", 
     "bob.smith@email.com.",
     // Stage2 test case: Emails cannot start or end with a '@'
     "@bob.smith@email.com",
     "bob.smith.email.com@"
    };

  /**
   * Test which checks a list of known good emails 
   * to see if they are valid.
   */
  @Test
  public void testAcceptedEmails() {
   EmailValidator emailValidator = EmailValidator.getInstance();
   assertNotNull(emailValidator);
   
   // Check all of the known acceptable email addresses
   for (String email : acceptedEmails){
     boolean result = emailValidator.isValid(email);
     assertTrue(result);
   }
  }
  
  
  /**
   * Test which checks a list of known bad emails
   * to see if they are valid. 
   */
  @Test
  public void TestRejectedEmails() {
    EmailValidator emailValidator = EmailValidator.getInstance();
    assertNotNull(emailValidator);

    // Check all of the known unacceptable email addresses
    for (String email : rejectedEmails){
      boolean result = emailValidator.isValid(email);
      assertFalse(result);   
    } 
  }
}
