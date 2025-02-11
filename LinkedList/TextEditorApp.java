class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState head, current;
    private int size, maxSize = 10;

    public TextEditor() {
        head = new TextState("");
        current = head;
        size = 1;
    }

    // Add a new state when user types or performs an action
    public void addState(String newContent) {
        TextState newState = new TextState(newContent);
        newState.prev = current;
        current.next = newState;
        current = newState;

        // Remove redo history
        TextState temp = current.next;
        while (temp != null) {
            TextState toRemove = temp;
            temp = temp.next;
            toRemove.prev = null;
            toRemove.next = null;
        }
        current.next = null;

        // Maintain size limit
        size++;
        if (size > maxSize) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo functionality
    public void undo() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo functionality
    public void redo() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Display current state
    public void displayCurrentState() {
        System.out.println("Current Text: " + current.content);
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.displayCurrentState(); // Hello, World!

        editor.undo();
        editor.displayCurrentState(); // Hello, World

        editor.undo();
        editor.displayCurrentState(); // Hello

        editor.redo();
        editor.displayCurrentState(); // Hello, World

        editor.addState("Hello, Java World!");
        editor.displayCurrentState(); // Hello, Java World!

        editor.undo();
        editor.displayCurrentState(); // Hello, World

        editor.redo();
        editor.displayCurrentState(); // Hello, Java World!
    }
}
