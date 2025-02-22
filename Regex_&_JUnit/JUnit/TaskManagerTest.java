import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class TaskManager {
    public String longRunningTask() {
        try {
            Thread.sleep(3000); // Simulating a long-running task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Completed";
    }
}

class TaskManagerTest {
    private final TaskManager taskManager = new TaskManager();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTaskTimeout() {
        taskManager.longRunningTask(); // This test should fail as it exceeds 2 seconds
    }
}
