import annotations.BankAccount;
import annotations.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTests {
    @ParameterizedTest
    @ValueSource(ints = {100, 200, 300, 400, 500})
    @DisplayName("Should deposit into an account correctly")
    void depositTest(int amount,BankAccount account) {
        account.deposit(amount);

        assertEquals(amount, account.getBalance());

    }

    @ParameterizedTest
    @EnumSource(value = State.class, names = {"ACTIVE", "INACTIVE"})
    @DisplayName("Should set the state of an account correctly")
    void setStateTest(State state, BankAccount account) {
        account.setState(state);

        assertEquals(state, account.getState());
    }

    @ParameterizedTest
    @CsvSource({
            "John, 100",
            "Jane, 200",
            "Jack, 300",
            "Jill, 400",
            "Jenny, 500"
    })
    void testDepositAndName(String name, int amount, BankAccount account){
        account.deposit(amount);
        account.setHolderName(name);

        assertEquals(amount, account.getBalance());
        assertEquals(name, account.getHolderName());
    }
    @ParameterizedTest
    @CsvFileSource(resources = "Customer info.csv")
    void testDepositAndNameFromCSV(String name, int amount, BankAccount account){
        account.deposit(amount);
        account.setHolderName(name);

        assertEquals(amount, account.getBalance());
        assertEquals(name, account.getHolderName());
    }
}
