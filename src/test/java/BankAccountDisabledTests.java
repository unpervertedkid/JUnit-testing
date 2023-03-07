import annotations.BankAccount;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountDisabledTests {
    @Test
    @Disabled("Disabled until bug #99 has been fixed")
    @DisplayName("Should deposit into an account correctly")
    void depositTest(BankAccount account) {
        account.deposit(500);

        assertEquals(500, account.getBalance());
    }
}
