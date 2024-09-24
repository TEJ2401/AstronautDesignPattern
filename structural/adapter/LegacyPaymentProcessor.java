package structural.adapter;

import java.util.logging.Logger;

public class LegacyPaymentProcessor implements PaymentProcessor {
    private static final Logger logger = Logger.getLogger(LegacyPaymentProcessor.class.getName());

    @Override
    public void processPayment(double amount) throws PaymentException {
        validateAmount(amount);
        // Simulate payment processing
        logger.info("Processing payment of $" + amount + " via legacy payment system.");
        System.out.println("Processing payment of $" + amount + " via legacy payment system.");
    }

    private void validateAmount(double amount) throws PaymentException {
        if (amount <= 0) {
            throw new PaymentException("Invalid amount: " + amount);
        }
    }
}
