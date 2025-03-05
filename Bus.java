/**
 * Represents a regular car in the transportation network and is a concrete subtype of Vehicle.
 * @version 1.0
 * @author Esther Shrem
 */
public class Car extends Vehicle {
    private double rate;
    private double fees;
    private int maxNumMiles;

    /**
     * Constructs for Car.
     *
     * @param id the identifier of this vehicle
     * @param numMiles the number of miles this vehicle has travelled
     * @param passengers the passengers aboard this vehicle
     * @param rate the cost of using this car to travel one mile
     * @param fees the fee charge to the ride to use this car once
     * @param maxNumMiles the maximum number of miles that this car can travel before it is retired
     */
    public Car(String id, int numMiles, String[] passengers, double rate, double fees, int maxNumMiles) {
        super(id, numMiles, passengers);
        this.rate = rate;
        this.fees = fees;
        this.maxNumMiles = maxNumMiles;
    }

    /**
     * Constructs for Car.
     *
     * @param id the identifier of this vehicle
     * @param numMiles the number of miles this vehicle has travelled
     * @param maxNumMiles the maximum number of miles that this car can travel before it is retired
     */
    public Car(String id, int numMiles, int maxNumMiles) {
        this(id, numMiles, new String[4], 10.0, 15.0, maxNumMiles);
    }

    /**
     * Constructs for Car.
     *
     * @param id the identifier of this vehicle
     */
    public Car(String id) {
        this(id, 0, 200);
    }

    @Override
    public boolean canDrive(int distance) {
        return distance >= 0 && (getNumMiles() + distance) <= maxNumMiles;
    }

    @Override
    public double calculateCost(int distance) {
        if (!canDrive(distance) || distance < 0) {
            return -1.0;
        }
        return (distance * rate) + fees;
    }

    @Override
    public boolean addPassengers(int distance, String[] newPassengers) {
        if (!canDrive(distance)) {
            return false;
        }
        int availableSeats = 0;
        for (String passenger : getPassengers()) {
            if (passenger == null) {
                availableSeats++;
            }
        }
        if (newPassengers.length > availableSeats) {
            return false;
        }
        int index = 0;
        for (int i = 0; i < getPassengers().length && index < newPassengers.length; i++) {
            if (getPassengers()[i] == null) {
                getPassengers()[i] = newPassengers[index++];
            }
        }
        chargeRide(distance);
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Car car = (Car) obj;
        return Double.compare(car.rate, rate) == 0
                && Double.compare(car.fees, fees) == 0
                && maxNumMiles == car.maxNumMiles;
    }

    @Override
    public String toString() {
        return String.format("Car %s has travelled %d miles and has earned %d dollars. "
            + "It can only drive %d miles. It costs %.2f dollars per mile and there is "
            + "a one-time fee of %.2f dollars.",
            getID(), getNumMiles(), getEarnings(), maxNumMiles, rate, fees);
    }

    /**
     * Gets the cost of using this car to travel one mile.
     *
     * @return the cost of using this car to travel one mile
     */
    public double getRate() {
        return rate;
    }

    /**
     * Gets the fee charge to the ride to use this car once.
     *
     * @return the fee charge to the ride to use this car once
     */
    public double getFees() {
        return fees;
    }

    /**
     * Gets the maximum number of miles that this car can travel before it is retired.
     *
     * @return the maximum number of miles that this car can travel before it is retired
     */
    public int getMaxNumMiles() {
        return maxNumMiles;
    }
}
