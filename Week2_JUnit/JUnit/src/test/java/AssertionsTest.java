import org.example.Calculator;
import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {
    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3);

        // Assert true
        assertTrue(5 > 3);

        // Assert false
        assertFalse(5 < 3);

        // Assert null
        assertNull(null);

        // Assert not null
        assertNotNull(new Object());

        // Additional useful assertions
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        assertNotEquals(5, 2 + 2);
    }
}
