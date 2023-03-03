import annotations.BankAccount;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountOrderedExecutionTests {
    static BankAccount account = new BankAccount(0, 0);

    @Test
    @DisplayName("Should withdraw correctly from an account")
    @Order(2)
    void withdrawTest() {
        account.withdraw(300);

        assertEquals(200, account.getBalance());
    }

    @Test
    @Order(1)
    @DisplayName("Should deposit correctly into an account")
    void depositTest() {
        account.deposit(500);

        assertEquals(500, account.getBalance());
    }
}
