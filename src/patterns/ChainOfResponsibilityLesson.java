package patterns;

public class ChainOfResponsibilityLesson {
    public static void main(String[] args) {
        MessagePrinter messagePrinter = new ConsoleMessagePrinter();
        FileMessagePrinter fileMessagePrinter = new FileMessagePrinter();
        messagePrinter.setNextMessagePrinter(fileMessagePrinter);
        fileMessagePrinter.setNextMessagePrinter(new DbMessagePrinter());
        messagePrinter.print("hello");
    }
}

abstract class MessagePrinter {
    MessagePrinter nextMessagePrinter;
    void setNextMessagePrinter(MessagePrinter messagePrinter) {
        nextMessagePrinter = messagePrinter;
    }

    void print(String message) {
        printMessage(message);
        if (nextMessagePrinter != null) {
            nextMessagePrinter.print(message);
        }
    }
    abstract void printMessage(String message);
}

class ConsoleMessagePrinter extends MessagePrinter {
    @Override
    void printMessage(String message) {
        System.out.println("print to console: " + message);
    }
}

class FileMessagePrinter extends MessagePrinter {
    @Override
    void printMessage(String message) {
        System.out.println("print to file: " + message);
    }
}

class DbMessagePrinter extends MessagePrinter {
    @Override
    void printMessage(String message) {
        System.out.println("print to db: " + message);
    }
}