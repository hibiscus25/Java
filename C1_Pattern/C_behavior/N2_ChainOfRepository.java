package C1_Pattern.C_behavior;



abstract class MessagePrinter{
    MessagePrinter nextMessagePrinter;

    void setNextMessagePrinter (MessagePrinter messagePrinter){         // присвоение значения переменной
        nextMessagePrinter = messagePrinter;
    }

    void print (String message){
        printMessage (message);
        if(nextMessagePrinter != null){
            nextMessagePrinter.print(message);
        }
    }

    abstract void printMessage (String messsage);
}



class ConsoleMessagePrinter extends MessagePrinter {
    @Override
    void printMessage(String message){
        System.out.println("print to console: " + message);
    }
}


class FileMessagePrinter extends MessagePrinter{
    @Override
    void printMessage(String messsage) {
        System.out.println("print to file: " + messsage);
    }
}


class DbMessagePrinter extends MessagePrinter{
    @Override
    void printMessage(String message){
        System.out.println("print to Db: " + message);
    }
}

class EmMessagePrinter extends MessagePrinter{
    @Override
    void printMessage(String message){
        System.out.println("print to Em: " + message);
    }
}


//----------------------------------------------------------------------------------------
public class N2_ChainOfRepository {
    public static void main(String[] args) {
        MessagePrinter messagePrinter = new ConsoleMessagePrinter();
        FileMessagePrinter fileMessagePrinter = new FileMessagePrinter();
        DbMessagePrinter DbMessagePrinter = new DbMessagePrinter();

        messagePrinter.setNextMessagePrinter(fileMessagePrinter);
        fileMessagePrinter.setNextMessagePrinter(DbMessagePrinter);
        DbMessagePrinter.setNextMessagePrinter(new EmMessagePrinter());

        messagePrinter.print("Hello");
    }
}