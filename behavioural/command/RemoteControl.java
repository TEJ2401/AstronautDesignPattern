package command;

import utilities.LogManager;

public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            LogManager.logInfo("Button pressed.");
            command.execute();
        } else {
            LogManager.logWarning("No command assigned to the button.");
            System.out.println("No command assigned to the button.");
        }
    }

    public void pressUndo() {
        if (command != null) {
            LogManager.logInfo("Undo button pressed.");
            command.undo();
        } else {
            LogManager.logWarning("No command to undo.");
            System.out.println("No command to undo.");
        }
    }
}
