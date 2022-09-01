package C1_Pattern.C_behavior;

import java.util.ArrayList;
import java.util.List;

interface  Command{
    void execute();
    void revert();
}

class MouseClick implements Command{

    @Override
    public void execute() {
        System.out.println("click command");
    }

    @Override
    public void revert() {
        System.out.println("revert");
    }
}

class MousePress implements Command{

    @Override
    public void execute() {
        System.out.println("click mouse pressed");
    }

    @Override
    public void revert() {
        System.out.println("revert");
    }
}

//----------------------- обработчик команд --------------------------
class Receiver{
    List<Command> commands = new ArrayList<>();

    void addCommand(Command command){
        commands.add(command);
    }

    void RunCommand(){
        try {
            for (Command el : commands)
                el.execute();
        } catch (Exception e){
            for (Command el : commands)
                el.revert();
        }
    }
}

//------------------------------------------------------------------
public class O2_Command {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
            receiver.addCommand(new MouseClick());
            receiver.addCommand(new MousePress());
        receiver.RunCommand();
    }
}
