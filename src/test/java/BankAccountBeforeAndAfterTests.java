import annotations.BankAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountBeforeAndAfterTests {
    static BankAccount account;

    @BeforeEach
    void setup(){
        account = new BankAccount(0,0);
    }

    @Test
    void depositTest() {
        account.deposit(500);

        assertEquals(500, account.getBalance());
    }

    @Test
    void withdrawTest() {
        account.deposit(500);
        account.withdraw(500);

        assertEquals(0, account.getBalance());
    }

    @AfterEach
    void tearDown(){
        account = null;
    }
}
