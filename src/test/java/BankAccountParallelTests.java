import annotations.BankAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelTests {
    @Test
    void depositTest1(BankAccount account) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.deposit(500);

        assertEquals(500, account.getBalance());
    }
    @Test
    void depositTest2(BankAccount account) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.deposit(500);

        assertEquals(500, account.getBalance());
    }
    @Test
    void depositTest3(BankAccount account) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.deposit(500);

        assertEquals(500, account.getBalance());
    }
    @Test
    void depositTest4(BankAccount account) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.deposit(500);

        assertEquals(500, account.getBalance());
    }

}
