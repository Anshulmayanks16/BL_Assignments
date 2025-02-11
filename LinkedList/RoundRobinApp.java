class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // Add process at the end
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head; // Circular link
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
    }

    // Remove process by Process ID
    private void removeProcess(int processId) {
        if (head == null) return;

        Process current = head;
        Process prev = tail;

        do {
            if (current.processId == processId) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                }
                System.out.println("Process " + processId + " completed and removed from queue.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    // Simulate Round Robin Scheduling
    public void simulateScheduling() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int currentTime = 0;
        int totalProcesses = countProcesses();
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;

        Process current = head;

        while (totalProcesses > 0) {
            if (current.remainingTime > 0) {
                int executedTime = Math.min(current.remainingTime, timeQuantum);
                currentTime += executedTime;
                current.remainingTime -= executedTime;

                if (current.remainingTime == 0) {
                    int turnAroundTime = currentTime;
                    int waitingTime = turnAroundTime - current.burstTime;

                    totalWaitingTime += waitingTime;
                    totalTurnAroundTime += turnAroundTime;

                    removeProcess(current.processId);
                    totalProcesses--;
                }
            }
            current = current.next;
            displayProcesses();
        }

        double avgWaitingTime = (double) totalWaitingTime / countProcesses();
        double avgTurnAroundTime = (double) totalTurnAroundTime / countProcesses();

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turn-Around Time: " + avgTurnAroundTime);
    }

    // Display the list of processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process temp = head;
        System.out.println("Current Processes in Queue:");
        do {
            System.out.println("Process ID: " + temp.processId + ", Remaining Time: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    // Count total processes
    private int countProcesses() {
        if (head == null) return 0;
        int count = 0;
        Process temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

public class RoundRobinApp {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4); // Time Quantum = 4 units

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);

        scheduler.displayProcesses();

        System.out.println("\nStarting Round Robin Scheduling:\n");
        scheduler.simulateScheduling();
    }
}
