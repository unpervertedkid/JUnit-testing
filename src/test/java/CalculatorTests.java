import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@DisplayName("Calculator tests")
public class CalculatorTests {
    @Test
    @DisplayName("Should perform divisions correctly")
    public void divisionTests(){
        Calculator calculator = new Calculator();

        assertEquals(10,calculator.divide(100,10));
        assertThrows(ArithmeticException.class,() -> calculator.divide(100,0));
    }
}
