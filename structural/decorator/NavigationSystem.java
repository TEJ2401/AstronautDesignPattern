package structural.decorator;
public class NavigationSystem extends CarOptionsDecorator {
    public NavigationSystem(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Navigation System";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1500.00;
    }
}