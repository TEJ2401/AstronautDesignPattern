package structural.decorator;

public abstract class CarOptionsDecorator implements Car {
    protected Car decoratedCar;

    public CarOptionsDecorator(Car car) {
        this.decoratedCar = car;
    }

    @Override
    public String getDescription() {
        return decoratedCar.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCar.getCost();
    }
}