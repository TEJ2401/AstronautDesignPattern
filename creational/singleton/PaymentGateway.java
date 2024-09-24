package creational.singleton;

public class PaymentGateway {
    private static PaymentGateway instance;

    private PaymentGateway() {}

    // Public static method to get the single instance
    public static PaymentGateway getInstance() {
        if (instance == null) {
            synchronized (PaymentGateway.class) {
                if (instance == null) {
                    instance = new PaymentGateway();
                }
            }
        }
        return instance;
    }

    public boolean processPayment(String customerName, double amount) {
        System.out.println("Processing payment of $" + amount + " for " + customerName);
        return true; // Simulate successful payment
    }
}
