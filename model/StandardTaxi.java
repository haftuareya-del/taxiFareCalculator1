package farecalculator1.model;

public class StandardTaxi extends Taxi {

    public enum StandardType {
        PUBLIC, PRIVATE
    }

    private StandardType type;
    private double waitingCharge;

    public StandardTaxi(StandardType type) {

        super("Standard Taxi", 50, 8, 2,
                (type == StandardType.PUBLIC) ? 40 : 12);

        this.type = type;

        if (type == StandardType.PUBLIC) {
            waitingCharge = 5;
        } else {
            waitingCharge = 0;
        }
    }

    @Override
    public double calculateFare(double distance, double time) {
        return baseFare + (distance * ratePerKm)
                + (time * ratePerMinute) + waitingCharge;
    }

    @Override
    public void displayTaxiInfo() {
        super.displayTaxiInfo();
        System.out.println("Standard Type   : " + type);
        System.out.println("Waiting Charge : " + waitingCharge);
    }
}
