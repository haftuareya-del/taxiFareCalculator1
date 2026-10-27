package farecalculator1.model;

/**
 * Abstract parent class for all taxis
 */
public abstract class Taxi {

    protected String taxiType;
    protected double baseFare;
    protected double ratePerKm;
    protected double ratePerMinute;
    protected int maxPassengers;

    public Taxi(String taxiType,
                double baseFare,
                double ratePerKm,
                double ratePerMinute,
                int maxPassengers) {

        this.taxiType = taxiType;
        this.baseFare = baseFare;
        this.ratePerKm = ratePerKm;
        this.ratePerMinute = ratePerMinute;
        this.maxPassengers = maxPassengers;
    }

    // abstract method (must be implemented by child classes)
    public abstract double calculateFare(double distance, double time);

    public void displayTaxiInfo() {
        System.out.println("Taxi Type       : " + taxiType);
        System.out.println("Base Fare       : " + baseFare);
        System.out.println("Rate per Km     : " + ratePerKm);
        System.out.println("Rate per Minute : " + ratePerMinute);
        System.out.println("Max Passengers  : " + maxPassengers);
    }
}
