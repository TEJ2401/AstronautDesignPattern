package structural.adapter;

import java.util.logging.Logger;

public class PayPalService {
    private static final Logger logger = Logger.getLogger(PayPalService.class.getName());

    public void makePayment(double amount) {
        logger.info("Processing payment of $" + amount + " via PayPal.");
        // Here you could add additional payment logic or interactions with PayPal's API
    }
}
