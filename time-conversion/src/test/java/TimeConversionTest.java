import org.junit.Test;

import static org.junit.Assert.*;

public class TimeConversionTest {

    @Test
    public void test_scenario_1() {

        // Given
        TimeConversion timeConversion = new TimeConversion("12:45:54PM");

        // When
        String conversion = timeConversion.convert();

        // Then
        assertEquals(conversion, "12:45:54");
    }

}