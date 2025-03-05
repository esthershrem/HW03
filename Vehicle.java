package HW03;

/**
 * Represents a vehicle to get around the city.
 * @version 1.0
 * @author Esther Shrem
 */
public abstract class Vehicle {
    private final String id;
    private double earnings;
    private int numMiles;
    private String[] passengers;

    /**
     * Constructs for Vehicle.
     *
     * @param id the identifier of this vehicle
     * @param numMiles the number of miles this vehicle has travelled
     * @param passengers the passengers aboard this vehicle
     */
    public Vehicle(String id, int numMiles, String[] passengers) {
        this.id = id;
        this.numMiles = numMiles;
        this.passengers =  passengers;
        this.earnings = 0.0;
    }

    /**
     * Constructs for Vehicle.
     *
     * @param id the identifier of this vehicle
     * @param passengers the passengers aboard this vehicle
     */
    public Vehicle(String id, String[] passengers) {
        // this(id, 0, passengers);
        this.id = id;
        this.passengers = passengers;
        this.numMiles = 0;
        this.earnings = 0.0;
    }

    /**
     * Abstract method to check if the vehicle can drive the specified distance.
     *
     * @param distance the distance to travel
     * @return true if the vehicle can travel the specified distance, false otherwise
     */
    public abstract boolean canDrive(int distance);

    /**
     * Abstract method to calculate the cost of travelling the specified distance.
     *
     * @param distance the distance to travel
     * @return the cost for this vehicle to travel that far
     */
    public abstract double calculateCost(int distance);

    /**
     * Abstract method to add passengers and check if they fit in the vehicle.
     *
     * @param distance the distance to travel
     * @param newPassengers the new passengers to add
     * @return true if all new passengers can fit and the vehicle can travel the distance, false otherwise
     */
    public abstract boolean addPassengers(int distance, String[] newPassengers);

    /**
     * Charges the ride by updating numMiles and earnings.
     *
     * @param distance the distance to travel
     */
    public void chargeRide(int distance) {
        if (candrive(distance)) {
            this.numMiles += distance;
            this.earnings += calculateCost(distance);
        }
    }

    /**
     * Charges the ride by updating numMiles and earnings for multiple passengers.
     *
     * @param distance the distance to travel
     * @param newPassengers the new passengers to add
     */
    public void chargeRide(int distance, int numPassangers) {
        if (canDrive(distance)) {
            this.numMiles += distance;
            this.earnings += calculateCost(distance) * numPassangers;
        }
    }

    @Override
    public boolean equals() {
        return this.id == this.numMiles;
    }
    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj) return true;
    //     if (obj == null || getClass() != obj.getClass()) return false;
    //     Vehicle vehicle = (Vehicle) obj;
    //     return numMiles == vehicle.numMiles && id.equals(vehicle.id);
    // }

    @Override
    public String toString() {
        return String.format("%s has travelled %d miles and has earned %.2f dollars.", id, numMiles, earnings);
    }

    /**
     * Gets the the ID.
     *
     * @return the ID
     */
    public String getID() {
        return id;
    }

    /**
     * Gets the the earnings.
     *
     * @return the earnings
     */
    public double getEarnings() {
        return earnings;
    }

    /**
     * Gets the the number of miles.
     *
     * @return the number of miles
     */
    public int getNumMiles() {
        return numMiles;
    }

    /**
     * Gets the the array of pasangers.
     *
     * @return the array of passengers
     */
    public String[] getPassengers() {
        return passengers;
    }

    public void setPassengers(String[] passengers) {
        this.passengers = passengers;
    }
}
