import annotations.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountNestedTests {

    @Test
    @DisplayName("Should deposit correctly into account")
    void depositTest() {
        BankAccount account = new BankAccount(0, 0);

        account.deposit(500);

        assertEquals(500, account.getBalance());
    }

    @Test
    @DisplayName("Should withdraw from account correctly")
    void withdrawalTest() {
        BankAccount account = new BankAccount(0, 500);

        account.withdraw(300);

        assertEquals(200,account.getBalance());
    }

    @Nested
    class WhenBalanceEqualsZero {
        @Test
        @DisplayName("Withdrawing below minimum balance should throw a Runtime exception")
        void withdrawalBelowMinimumBalanceTest() {
            BankAccount account = new BankAccount(0, 0);

            assertThrows(RuntimeException.class, () -> account.withdraw(500));
        }

        @Test
        @DisplayName("Withdrawing below zero but above the minimum balance should not throw an exception")
        void withdrawBelowZeroAboveMinimumBalanceTest() {
            BankAccount account = new BankAccount(-1000, 0);

            account.withdraw(500);

            assertEquals(-500, account.getBalance());
        }
    }
}
