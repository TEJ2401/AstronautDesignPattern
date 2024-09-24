package creational.factory;

public class Logger {
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }

    public void error(String message) {
        System.err.println("[ERROR] " + message);
    }
}

