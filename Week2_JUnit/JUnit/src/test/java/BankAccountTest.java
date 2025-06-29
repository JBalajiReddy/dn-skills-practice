import org.example.BankAccount;
import org.junit.*;
import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount account;
    private static int testCount = 0;

    // This runs ONCE before all tests
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Starting BankAccount tests...");
    }

    // This runs before EACH test
    @Before
    public void setUp() {
        account = new BankAccount("John Doe", 1000.00);
        testCount++;
        System.out.println("Setting up for test #" + testCount);
    }

    // Test using AAA pattern
    @Test
    public void testDeposit() {
        // Arrange
        double initialBalance = account.getBalance();
        double depositAmount = 500.00;

        // Act
        account.deposit(depositAmount);

        // Assert
        assertEquals(initialBalance + depositAmount, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        // Arrange
        double initialBalance = account.getBalance();
        double withdrawAmount = 200.00;

        // Act
        account.withdraw(withdrawAmount);

        // Assert
        assertEquals(initialBalance - withdrawAmount, account.getBalance(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawMoreThanBalance() {
        // Arrange
        double withdrawAmount = account.getBalance() + 1;

        // Act & Assert (the annotation expects the exception)
        account.withdraw(withdrawAmount);
    }

    // This runs after EACH test
    @After
    public void tearDown() {
        System.out.println("Cleaning up after test #" + testCount);
    }

    // This runs ONCE after all tests
    @AfterClass
    public static void afterClass() {
        System.out.println("Finished all BankAccount tests. Total tests run: " + testCount);
    }
}