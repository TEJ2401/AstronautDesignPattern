package structural.decorator;

public class LeatherSeats extends CarOptionsDecorator {
    public LeatherSeats(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Leather Seats";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1200.00;
    }
}
