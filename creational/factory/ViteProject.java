package creational.factory;

public class ViteProject implements Project {
    private Logger logger = new Logger();

    @Override
    public void createProject() {
        logger.log("Creating Vite project...");
        // Simulating project initialization using Vite commands
        logger.log("Running `npm create vite@latest`...");
    }

    @Override
    public void installDependencies() {
        logger.log("Installing dependencies for Vite...");
        // Simulate installing dependencies
    }

    @Override
    public void startDevelopmentServer() {
        logger.log("Starting Vite development server...");
        // Simulating running the Vite server
        logger.log("Running `npm run dev`...");
    }
}
