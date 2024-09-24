package command;

import utilities.*;

public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        Validator.validateNotNull(light, "Light");
        this.light = light;
    }

    @Override
    public void execute() {
        LogManager.logInfo("Executing: Turning light OFF");
        light.off();
    }

    @Override
    public void undo() {
        LogManager.logInfo("Undoing: Turning light ON");
        light.on();
    }
}
