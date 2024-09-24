package creational.factory;

public class ProjectFactory {

    public Project createProject(String type) {
        switch (type.toLowerCase()) {
            case "react":
                return new ReactProject();
            case "nextjs":
                return new NextJsProject();
            case "vite":
                return new ViteProject();
            default:
                throw new IllegalArgumentException("Unknown project type: " + type);
        }
    }
}
