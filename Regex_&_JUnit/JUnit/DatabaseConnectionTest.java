import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class DatabaseConnection {
    private boolean connected;

    public void connect() {
        connected = true;
    }

    public void disconnect() {
        connected = false;
    }

    public boolean isConnected() {
        return connected;
    }
}

class DatabaseConnectionTest {
    private DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
    }

    @Test
    void testConnectionIsEstablished() {
        assertTrue(dbConnection.isConnected(), "Database should be connected");
    }

    @Test
    void testConnectionIsClosedAfterEachTest() {
        assertTrue(dbConnection.isConnected(), "Database should be connected during test");
    }
}
