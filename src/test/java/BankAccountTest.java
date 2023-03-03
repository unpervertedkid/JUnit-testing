import annotations.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Bank account tests")
class BankAccountTest {

    @Test
    @DisplayName("Should deposit into an account correctly")
    void depositTest() {
        BankAccount account = new BankAccount(0,200);

        account.deposit(300);

        assertEquals(500,account.getBalance());

        assertThrows(RuntimeException.class, () -> account.deposit(-2));
    }

    @Test
    @DisplayName("Should withdraw from an account correctly")
    void withdrawTest() {
        BankAccount account = new BankAccount(0,500);

        account.withdraw(300);

        assertEquals(200, account.getBalance());

        assertThrows(RuntimeException.class, () -> account.withdraw(1000));
    }
}