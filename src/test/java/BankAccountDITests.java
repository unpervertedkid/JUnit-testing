import annotations.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountDITests {
    @Test
    @DisplayName("Should deposit into an account correctly")
    void depositTest(BankAccount account) {
        account.deposit(500);

        assertEquals(500, account.getBalance());
    }
}
