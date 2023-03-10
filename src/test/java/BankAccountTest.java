import annotations.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Bank account tests")
class BankAccountTest {

    @Test
    @DisplayName("Should deposit into an account correctly")
    void depositTest() {
        BankAccount account = new BankAccount(0, 200);

        account.deposit(300);

        assertEquals(500, account.getBalance());

        assertThrows(RuntimeException.class, () -> account.deposit(-2));
    }

    @Test
    @DisplayName("Should withdraw from an account correctly")
    void withdrawTest() {
        BankAccount account = new BankAccount(0, 500);

        account.withdraw(300);

        assertEquals(200, account.getBalance());

        assertThrows(RuntimeException.class, () -> account.withdraw(1000));
    }

    @Test
    @DisplayName("Withdrawal for accounts with minimum balance of below zero should allow withdrawals past zero")
    void withdrawalPastZeroTest() {
        BankAccount account = new BankAccount(-3000, 500);

        account.withdraw(2000);

        assertNotEquals(0, account.getBalance());
        assertEquals(-1500, account.getBalance());
    }

    @Test
    @DisplayName("An account should default to active state after creation")
    void accountActiveAfterCreation() {
        BankAccount account = new BankAccount(7888, 899);

        assertTrue(account.isActive());
    }

    @Test
    @DisplayName("Withdrawing below the minimum balance should throw a Runtime exception")
    void withdrawingBelowMinimumTest() {
        BankAccount account = new BankAccount(-1000, 500);

        assertThrows(RuntimeException.class, () -> account.withdraw(3000));
    }

    @Test
    @DisplayName("Depositing should take less than 1 nanoseconds")
    void depositTimeoutTest(){
        BankAccount account = new BankAccount(0, 0);
        assertTimeout(Duration.ofNanos(1),() -> account.deposit(500));
    }
}