package CommandSablon;

public class CommandInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void invoke() {
        if (command != null) {
            command.execute();
        }
    }
}
