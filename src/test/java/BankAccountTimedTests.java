import annotations.BankAccount;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimedTests {

    @ParameterizedTest
    @CsvFileSource(resources = "Customer info.csv")
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void depositsShouldTakeLessThan10ms(String name, int amount,BankAccount account) {
        account.deposit(amount);

        assertEquals(amount, account.getBalance());
    }


}
