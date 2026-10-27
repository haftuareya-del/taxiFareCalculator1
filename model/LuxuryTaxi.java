package farecalculator1.model;

public class LuxuryTaxi extends Taxi {
    private double tripTime;

    public enum LuxuryType {
        YANGO, SEREGELA, RIDE
    }

    private LuxuryType luxuryType;
    private double discount;

    public LuxuryTaxi(LuxuryType luxuryType) {

        super("Luxury Taxi", 100, 15, 5, 2);

        this.luxuryType = luxuryType;

        if (luxuryType == LuxuryType.YANGO) {
            discount = 0.05;
        } else if (luxuryType == LuxuryType.SEREGELA) {
            discount = 0.03;
        } else {
            discount = 0.0;
        }
    }
    public void setTripTime(double tripTime) {
        this.tripTime = tripTime;
    }


    @Override
    public double calculateFare(double distance, double time) {
        double fare = baseFare + (distance * ratePerKm)
                + (tripTime* ratePerMinute);
        return fare - (fare * discount);
    }

    @Override
    public void displayTaxiInfo() {
        super.displayTaxiInfo();
        System.out.println("Luxury Company  : " + luxuryType);
        System.out.println("Free Services   : Water, AC, Comfortable Seats");
    }
}
