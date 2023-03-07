import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class BankAccountConditionalTests {
    @Test
    @EnabledOnOs({OS.WINDOWS})
    void depositTest() {
        System.out.println("Windows");
    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    void withdrawTest() {
        System.out.println("Not Windows");
    }

    @Test
    @EnabledOnJre({JRE.JAVA_19})
    void withdrawalPastZeroTest() {
        System.out.println("Java 17");
    }

    @Test
    @DisabledOnJre({JRE.JAVA_19})
    void accountActiveAfterCreation() {
        System.out.println("Not Java 17");
    }
}
