import annotations.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class BankAssumptionsTests {

    @Test
    @DisplayName("An account should default to active state after creation")
    void accountActiveAfterCreation() {
        BankAccount account = new BankAccount(7888, 899);

        assumeTrue(account != null, "Bank account is null");
        assertTrue(account.isActive());

        //The above two methods can be replaced with
        assumingThat(account != null, () -> assumeTrue(account.isActive()));
    }


}
