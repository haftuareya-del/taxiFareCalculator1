package farecalculator1.model;

public class BajajTaxi extends Taxi {

    public BajajTaxi() {
        super("Bajaj Taxi", 30, 6, 1.5, 4);
    }

    @Override
    public double calculateFare(double distance, double time) {
        return baseFare + (distance * ratePerKm)
                + (time * ratePerMinute);
    }
}
