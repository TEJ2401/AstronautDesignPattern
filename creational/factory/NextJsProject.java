package creational.factory;


public class NextJsProject implements Project {
    private Logger logger = new Logger();

    @Override
    public void createProject() {
        logger.log("Creating Next.js project...");
        // Simulating project initialization using Next.js commands
        logger.log("Running `npx create-next-app my-app`...");
    }

    @Override
    public void installDependencies() {
        logger.log("Installing dependencies for Next.js...");
        // Simulate installing dependencies
    }

    @Override
    public void startDevelopmentServer() {
        logger.log("Starting Next.js development server...");
        // Simulating running the Next.js server
        logger.log("Running `npm run dev`...");
    }
}
