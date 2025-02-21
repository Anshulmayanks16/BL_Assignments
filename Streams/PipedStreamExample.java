import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                String message = "Message " + i;
                pos.write(message.getBytes());
                System.out.println("Written: " + message);
                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Writer error: " + e.getMessage());
        } finally {
            try {
                pos.close();
            } catch (IOException e) {
                System.out.println("Error closing PipedOutputStream: " + e.getMessage());
            }
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = pis.read(buffer)) != -1) {
                System.out.println("Read: " + new String(buffer, 0, bytesRead));
            }
        } catch (IOException e) {
            System.out.println("Reader error: " + e.getMessage());
        } finally {
            try {
                pis.close();
            } catch (IOException e) {
                System.out.println("Error closing PipedInputStream: " + e.getMessage());
            }
        }
    }
}

public class PipedStreamExample {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            
            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);
            
            writer.start();
            reader.start();
        } catch (IOException e) {
            System.out.println("Error initializing pipes: " + e.getMessage());
        }
    }
}
