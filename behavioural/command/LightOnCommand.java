package command;

import utilities.*;

public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        Validator.validateNotNull(light, "Light");
        this.light = light;
    }

    @Override
    public void execute() {
        LogManager.logInfo("Executing: Turning light ON");
        light.on();
    }

    @Override
    public void undo() {
        LogManager.logInfo("Undoing: Turning light OFF");
        light.off();
    }
}
