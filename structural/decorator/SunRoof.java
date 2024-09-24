package structural.decorator;

import java.util.logging.Logger;

public class SunRoof extends CarOptionsDecorator {
    private static final Logger logger = Logger.getLogger(SunRoof.class.getName());

    public SunRoof(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sun Roof";
    }

    @Override
    public double getCost() {
        logger.info("Adding Sun Roof cost.");
        return super.getCost() + 800.00;
    }
}
