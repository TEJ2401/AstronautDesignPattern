package structural.decorator;



public class BasicCar implements Car {

    @Override
    public String getDescription() {
        return "Basic Car Model";
    }

    @Override
    public double getCost() {
        return 20000.00;
    }
}
