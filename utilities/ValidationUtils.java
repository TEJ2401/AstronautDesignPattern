package utilities;

public class ValidationUtils {
    public static boolean isValidHealth(int health) {
        return health >= 0 && health <= 100;
    }
}
