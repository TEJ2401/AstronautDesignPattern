package creational.factory;


public class ReactProject implements Project {
    private Logger logger = new Logger();

    @Override
    public void createProject() {
        logger.log("Creating React project...");
        // Simulating project initialization using React commands
        logger.log("Running `npx create-react-app my-app`...");
    }

    @Override
    public void installDependencies() {
        logger.log("Installing dependencies for React...");
        // Simulate installing dependencies
    }

    @Override
    public void startDevelopmentServer() {
        logger.log("Starting React development server...");
        // Simulating running the React server
        logger.log("Running `npm start`...");
    }
}
