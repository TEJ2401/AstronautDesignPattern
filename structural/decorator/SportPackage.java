package structural.decorator;

import java.util.logging.Logger;

public class SportPackage extends CarOptionsDecorator {
    private static final Logger logger = Logger.getLogger(SportPackage.class.getName());

    public SportPackage(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sport Package (Alloy Wheels, Sport Suspension)";
    }

    @Override
    public double getCost() {
        logger.info("Adding Sport Package cost.");
        return super.getCost() + 3000.00;
    }
}
