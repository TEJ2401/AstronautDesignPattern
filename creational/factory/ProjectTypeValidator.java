package creational.factory;

public class ProjectTypeValidator {
    public void validate(String projectType) {
        if (projectType == null || projectType.isEmpty()) {
            throw new IllegalArgumentException("Project type cannot be null or empty.");
        }
        
        if (!(projectType.equalsIgnoreCase("react") ||
              projectType.equalsIgnoreCase("nextjs") ||
              projectType.equalsIgnoreCase("vite"))) {
            throw new IllegalArgumentException("Unknown project type: " + projectType);
        }
    }
}
