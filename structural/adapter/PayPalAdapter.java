package structural.adapter;
import java.util.logging.Logger;

public class PayPalAdapter implements PaymentProcessor {
    private PayPalService payPalService;
    private static final Logger logger = Logger.getLogger(PayPalAdapter.class.getName());

    public PayPalAdapter() {
        this.payPalService = new PayPalService();
    }

    @Override
    public void processPayment(double amount) throws PaymentException {
        if (amount <= 0) {
            throw new PaymentException("Invalid amount: " + amount);
        }
        logger.info("Adapting payment for $" + amount + " to PayPal service.");
        payPalService.makePayment(amount);
    }
}
