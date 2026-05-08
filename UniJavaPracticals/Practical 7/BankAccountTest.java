
import static org.junit.Assert.*;
import org.junit.Test;
import java.math.BigDecimal;

/**
 * Unit test for bank accounts with fixed-precision numbers
 */
public class BankAccountTest
{

    @Test
    public void accountCreationTest()
    {
        BankAccount myAccount = new BankAccount(12345);
        assertEquals("Testing account number", 12345, myAccount.accountNumber);
        assertEquals("Testing initial balance", "0.00", myAccount.balance.toString());        
        assertEquals("Testing initial overdraft limit", "100.00", myAccount.overdraftLimit.toString());        
    }
    
    @Test
    public void depositTest()
    {
        BankAccount myAccount = new BankAccount(12345);
        
        BigDecimal dep = new BigDecimal("1.5");
        myAccount.deposit(dep);
        assertEquals("Testing deposit of 1.5", "1.50", myAccount.currentBalance().toString());

        BigDecimal dep2 = new BigDecimal("5");
        myAccount.deposit(dep2);
        assertEquals("Testing second deposit of 5", "6.50", myAccount.currentBalance().toString());
    }

    private void oneWithdrawalTest(String toWithdraw, String expected)
    {
        BankAccount myAccount = new BankAccount(12345);

        BigDecimal dep = new BigDecimal("100");
        myAccount.deposit(dep);
        assertEquals("Testing deposit of 100", "100.00", myAccount.currentBalance().toString());
        
        BigDecimal wd = new BigDecimal(toWithdraw);
        assertTrue("Testing withdrawal of "+toWithdraw, myAccount.withdraw(wd));
        assertEquals("Testing withdrawal of "+toWithdraw, expected, myAccount.currentBalance().toString());
    }
    
    @Test
    public void withdrawalTest()
    {
        oneWithdrawalTest("5", "95.00");
        oneWithdrawalTest("9.12", "90.88");
        oneWithdrawalTest("199.5", "-99.50");

    }
    
    @Test
    public void withdrawalOverdraftTest()
    {
        BankAccount myAccount = new BankAccount(12345);
        
        BigDecimal dep = new BigDecimal("100");
        myAccount.deposit(dep);
        assertEquals("Testing deposit of 100", "100.00", myAccount.currentBalance().toString());

        BigDecimal wd = new BigDecimal("205");
        assertFalse("Testing withdrawal of 205", myAccount.withdraw(wd));
        assertEquals("Testing failed withdrawal of 205", "100.00", myAccount.currentBalance().toString());
    }

    @Test
    public void currentBalanceBigDecimalTest()
    {
        BankAccount myAccount = new BankAccount(12345);
        assertEquals("Testing initial balance", "0.00", myAccount.currentBalance().toString());
    }

    @Test
    public void currentBalanceAsStringTest()
    {
        BankAccount myAccount = new BankAccount(12345);
        assertEquals("Testing initial balance", "0.00", myAccount.currentBalanceAsString());

        BigDecimal dep = new BigDecimal("12345678901234567890.45");
        myAccount.deposit(dep);
        assertEquals("Testing large balance", "12345678901234567890.45", myAccount.currentBalanceAsString());

    }

}
